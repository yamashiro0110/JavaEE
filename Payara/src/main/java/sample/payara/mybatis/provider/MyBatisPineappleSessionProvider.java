package sample.payara.mybatis.provider;

import javax.ejb.Stateless;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

@Stateless
public class MyBatisPineappleSessionProvider {
    private SqlSessionFactory sessionFactory;

    public MyBatisPineappleSessionProvider() {
        this.sessionFactory = MyBatisSqlSessionFactoryBuilder.create("pineapple");
    }

    public SqlSession sqlSession() {
        return this.sessionFactory.openSession();
    }

}
