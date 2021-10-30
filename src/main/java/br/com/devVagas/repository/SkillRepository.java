package br.com.devVagas.repository;

<<<<<<< Updated upstream
import br.com.devVagas.entity.Skill;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SkillRepository extends JpaRepository<Skill, Long> {
=======
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.devVagas.entity.Skill;

@Repository
public interface SkillRepository extends JpaRepository<Skill, Long>{

>>>>>>> Stashed changes
}
