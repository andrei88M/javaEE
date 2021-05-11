package entity;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Builder
@Setter
@Getter
@ToString
public class Address {
    private int id;
    private String street;
    private int house;
    private int people_id;
}
