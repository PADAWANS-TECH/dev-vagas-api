package br.com.devVagas.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class QuizRequestDTO {

	private Long id;
	private String title;
	private String description;
	private String weight;
	private String level;
	private TypeQuizDTO typequiz;
	private StageDTO stage;
}
