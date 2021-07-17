package br.com.devVagas.entity;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name="SKILL")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString(exclude="id")
public class Skill {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="ID" , nullable = false)
    private Long id;
    @Column(name="NOME" , nullable = false)
    private String name;
    @Column(name="COR" , nullable = false)
    private String color;
    @Column(name="NIVEL_CONHECIMENTO", nullable = false)
    private Integer knowledgeLevel;
    @Column(name="DT_ATUALIZACAO")
    private LocalDateTime exclusionDate;
    @Column(name="DT_CRIACAO")
    private LocalDateTime createDate;
    @Column(name="DT_EXCLUSAO")
    private LocalDateTime updateDate;
    //@ManyToOne
    // private Analyst createAnalyst
    // private Analist exclusionAnalyst
    // private Analist updateAnalyst
}
