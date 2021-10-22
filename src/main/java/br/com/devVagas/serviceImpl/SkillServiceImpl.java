package br.com.devVagas.serviceImpl;

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
}
