package br.com.devVagas.dto;

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
public class QuizResponseDTO {

	private Long id;
	private String title;
	private String description;
	private String weight;
	private String level;
	private TypeQuizDTO typequiz;
	private StageDTO stage; 
	
}
