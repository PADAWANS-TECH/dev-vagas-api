package br.com.devVagas.serviceImpl;

<<<<<<< Updated upstream
import br.com.devVagas.dto.SkillResponseDTO;
import br.com.devVagas.entity.Skill;
import br.com.devVagas.repository.SkillRepository;
import br.com.devVagas.service.SkillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SkillServiceImpl implements SkillService {

    @Autowired
    private SkillRepository skillRepository;

    @Override
    public SkillResponseDTO findSkillById(Long id) {
        Optional<Skill> optionalSkill = skillRepository.findById(id);
        if(optionalSkill.isPresent()) {
            return new SkillResponseDTO(optionalSkill.get());
        }
        return null;
    }
=======
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.devVagas.entity.Skill;
import br.com.devVagas.repository.SkillRepository;
import br.com.devVagas.service.SkillService;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class SkillServiceImpl implements SkillService{

	@Autowired
	private SkillRepository skillRepository;

	@Override
	public boolean deleteSkill(Long id) {
		Optional<Skill> skill = skillRepository.findById(id);
		
		if(!skill.isPresent()) {			
			log.info("ID("+id+") não encontrado!");
			return false;
		}
		skillRepository.delete(skill.get());
			return true;
	}
	
	
>>>>>>> Stashed changes
}
