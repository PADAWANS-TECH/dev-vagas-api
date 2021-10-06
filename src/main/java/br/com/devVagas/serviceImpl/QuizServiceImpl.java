package br.com.devVagas.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.devVagas.dto.QuizResponseDTO;
import br.com.devVagas.entity.Quiz;
import br.com.devVagas.repository.QuizRepository;
import br.com.devVagas.service.QuizService;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class QuizServiceImpl implements QuizService{

	@Autowired
	private QuizRepository quizRepository;

	@Override
	public List<QuizResponseDTO> findAll() {
		
		List<Quiz> quizes = quizRepository.findAll();
		List<QuizResponseDTO> quizDT = new ArrayList<>();
		
		ModelMapper modelMapper = new ModelMapper();
		
		if(quizes.isEmpty()) {			
		log.info("Quiz esta vazio!");	
		}
		
		log.info("Busca da Lista realizada com sucesso!");
		
		quizes.forEach(quiz -> quizDT.add(modelMapper.map(quiz,QuizResponseDTO.class )));
		
		return quizDT;	
		
	}
	
	

		
}
