package br.com.devVagas.entity;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString(exclude="id")
@Entity
@Table(name="TB_PERGUNTA")
public class Question {
	
    @Id @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="ID")
    private Long id;

    @Column(name="TITULO", nullable = false)
    private String title;

    @Column(name= "PESO" , nullable = false)
    private String weight;

    @Column(name= "NIVEL" , nullable = false)
    private String level;

    @Column(name="DT_CRIACAO")
    private LocalDateTime createDate;
    
    @Column(name="DT_ATUALIZACAO")
    private LocalDateTime modifyDate;

    @Column(name="DT_EXCLUSAO")
    private LocalDateTime exclusionDate;
    
    //falta adicionar o mapeamento correto dos relacionamentos abaixo {
    // private Analyst createAnalyst
    // private Analyst updateAnalyst
    // private Analyst exclusionAnalyst
    
    //@ManyToOne
    // private TypeQuestion typequiz
    //@ManyToOne
    // private Quiz question
    //@ManyToOne
    // private Answer answer
//}
}