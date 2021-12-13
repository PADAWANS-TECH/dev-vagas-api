package br.com.devVagas.dto;

import java.time.LocalDateTime;

import br.com.devVagas.entity.Quiz;
import br.com.devVagas.entity.Skill;
import br.com.devVagas.entity.Stage;
import br.com.devVagas.entity.TypeQuiz;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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
	private TypeQuiz typeQuiz;
	private Stage stage;
    public QuizResponseDTO(Quiz quiz) {
        this.id = quiz.getId();
        this.title = quiz.getTitle();
        this.description = quiz.getDescription();
        this.weight = quiz.getWeight();
        this.level = quiz.getLevel();
        this.typeQuiz = quiz.getTypeQuiz();
        this.stage = quiz.getStage();
    }
	public static QuizResponseDTO convertEntityToDTO(Quiz quiz) {
		QuizResponseDTO quizResponseDTO = new QuizResponseDTO();
		Stage stage = new Stage();
		TypeQuiz typeQuiz = new TypeQuiz();
		quizResponseDTO.setId(quiz.getId());
		quizResponseDTO.setTitle(quiz.getTitle());
		quizResponseDTO.setWeight(quiz.getWeight());
		quizResponseDTO.setLevel(quiz.getLevel());

		stage.setId(quiz.getStage().getId());
		stage.setApproved(quiz.getStage().getApproved());
		stage.setFailed(quiz.getStage().getFailed());
		stage.setName(quiz.getStage().getName());
		stage.setDescription(quiz.getStage().getDescription());
		stage.setQuantityapplicant(quiz.getStage().getQuantityapplicant());
		stage.setCreateDate(LocalDateTime.now());

		typeQuiz.setId(quiz.getTypeQuiz().getId());
		typeQuiz.setTitle(quiz.getTypeQuiz().getTitle());

		quizResponseDTO.setStage(stage);
		quizResponseDTO.setTypeQuiz(typeQuiz);

		return quizResponseDTO;
	}
	
}
