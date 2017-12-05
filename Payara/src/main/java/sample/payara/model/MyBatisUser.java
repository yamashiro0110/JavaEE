package sample.payara.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
public class MyBatisUser {
    @JsonProperty
    private Long id = null;
    @JsonProperty
    private String name = "";
    @JsonProperty
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm")
    private Date created = new Date();
    @JsonProperty
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm")
    private Date updated = null;
}
