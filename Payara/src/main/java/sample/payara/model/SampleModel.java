package sample.payara.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "sample_model")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class SampleModel {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
	
	@Column(name = "name")
    private String name;
}
