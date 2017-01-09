package sample.payara.mybatis.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import sample.payara.model.MyBatisUser;
import sample.payara.mybatis.param.MyBatisUserSearchParam;

public interface AppleMyBatisXmlMapper {

    public MyBatisUser findById(@Param("id") final Long id);

    public List<MyBatisUser> findByParam(@Param("param") final MyBatisUserSearchParam param);

}
