package by.it.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table
public class People implements Serializable {
    @Id
    @GeneratedValue
    private Integer id;

    @Column
    private String name;

    @Column
    private String surname;

    @Column
    private int age;
}
