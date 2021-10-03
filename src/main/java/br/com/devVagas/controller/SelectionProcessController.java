package br.com.devVagas.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.devVagas.dto.SelectionProcessRequestDTO;
import br.com.devVagas.dto.SelectionProcessResponseDTO;
import br.com.devVagas.service.SelectionProcessService;

@RestController
@RequestMapping("/selectionProcess")
public class SelectionProcessController {
	
	
	@Autowired
	private SelectionProcessService selectionProcessService;

	@PutMapping("/{id}")
	public ResponseEntity<?> update(@PathVariable Long id, @RequestBody SelectionProcessRequestDTO request){
		SelectionProcessResponseDTO response = selectionProcessService.update(id, request);
		if(response != null) {
			return ResponseEntity.ok(response);
		}
		return ResponseEntity.notFound().build();
	}	
	
}
