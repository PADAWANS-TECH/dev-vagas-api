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
    private String name;
    private String color;
    private String knowledgeLevel;
}
