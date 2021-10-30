package br.com.devVagas.serviceImpl;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.devVagas.dto.QuizRequestDTO;
import br.com.devVagas.dto.QuizResponseDTO;
import br.com.devVagas.entity.Quiz;
import br.com.devVagas.entity.Stage;
import br.com.devVagas.entity.TypeQuiz;
import br.com.devVagas.repository.QuizRepository;
import br.com.devVagas.service.QuizService;

@Service
public class QuizServiceImpl implements QuizService {

	@Autowired
	private QuizRepository quizRepository;

	@Override
	public QuizResponseDTO createQuiz(QuizRequestDTO quizDTO) {
		if (quizDTO != null) {
			Quiz quiz = convertDTOToEntity(quizDTO);
			quizRepository.save(quiz);
			return QuizResponseDTO.convertEntityToDTO(quiz);
		}
		return null;
	}

	private Quiz convertDTOToEntity(QuizRequestDTO quizDTO) {
		Quiz quiz = new Quiz();
		Stage stage = new Stage();
		TypeQuiz typeQuiz = new TypeQuiz();
		quiz.setId(quizDTO.getId());
		quiz.setTitle(quizDTO.getTitle());
		quiz.setWeight(quizDTO.getWeight());
		quiz.setLevel(quizDTO.getLevel());

		stage.setId(quizDTO.getStage().getId());
		stage.setApproved(quizDTO.getStage().getApproved());
		stage.setFailed(quizDTO.getStage().getFailed());
		stage.setName(quizDTO.getStage().getName());
		stage.setDescription(quizDTO.getStage().getDescription());
		stage.setQuantityapplicant(quizDTO.getStage().getQuantityapplicant());
		stage.setCreateDate(LocalDateTime.now());

		typeQuiz.setId(quizDTO.getTypequiz().getId());
		typeQuiz.setTitle(quizDTO.getTypequiz().getTitle());

		quiz.setStage(stage);
		quiz.setTypeQuiz(typeQuiz);

		return quiz;
	}

}
