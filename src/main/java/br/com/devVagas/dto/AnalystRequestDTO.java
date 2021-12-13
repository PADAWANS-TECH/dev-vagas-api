package br.com.devVagas.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AnalystRequestDTO {
	
	private long id;
	private String name;
	private String email;
	private String telephone;
	
}
