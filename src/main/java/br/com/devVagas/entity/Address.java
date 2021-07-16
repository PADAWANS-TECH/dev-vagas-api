package br.com.devVagas.entity;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="ENDERECO")
@NoArgsConstructor @AllArgsConstructor
@Getter @Setter
@ToString(exclude="id")
public class Address {
    @Id @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="ID" , nullable = false)
    private Long id;
    @Column(name="LOGRADOURO", nullable = false)
    private String publicPlace;
    @Column(name= "BAIRRO" , nullable = false)
     private String neighborhood;
    @Column(name= "NUMERO" , nullable = false)
     private String number;
    @Column(name="COMPLEMENTO", nullable = true)
     private String complement;
    @Column(name="CEP", nullable= false)
     private String cep;
    // @ManyToOne
    // @Getter @Setter private City city;
}
