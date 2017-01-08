package sample.payara.mybatis.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import sample.payara.model.MyBatisUser;

public interface PineappleMyBatisMapper {

    @Results(id = "findByMybatisUser", value = {
            @Result(property = "id", column = "id", id = true),
            @Result(property = "name", column = "name"),
            @Result(property = "created", column = "created"),
            @Result(property = "updated", column = "updated"),
    })
    @Select({
        "select *",
        "from sample_model s",
        "where s.name like #{name}"
    })
    public List<MyBatisUser> findByName(@Param("name") String name);

}
