package br.com.devVagas.entity;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


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
    
    @Column(name="COMPLEMENTO")
     private String complement;
    
    @Column(name="CEP", nullable= false)
     private String cep;
    
    @ManyToOne
    //arrumar o mapeamento
    private City city;
}
