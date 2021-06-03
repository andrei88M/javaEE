package by.it.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Builder
@Table
public class Address implements Serializable {
    @Id
    @GeneratedValue
    private Integer id;
    @Column
    private String street;
    @Column
    private int house;
}
