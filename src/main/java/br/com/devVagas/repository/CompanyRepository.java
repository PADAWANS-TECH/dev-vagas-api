package br.com.devVagas.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.devVagas.entity.Company;

@Repository
public interface CompanyRepository extends JpaRepository<Company, Long>{

}
