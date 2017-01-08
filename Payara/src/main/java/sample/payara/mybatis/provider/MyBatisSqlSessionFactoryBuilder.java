package sample.payara.mybatis.provider;

import java.io.IOException;
import java.io.InputStream;
import java.io.UncheckedIOException;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MyBatisSqlSessionFactoryBuilder {

    public static SqlSessionFactory create(String environment) {
        try (InputStream stream = Resources.getResourceAsStream("mybatis-config.xml")) {
            SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
            return builder.build(stream, environment);
        } catch (IOException e) {
            throw new UncheckedIOException(e);
        }
    }

}
