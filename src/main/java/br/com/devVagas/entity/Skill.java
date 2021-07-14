package br.com.devVagas.entity;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name="SKILL")
@NoArgsConstructor @AllArgsConstructor
public class Skill {
    @Id @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="ID" , nullable = false)
    @Getter private Long id;
    @Column(name="NOME" , nullable = false)
    @Getter @Setter private String name;
    @Column(name="COR" , nullable = false)
    @Getter @Setter private String color;
    @Column(name="NIVEL_CONHECIMENTO", nullable = false)
    @Getter @Setter private Integer knowledgeLevel;
    @Column(name="DT_ATUALIZACAO")
    @Getter @Setter private LocalDateTime exclusionDate;
    @Column(name="DT_CRIACAO")
    @Getter @Setter private LocalDateTime createDate;
    @Column(name="DT_EXCLUSAO")
    @Getter @Setter private LocalDateTime updateDate;
}
