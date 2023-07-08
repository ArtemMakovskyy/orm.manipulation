package mak.mate.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "logins")
@Getter
@Setter
@NoArgsConstructor
public class Login {
    @Id
    @Column(name = "id")
    private Long id;
    private String email;
    private String password;
    private byte[] salt;
    @OneToOne()
    @MapsId
    @JoinColumn(name = "id")
    private Person person;

    @Override
    public String toString() {
        return
                "email='" + email + '\'' +
                '}';
    }
}
