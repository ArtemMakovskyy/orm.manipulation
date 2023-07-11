package mak.mate.model.machine;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import java.math.BigDecimal;

@Entity(name = "electric_car")
@NoArgsConstructor
@Setter
@Getter
public class ElectricCar extends Machine{
    private double chargeLevel;

    public ElectricCar(String name, BigDecimal price, double chargeLevel) {
        super(name, price);
        this.chargeLevel = chargeLevel;
    }
}
