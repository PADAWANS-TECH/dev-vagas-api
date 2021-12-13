package br.com.devVagas.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
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
@Table(name="TB_ESTADO")
public class State {
	
    @Id @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="ID")
    private Long id;

    @Column(name="NOME", nullable = false)
    private String name;

    @Column(name= "SIGLA", nullable = false)
    private String initials;

    @ManyToOne
	@JoinColumn(name = "PAIS_ID", referencedColumnName = "id")
    private Country country;
}