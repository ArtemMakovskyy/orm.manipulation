package mak.mate.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "countries")
@Getter
@Setter
@NoArgsConstructor
public class Country {
    String country;
    @Id
    @Column(name = "id")
    private Long id;

}
