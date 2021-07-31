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
@Table(name="TB_ESTADO")
public class State {
	
    @Id @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="ID")
    private Long id;

    @Column(name="NOME", nullable = false)
    private String name;

    @Column(name= "SIGLA", nullable = false)
    private String initials;

    //falta completar o relacionamento
    //@ManyToOne
    // private Country country
}