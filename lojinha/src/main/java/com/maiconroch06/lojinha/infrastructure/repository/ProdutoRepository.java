package com.maiconroch06.lojinha.infrastructure.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.maiconroch06.lojinha.infrastructure.entity.Produto;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long>{
	
	//Busca um produto com o mesmo nome
	List<Produto> findByNome(String nome);
	
}
