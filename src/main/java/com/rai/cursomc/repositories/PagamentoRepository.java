package com.rai.cursomc.repositories;

import org.springframework.stereotype.Repository;

import com.rai.cursomc.domain.Pagamento;

import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface PagamentoRepository extends JpaRepository<Pagamento, Integer>{

	
}
