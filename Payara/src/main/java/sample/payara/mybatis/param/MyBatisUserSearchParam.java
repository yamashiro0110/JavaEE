package sample.payara.mybatis.param;

import java.util.Objects;

import javax.ws.rs.QueryParam;

import com.google.common.base.Strings;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class MyBatisUserSearchParam {
    @QueryParam("id")
    private Long id = null;
    @QueryParam("name")
    private String name;

    public boolean hasId() {
        return Objects.nonNull(id);
    }

    public boolean hasName() {
        return !Strings.isNullOrEmpty(name);
    }
}
