package mak.mate.model.machine;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.math.BigDecimal;

@MappedSuperclass
@NoArgsConstructor
@Setter
@Getter
public abstract class Machine {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private BigDecimal price;

    public Machine(String name, BigDecimal price) {
        this.name = name;
        this.price = price;
    }
}
