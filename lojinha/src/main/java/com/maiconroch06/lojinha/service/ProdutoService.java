package com.maiconroch06.lojinha.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.maiconroch06.lojinha.infrastructure.entity.Produto;
import com.maiconroch06.lojinha.infrastructure.repository.ProdutoRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProdutoService {

	private final ProdutoRepository produtoRepository;
	
	public Produto salvarProduto(Produto produto) {
		return produtoRepository.save(produto);
	}
	
	public Optional<Produto> consultarProduto(Long id) {
		return produtoRepository.findById(id);
	}
	
	public List<Produto> consultarProdutos() {
		return produtoRepository.findAll();
	}
	
	public Produto atualizarProduto(Long id, Produto novoProduto) {
		Produto produto = produtoRepository.findById(id)
		        .orElseThrow(() -> new RuntimeException("Produto não encontrado"));
		
		produto.setNome(novoProduto.getNome());
		produto.setPreco(novoProduto.getPreco());
		
		return produtoRepository.save(novoProduto);
	}
	
	public void deletarProduto(Long id) {
		produtoRepository.deleteById(id);
	}
	
}
