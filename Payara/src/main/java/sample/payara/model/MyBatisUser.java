package sample.payara.model;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
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
