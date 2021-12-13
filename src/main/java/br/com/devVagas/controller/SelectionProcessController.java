package br.com.devVagas.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.devVagas.dto.SelectionProcessResponseDTO;
import br.com.devVagas.service.SelectionProcessService;

@RestController
@RequestMapping("/selection-process")
public class SelectionProcessController {
	
	@Autowired
	private SelectionProcessService selectionProcessService;

	@GetMapping("/{id}")
	private ResponseEntity<?> findSelectionProcessById(@PathVariable Long id) {
		SelectionProcessResponseDTO response = selectionProcessService.findSelectionProcessById(id);
		if(response != null) {
			return ResponseEntity.ok(response);
		} else {
			return ResponseEntity.notFound().build();
		}
		
	}
}
