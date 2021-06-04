package by.it.model;

import lombok.*;

import javax.persistence.Entity;
import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class Person  {
    private Integer id;
    private Integer age;
    private String name;
    private String surname;
}
