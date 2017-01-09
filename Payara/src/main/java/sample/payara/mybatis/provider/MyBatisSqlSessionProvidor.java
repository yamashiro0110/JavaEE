package sample.payara.mybatis.provider;

import java.io.IOException;
import java.io.InputStream;
import java.io.UncheckedIOException;

import javax.ejb.Stateless;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Disposes;
import javax.enterprise.inject.Produces;
import javax.inject.Inject;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import sample.payara.mybatis.qualifier.AppleDataSource;
import sample.payara.mybatis.qualifier.PineappleDataSource;

@Stateless
public class MyBatisSqlSessionProvidor {
    @AppleDataSource
    @Inject
    private SqlSessionFactory appleSessionFactory;
    @PineappleDataSource
    @Inject
    private SqlSessionFactory pineappleSessionFactory;

    private SqlSessionFactory create(String environment) {
        try (InputStream stream = Resources.getResourceAsStream("mybatis-config.xml")) {
            SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
            return builder.build(stream, environment);
        } catch (IOException e) {
            throw new UncheckedIOException(e);
        }
    }

    @ApplicationScoped
    @AppleDataSource
    @Produces
    public SqlSessionFactory appleSessionFactory() {
        return this.create("apple");
    }

    @ApplicationScoped
    @PineappleDataSource
    @Produces
    public SqlSessionFactory pineappleSessionFactory() {
        return this.create("pineapple");
    }

    @RequestScoped
    @AppleDataSource
    @Produces
    public SqlSession appleSession() {
        return appleSessionFactory.openSession();
    }

    public void closeAppleSession(@Disposes @AppleDataSource SqlSession sqlSession) {
        // FIXME: closeは必要?
        sqlSession.close();
    }

    @RequestScoped
    @PineappleDataSource
    @Produces
    public SqlSession pineappleSession() {
        return pineappleSessionFactory.openSession();
    }

    public void closePineappleSession(@Disposes @PineappleDataSource SqlSession sqlSession) {
        // FIXME: closeは必要?
        sqlSession.close();
    }

}
