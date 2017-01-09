package sample.payara.mybatis.provider;

import java.io.IOException;
import java.io.InputStream;
import java.io.UncheckedIOException;

import javax.annotation.PostConstruct;
import javax.ejb.Stateless;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Produces;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import sample.payara.mybatis.qualifier.AppleDataSource;
import sample.payara.mybatis.qualifier.PineappleDataSource;

@Stateless
public class MyBatisSqlSessionProvidor {
    private SqlSessionFactory appleSessionFactory;
    private SqlSessionFactory pineappleSessionFactory;

    private SqlSessionFactory create(String environment) {
        try (InputStream stream = Resources.getResourceAsStream("mybatis-config.xml")) {
            SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
            return builder.build(stream, environment);
        } catch (IOException e) {
            throw new UncheckedIOException(e);
        }
    }

    @PostConstruct
    void postConstructor() {
        this.appleSessionFactory = this.create("apple");
        this.pineappleSessionFactory = this.create("pineapple");
    }

    @RequestScoped
    @AppleDataSource
    @Produces
    public SqlSession appleSession() {
        return appleSessionFactory.openSession();
    }

    @RequestScoped
    @PineappleDataSource
    @Produces
    public SqlSession pineappleSession() {
        return pineappleSessionFactory.openSession();
    }
}
