package br.com.devVagas.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "TB_TIPO_QUESTIONARIO")
public class TypeQuiz {
	
	@Id
	private Long id;
	
	@Column(name = "TITULO", nullable = false)
	private String title;
}
