package br.com.devVagas.entity;

import lombok.*;

import javax.persistence.*;

import br.com.devVagas.dto.QuizRequestDTO;

import java.time.LocalDateTime;

@Entity
@Table(name = "TB_PERGUNTA")
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
