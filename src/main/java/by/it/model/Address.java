package by.it.model;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
@Entity
public class Address implements Serializable {
    @Id
    @GeneratedValue
    private Integer id;
    private Integer house;
    private String street;
}
