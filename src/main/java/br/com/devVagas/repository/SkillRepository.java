package br.com.devVagas.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.devVagas.entity.Skill;

@Repository
public interface SkillRepository extends JpaRepository<Skill,Long> {

}
