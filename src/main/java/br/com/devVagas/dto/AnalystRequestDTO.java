package br.com.devVagas.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class AnalystRequestDTO {

	private Long id;
	private String name;
	private String email;
	private String telephone;
	private String password;
	
}
