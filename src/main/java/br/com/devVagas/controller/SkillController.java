package br.com.devVagas.controller;

<<<<<<< Updated upstream
import br.com.devVagas.dto.SkillResponseDTO;
import br.com.devVagas.entity.Skill;
import br.com.devVagas.service.SkillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
=======
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
>>>>>>> Stashed changes
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

<<<<<<< Updated upstream
=======
import br.com.devVagas.service.SkillService;

>>>>>>> Stashed changes
@RestController
@RequestMapping("/skill")
public class SkillController {

<<<<<<< Updated upstream
    @Autowired
    private SkillService skillService;

    @GetMapping("/{id}")
    private ResponseEntity<?> findSkillById(@PathVariable Long id) {
        SkillResponseDTO response = skillService.findSkillById(id);
        if(response != null) {
        	return ResponseEntity.ok(response);
        } else {
        	return ResponseEntity.notFound().build();        	
        }
    }

=======
	@Autowired
	private SkillService skillService;
	
	@DeleteMapping("/{id}")
	private ResponseEntity<?>deleteSkill(@PathVariable Long id){
		
		boolean response = skillService.deleteSkill(id);
		if(response) {
			return ResponseEntity.ok().build();
		}
		
		return ResponseEntity.notFound().build();
		
	}
	
>>>>>>> Stashed changes
}
