package sample.payara.mybatis.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;

import sample.payara.model.MyBatisUser;
import sample.payara.mybatis.param.MyBatisUserSearchParam;

public interface AppleMyBatisMapper {

    @Results(id = "findAllMybatisUser", value = {
            @Result(property = "id", column = "id", id = true),
            @Result(property = "name", column = "name"),
            @Result(property = "created", column = "created"),
            @Result(property = "updated", column = "updated"),
    })
    @Select({
        "select *",
        "from sample_model",
    })
    public List<MyBatisUser> findAll();

    @Results(id = "findByMybatisUser", value = {
            @Result(property = "id", column = "id", id = true),
            @Result(property = "name", column = "name"),
            @Result(property = "created", column = "created"),
            @Result(property = "updated", column = "updated"),
    })
    @Select({
        "select *",
        "from sample_model s",
        "where s.id = #{id}"
    })
    public MyBatisUser findById(@Param("id") Long id);

    @SelectProvider(type = MyBatisMapperSqlBuilder.class, method = "findByParamSql")
    public List<MyBatisUser> findByParam(@Param("param") MyBatisUserSearchParam param);

}
