package br.com.devVagas.entity;
import lombok.*;

import javax.persistence.*;
import java.util.List;


@NoArgsConstructor 
@AllArgsConstructor
@Getter 
@Setter
@ToString(exclude="id")
@Entity
@Table(name="TB_ENDERECO")
public class Address {
	
    @Id @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="ID")
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
