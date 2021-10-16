package br.com.devVagas.dto;

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
@ToString
public class AnalystRequestDTO {

	private Long id;
	private String name;
	private String email;
	private String telephone;
	private String password;
	
}
