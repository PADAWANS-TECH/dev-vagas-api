package br.com.devVagas.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.devVagas.dto.QuizResponseDTO;
import br.com.devVagas.entity.Quiz;
import br.com.devVagas.service.QuizService;

@Controller
@RequestMapping("/quiz")
public class QuizController {

	@Autowired
	private QuizService quizService;
	
	@GetMapping
	public ResponseEntity<?>findAllQuiz(){
		
		List<QuizResponseDTO> response = quizService.findAll();
		
		if(response.isEmpty()) {
			return ResponseEntity.noContent().build();
		}		
		return ResponseEntity.ok().body(response);
	}
}
