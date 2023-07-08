package mak.mate.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "passports")
@Getter
@Setter
@NoArgsConstructor
public class Passport {
    @Id
    @Column(name = "id")
    private Long id;
    private String number;
    @OneToOne()
    @MapsId
    @JoinColumn(name = "id")
    private Person person;
}
