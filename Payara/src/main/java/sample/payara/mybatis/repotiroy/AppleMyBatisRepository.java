package sample.payara.mybatis.repotiroy;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;

import sample.payara.model.MyBatisUser;
import sample.payara.mybatis.mapper.AppleMyBatisMapper;
import sample.payara.mybatis.param.MyBatisUserSearchParam;
import sample.payara.mybatis.qualifier.AppleDataSource;

@Stateless
public class AppleMyBatisRepository {
    @AppleDataSource
    @Inject
    private SqlSession sqlSession;

    private AppleMyBatisMapper mapper() {
        return sqlSession.getMapper(AppleMyBatisMapper.class);
    }

    public List<MyBatisUser> findAll() {
        return mapper().findAll();
    }

    public MyBatisUser findBy(final Long id) {
        return mapper().findById(id);
    }

    public List<MyBatisUser> findBy(final MyBatisUserSearchParam param) {
        return mapper().findByParam(param);
    }

}
