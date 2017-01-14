package sample.payara.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "sample_model")
@NoArgsConstructor
@AllArgsConstructor
public class SampleModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonProperty
    private Long id = null;

    @Column(name = "name")
    @JsonProperty
    private String name = "";

    @Column(name = "created")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm")
    private Date created = new Date();

    @Column(name = "updated")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm")
    private Date updated = null;

    public SampleModel(final long id, final String name) {
        this.id = id;
        this.name = name;
    }

}
