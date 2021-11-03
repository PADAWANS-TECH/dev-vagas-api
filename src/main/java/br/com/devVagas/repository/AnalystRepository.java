package br.com.devVagas.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.devVagas.entity.Analyst;
@Repository
public interface AnalystRepository extends JpaRepository<Analyst, Long>{
	
	@Transactional(readOnly=true)
	public List<Analyst> findAll();

}
