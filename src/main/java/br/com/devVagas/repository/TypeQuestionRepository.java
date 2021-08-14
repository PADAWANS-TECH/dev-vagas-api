package br.com.devVagas.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.devVagas.entity.TypeQuestion;

@Repository
public interface TypeQuestionRepository extends JpaRepository<TypeQuestion, Long>{

}
