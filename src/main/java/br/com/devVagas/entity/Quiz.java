package br.com.devVagas.entity;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name="TB_PERGUNTA")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString(exclude="id")
public class Quiz {
    @Id @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="ID")
    private Long id;

    @Column(name="TITULO", nullable = false)
    private String title;
    
//adicionar campo de descrição 
    
    @Column(name= "PESO" , nullable = false)
    private String weight;

    @Column(name= "NIVEL" , nullable = false)
    private String level;

    @Column(name="DT_ATUALIZACAO")
    private LocalDateTime modifyDate;

    @Column(name="DT_CRIACAO")
    private LocalDateTime createDate;

    @Column(name="DT_EXCLUSAO")
    private LocalDateTime exclusionDate;
    
    //falta colocar o relacionamento para as tabelas {
    // private Analyst createAnalyst
    // private Analyst exclusionAnalyst
    // private Analyst updateAnalyst
    
    //@ManyToOne
    // private TypeQuiz typequiz
    
    //falta adicionar o atributo Stage 
//}
}
