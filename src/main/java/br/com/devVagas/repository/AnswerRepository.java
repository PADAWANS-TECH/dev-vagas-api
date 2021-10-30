package br.com.devVagas.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.devVagas.entity.Answer;

@Repository
public interface AnswerRepository extends JpaRepository<Answer, Long>{

}
