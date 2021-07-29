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
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@ToString
@Table(name = "TB_TIPO_QUESTIONARIO")
public class TypeQuestion {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private long id;
	
	@Column(name = "TITULO")
	private String title;
	
	@Column(name = "DT_ATUALIZACAO")
	private LocalDateTime updateDate;
	
	@Column(name = "DT_CRIACAO")
	private LocalDateTime createDate;
	
	@Column(name = "DT_EXCLUSAO")
	private LocalDateTime excluysionDate;
	
	@Column(name = "ID_ANALISTA_ATUALIZACAO")
	private Analyst updateAnalysts;
	
	@Column(name = "ID_ANALISTA_CRIACAO")
	private Analyst createAnalysts;
	
	@Column(name = "ID_ANALISTA_EXCLUSAO")
	private Analyst exclusionAnalysts;	
	
	@ManyToOne
	@JoinColumn(name = "analyst_id")
	private Analyst analyst;
}
