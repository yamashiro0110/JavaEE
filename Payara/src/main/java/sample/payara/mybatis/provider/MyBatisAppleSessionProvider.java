package sample.payara.mybatis.provider;

import javax.ejb.Stateless;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

@Stateless
public class MyBatisAppleSessionProvider {
    private SqlSessionFactory sessionFactory;

    public MyBatisAppleSessionProvider() {
        this.sessionFactory = MyBatisSqlSessionFactoryBuilder.create("apple");
    }

    public SqlSession sqlSession() {
        return this.sessionFactory.openSession();
    }

}
