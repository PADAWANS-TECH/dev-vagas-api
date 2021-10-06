package br.com.devVagas.service;

import java.util.List;

import br.com.devVagas.dto.QuizResponseDTO;

public interface QuizService {

	List<QuizResponseDTO> findAll();

}
