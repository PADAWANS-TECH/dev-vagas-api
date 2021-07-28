package br.com.devVagas.entity;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name="EMPRESA")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString(exclude="id")
public class Company {
    @Id @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="ID")
    private Long id;

    @Column(name="NOME")
    private String corporateName;

    @Column(name= "NOME_FANTASIA", nullable = false)
    private String fantasyName;

    @Column(name= "DESCRICAO", nullable = false)
    private String description;

    @Column(name= "CNPJ")
    private String cnpj;

    @Column(name= "TELEFONE", nullable = false)
    private String telephone;

    @Column(name= "LOGOTIPO", nullable = false)
    private Byte logo;

    @Column(name= "SITE", nullable = false)
    private String site;

    @Column(name= "EMAIL")
    private String email;
    
    @Column(name="DT_ATUALIZACAO")
    private LocalDateTime updateDate;
    
    @Column(name="DT_CRIACAO")
    private LocalDateTime createDate;

    @Column(name="DT_EXCLUSAO")
    private LocalDateTime exclusionDate;
    
    // private Analyst createAnalyst
    // private Analyst updateAnalyst
    // private Analyst exclusionAnalyst

    //@ManyToOne
    // private Address address
}