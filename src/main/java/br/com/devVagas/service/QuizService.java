package br.com.devVagas.service;

import br.com.devVagas.dto.QuizRequestDTO;
import br.com.devVagas.dto.QuizResponseDTO;

public interface QuizService {

	QuizResponseDTO createQuiz(QuizRequestDTO quizDTO);

	QuizResponseDTO findQuizById(Long id);

}
