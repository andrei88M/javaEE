package by.it.entity;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Builder
@Table(name = "address")
public class Address implements Serializable {
    @Id
    @GeneratedValue
    private Integer id;
    @Column
    private String street;
    @Column
    private int house;
}
