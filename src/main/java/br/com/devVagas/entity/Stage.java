package br.com.devVagas.entity;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name="ETAPA")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString(exclude="id")
public class Stage {
    @Id @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="ID")
    private Long id;

    @Column(name="NOME", nullable = false)
    private String name;

    @Column(name= "DESCRICAO" , nullable = false)
    private String description;

    @Column(name= "QUANTIDADE_CANDIDATOS" , nullable = false)
    private int quantityapplicant;

    @Column(name="DT_INICIO")
    private LocalDateTime beginDate;

    @Column(name="DT_FIM")
    private LocalDateTime endDate;

    @Column(name="APROVADOS")
    private int approved;

    @Column(name="REPROVADOS")
    private int failed;
    
    @Column(name="DT_ATUALIZACAO")
    private LocalDateTime updateDate;
    
    @Column(name="DT_CRIACAO")
    private LocalDateTime createDate;

    @Column(name="DT_EXCLUSAO")
    private LocalDateTime exclusionDate;
    // private Analyst createAnalyst
    // private Analyst updateAnalyst
    // private Analyst exclusionAnalyst
}