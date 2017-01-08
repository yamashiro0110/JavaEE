package sample.payara.mybatis.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;

import sample.payara.model.MyBatisUser;
import sample.payara.mybatis.mapper.PineappleMyBatisMapper;
import sample.payara.mybatis.provider.MyBatisPineappleSessionProvider;

@Stateless
public class PineappleMyBatisDao {
    @Inject
    private MyBatisPineappleSessionProvider sessionProvider;

    private PineappleMyBatisMapper mapper() {
        SqlSession session = this.sessionProvider.sqlSession();
        return session.getMapper(PineappleMyBatisMapper.class);
    }

    public List<MyBatisUser> findByName(String name) {
        return mapper().findByName(name);
    }

}
