package br.com.devVagas.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.devVagas.dto.AnalystRequestDTO;
import br.com.devVagas.dto.AnalystResponseDTO;
import br.com.devVagas.entity.Analyst;
import br.com.devVagas.service.AnalystService;
import lombok.extern.log4j.Log4j2;

@RestController
@RequestMapping("/analyst")
@Log4j2
public class AnalystController {
	
	
	@Autowired
	private AnalystService analystService;

	@PutMapping("/{id}")
	public ResponseEntity<?> update(@PathVariable Long id, @RequestBody AnalystRequestDTO request){
		AnalystResponseDTO response = analystService.update(id, request);
		if(response != null) {
			return ResponseEntity.ok(response);
		}
		return ResponseEntity.notFound().build();
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> delet(@PathVariable Long id) {
		analystService.delete(id);
		return ResponseEntity.ok().build();
	}
	
}
