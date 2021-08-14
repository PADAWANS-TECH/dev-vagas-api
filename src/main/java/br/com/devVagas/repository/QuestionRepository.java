package br.com.devVagas.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.devVagas.entity.Question;

public interface QuestionRepository extends JpaRepository<Question, Long>{

}
