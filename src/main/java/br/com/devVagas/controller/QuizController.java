package br.com.devVagas.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
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
	
    @GetMapping("/{id}")
    private ResponseEntity<?> findById(@PathVariable Long id) {
        QuizResponseDTO response = quizService.findById(id);
        if(response != null) {
        	return ResponseEntity.ok(response);
        } else {
        	return ResponseEntity.notFound().build();        	
        }
    }

	@GetMapping
	public ResponseEntity<List<QuizResponseDTO>>      findListAll() {
		List<QuizResponseDTO> responseListQuizDTO = quizService.findAll().stream().map(obj -> new QuizResponseDTO(obj)).collect(Collectors.toList());
		return ResponseEntity.ok().body(responseListQuizDTO);
	}

	@PostMapping
	private ResponseEntity<?> createQuiz(@RequestBody QuizRequestDTO quizDTO){
		QuizResponseDTO response = quizService.createQuiz(quizDTO);
		if(response != null) {
			return ResponseEntity.ok(response);
		}
		return ResponseEntity.notFound().build();
	}

}
