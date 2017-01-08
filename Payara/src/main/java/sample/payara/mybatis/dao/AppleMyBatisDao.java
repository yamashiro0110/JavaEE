package sample.payara.mybatis.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;

import sample.payara.model.MyBatisUser;
import sample.payara.mybatis.mapper.AppleMyBatisMapper;
import sample.payara.mybatis.provider.MyBatisAppleSessionProvider;

@Stateless
public class AppleMyBatisDao {
    @Inject
    private MyBatisAppleSessionProvider provider;

    private AppleMyBatisMapper mapper() {
        SqlSession session = this.provider.sqlSession();
        return session.getMapper(AppleMyBatisMapper.class);
    }

    public List<MyBatisUser> findAll() {
        return mapper().findAll();
    }

    public MyBatisUser findBy(Long id) {
        return mapper().findBy(id);
    }

}
