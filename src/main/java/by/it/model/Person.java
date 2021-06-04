package by.it.model;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
@Entity
public class Person  implements Serializable{
    @Id
    @GeneratedValue
    private Integer id;
    private Integer age;
    private String name;
    private String surname;
}
