package br.com.devVagas.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.devVagas.entity.Quiz;

@Repository
public interface QuizRepository extends JpaRepository<Quiz, Long>{

}
