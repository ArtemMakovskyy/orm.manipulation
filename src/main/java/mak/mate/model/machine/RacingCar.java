package mak.mate.model.machine;

import liquibase.pro.packaged.M;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import java.math.BigDecimal;

@Entity(name = "racing_car")
@NoArgsConstructor
@Setter
@Getter
public class RacingCar extends Machine{
    private double maxSpeed;

    public RacingCar(String name, BigDecimal price, double maxSpeed) {
        super(name, price);
        this.maxSpeed = maxSpeed;
    }
}
