package mak.mate.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "persons")
@Getter
@Setter
@NoArgsConstructor
@ToString
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "name")
    private String name;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "age")
    private int age;
    @OneToOne(fetch = FetchType.LAZY,
            mappedBy = "person")
    @Cascade(value = {CascadeType.SAVE_UPDATE})
    private Address address;
    @OneToOne(fetch = FetchType.LAZY,
            mappedBy = "person")
    @Cascade(value = {CascadeType.SAVE_UPDATE})
    private Passport passport;
    @OneToOne(fetch = FetchType.LAZY,
            mappedBy = "person")
    @Cascade(value = {CascadeType.SAVE_UPDATE})
    private Login login;

    public Person(String name, String lastName, int age) {
        this.name = name;
        this.lastName = lastName;
        this.age = age;
    }
}
