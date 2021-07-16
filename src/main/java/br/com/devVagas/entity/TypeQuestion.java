package br.com.devVagas.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "TB_TIPO_QUESTIONARIO")
public class TypeQuestion {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private long id;
	
	@Column(name = "TITULO")
	private String title;
	
	@Column(name = "DT_ATUALIZACAO")
	private Date updateDate;
	
	@Column(name = "DT_CRIACAO")
	private Date createDate;
	
	@Column(name = "DT_EXCLUSAO")
	private Date excluysionDate;
	
	//@Column(name = "ID_ANALISTA_ATUALIZACAO")
	//private Analyst updateAnalysts;
	
	//@Column(name = "ID_ANALISTA_CRIACAO")
	//private Analyst createAnalysts;
	
	//@Column(name = "ID_ANALISTA_EXCLUSAO")
	//private Analyst exclusionAnalysts;	
	
}
