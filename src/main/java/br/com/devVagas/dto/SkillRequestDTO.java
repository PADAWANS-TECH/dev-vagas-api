package br.com.devVagas.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SkillRequestDTO {

	private Long id;
	private String name;
	private String color;
	private Integer knowledgeLevel;

}
