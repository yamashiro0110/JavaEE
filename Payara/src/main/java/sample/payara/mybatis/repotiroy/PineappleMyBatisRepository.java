package sample.payara.mybatis.repotiroy;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;

import sample.payara.model.MyBatisUser;
import sample.payara.mybatis.mapper.PineappleMyBatisMapper;
import sample.payara.mybatis.qualifier.PineappleDataSource;

@Stateless
public class PineappleMyBatisRepository {
    @Inject
    @PineappleDataSource
    private SqlSession sqlSession;

    private PineappleMyBatisMapper mapper() {
        return sqlSession.getMapper(PineappleMyBatisMapper.class);
    }

    public List<MyBatisUser> findByName(String name) {
        return mapper().findByName(name);
    }

}
