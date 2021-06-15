package by.it.three;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.Embedded;
import javax.persistence.Entity;

@Entity
@NoArgsConstructor
@AllArgsConstructor
public class HomeTask extends Task {
    private String startData;
    private String endData;
    @Embedded
    private Address address;
}
