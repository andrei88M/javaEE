package by.it.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

@Builder
@Setter
@Getter
@ToString
public class People implements Serializable {
    private int id;
    private String name;
    private String surname;
    private int age;
}
