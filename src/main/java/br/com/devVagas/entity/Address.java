package br.com.devVagas.entity;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="ENDERECO")
@NoArgsConstructor @AllArgsConstructor
@ToString(exclude="id")
public class Address {
    @Id @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="ID" , nullable = false)
    @Getter private Long id;
    @Column(name="LOGRADOURO", nullable = false)
    @Getter @Setter private String publicPlace;
    @Column(name= "BAIRRO" , nullable = false)
    @Getter @Setter private String neighborhood;
    @Column(name= "NUMERO" , nullable = false)
    @Getter @Setter private String number;
    @Column(name="COMPLEMENTO", nullable = true)
    @Getter @Setter private String complement;
    @Column(name="CEP", nullable= false)
    @Getter @Setter private String cep;
    // @ManyToOne
    // @Getter @Setter private City city;
}
