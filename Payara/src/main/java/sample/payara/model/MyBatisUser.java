package sample.payara.model;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class MyBatisUser {
    private Long id = null;
    private String name = "";
    private Date created = new Date();
    private Date updated = null;
}
