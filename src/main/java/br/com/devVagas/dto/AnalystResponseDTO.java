package br.com.devVagas.dto;

import br.com.devVagas.entity.Analyst;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AnalystResponseDTO {

	private long id;
	private String name;
	private String email;
	private String telephone;
	
	public AnalystResponseDTO(Analyst analyst) {
		this.id = analyst.getId();
		this.name = analyst.getName();
		this.email = analyst.getEmail();
		this.telephone = analyst.getTelephone();
	}
}
