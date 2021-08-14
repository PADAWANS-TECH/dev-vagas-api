package br.com.devVagas.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.devVagas.entity.Applicant;

public interface ApplicantRepository extends JpaRepository<Applicant, Long>{

}
