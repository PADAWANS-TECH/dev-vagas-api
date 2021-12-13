package br.com.devVagas.entity;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString(exclude="id")
@Entity
@Table(name="TB_EMPRESA")
public class Company {
    @Id @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="ID")
    private Long id;

    @Column(name="RAZAO_SOCIAL", nullable = false)
    private String corporateName;

    @Column(name= "NOME_FANTASIA", nullable = false)
    private String fantasyName;

    @Column(name= "DESCRICAO", nullable = false)
    private String description;

    @Column(name= "CNPJ", nullable = false)
    private String cnpj;

    @Column(name= "TELEFONE", nullable = false)
    private String telephone;

    @Column(name= "LOGOTIPO")
    private Byte logo;

    @Column(name= "SITE", nullable = false)
    private String site;

    @Column(name= "EMAIL", nullable = false)
    private String email;
    
    @Column(name="DT_ATUALIZACAO")
    private LocalDateTime modifyDate;
    
    @Column(name="DT_CRIACAO")
    private LocalDateTime createDate;

    @Column(name="DT_EXCLUSAO")
    private LocalDateTime exclusionDate;
    
    @ManyToOne
	@JoinColumn(name = "CRIADO", referencedColumnName = "id")
	private Analyst createAnalyst;
	
	@ManyToOne
	@JoinColumn(name = "ATUALIZADO", referencedColumnName = "id")
	private Analyst modifyAnalyst;
	
	@ManyToOne
	@JoinColumn(name = "EXCLUIDO", referencedColumnName = "id")
	private Analyst exclusionAnalyst;

	@OneToMany(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "endereco_id",referencedColumnName = "id")
	private List<Address> address = new ArrayList<>();
}