package sample.payara.mybatis.mapper;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.jdbc.SQL;

import sample.payara.mybatis.param.MyBatisUserSearchParam;

public class MyBatisMapperSqlBuilder {

    public String findByParamSql(@Param("param") final MyBatisUserSearchParam param) {
        SQL sql = new SQL()
                .SELECT("*")
                .FROM("sample_model s");

        if (param.hasId()) {
            sql.WHERE("s.id = #{param.id}");
        }

        if (param.hasName()) {
            sql.WHERE("s.name like #{param.name} ");
        }

        return sql.toString();
    }

}
