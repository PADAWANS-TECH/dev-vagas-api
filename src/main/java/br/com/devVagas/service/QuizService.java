package br.com.devVagas.service;

import java.util.List;

import br.com.devVagas.dto.QuizRequestDTO;
import br.com.devVagas.dto.QuizResponseDTO;
import br.com.devVagas.entity.Quiz;

public interface QuizService {
	QuizResponseDTO findById(Long id);
	List<Quiz> findAll();
	QuizResponseDTO createQuiz(QuizRequestDTO quizDTO);

	

}
