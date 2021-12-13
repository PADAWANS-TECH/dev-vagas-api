package br.com.devVagas.entity;

import java.time.LocalDateTime;

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

@Entity
@Table(name = "TB_QUESTIONARIO")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString(exclude = "id")
public class Quiz {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private Long id;

	@Column(name = "TITULO", nullable = false)
	private String title;

	@Column(name = "DESCRICAO")
	private String description;
	
	@Column(name = "PESO", nullable = false)
	private String weight;

	@Column(name = "NIVEL", nullable = false)
	private String level;

	@Column(name = "DT_ATUALIZACAO")
	private LocalDateTime modifyDate;

	@Column(name = "DT_CRIACAO")
	private LocalDateTime createDate;

	@Column(name = "DT_EXCLUSAO")
	private LocalDateTime exclusionDate;

	@ManyToOne
	@JoinColumn(name = "ANALISTA_CRIAÇÃO_ID", referencedColumnName = "id")
	private Analyst createAnalyst;

	@ManyToOne
	@JoinColumn(name = "ANALISTA_MODIFICAÇÃO_ID", referencedColumnName = "id")
	private Analyst modifyAnalyst;

	@ManyToOne
	@JoinColumn(name = "ANALISTA_EXCLUSÃO_ID", referencedColumnName = "id")
	private Analyst exclusionAnalyst;
	
	@ManyToOne
	@JoinColumn(name = "TIPO_QUESTIONARIO_ID", referencedColumnName = "id")
	private TypeQuiz typeQuiz;

	@ManyToOne
	@JoinColumn(name = "ETAPA_ID", referencedColumnName = "id")
	private Stage stage;
	
}
