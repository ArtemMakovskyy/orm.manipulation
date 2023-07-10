package mak.mate.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "addresses")
@Getter
@Setter
@NoArgsConstructor
public class Address {
    @Id
    private Long id;
    @ManyToOne(fetch = FetchType.LAZY)
    @Cascade(value = {CascadeType.SAVE_UPDATE})
    private Country country;
    private String city;
    private String street;
    @OneToOne()
    @JoinColumn(name = "id")
    @MapsId
    private Person person;


    public Address(String city, String street) {
        this.city = city;
        this.street = street;
    }

    @Override
    public String toString() {
        return "Address{" +
                ", city='" + city + '\'' +
                ", street='" + street + '\'' +
                ", Country ='" + country + '\'' +
                '}';
    }
}
