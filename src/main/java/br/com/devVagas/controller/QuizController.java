package br.com.devVagas.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.devVagas.dto.QuizRequestDTO;
import br.com.devVagas.dto.QuizResponseDTO;
import br.com.devVagas.service.QuizService;

@RestController
@RequestMapping("/quiz")
public class QuizController {
	
	@Autowired
	private QuizService quizService;

	@PostMapping
	private ResponseEntity<?> createQuiz(@RequestBody QuizRequestDTO quizDTO){
		QuizResponseDTO response = quizService.createQuiz(quizDTO);
		if(response != null) {
			return ResponseEntity.ok(response);
		}
		return ResponseEntity.notFound().build();
	}
	
	@DeleteMapping("/{id}")
	private ResponseEntity<?> deleteQuiz(@PathVariable Long id){
		boolean response = quizService.deleteQuiz(id);
		if(response) {
			return ResponseEntity.ok().build();
		}
		return ResponseEntity.notFound().build();
	}

}
