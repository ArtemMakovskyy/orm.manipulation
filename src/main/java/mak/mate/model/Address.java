package mak.mate.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "addresses")
public class Address {
    @Id
    private Long id;
    private String City;
    private String street;
    @OneToOne()
//    @JoinColumn(name = "user_id")
    @MapsId
    private User user;

    public Address() {
    }

    public Address(String city, String street) {
        City = city;
        this.street = street;
    }

    public Address(String city, String street, User user) {
        City = city;
        this.street = street;
        this.user = user;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCity() {
        return City;
    }

    public void setCity(String city) {
        City = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Address{" +
                "id=" + id +
                ", City='" + City + '\'' +
                ", street='" + street + '\'' +
                '}';
    }
}
