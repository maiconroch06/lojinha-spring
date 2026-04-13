package com.maiconroch06.lojinha.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.maiconroch06.lojinha.infrastructure.entity.Produto;
import com.maiconroch06.lojinha.service.ProdutoService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/produtos")
@RequiredArgsConstructor
public class ProdutoController {

	private final ProdutoService produtoService;

	@GetMapping
	public ResponseEntity<List<Produto>> consultarProdutos() {
		return ResponseEntity.ok().body(produtoService.consultarProdutos());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Produto> consultarProduto(@PathVariable Long id) {
	    return produtoService.consultarProduto(id)
	            .map(ResponseEntity::ok)
	            .orElse(ResponseEntity.notFound().build());
	}
	
	@PostMapping
	public ResponseEntity<Produto> salvarProduto(@RequestBody Produto produto) {
		return ResponseEntity.ok().body(produtoService.salvarProduto(produto));
	}

	@PutMapping("/{id}")
	public ResponseEntity<Produto> atualizarProduto(@PathVariable Long id, @RequestBody Produto produto) {
		return ResponseEntity.ok().body(produtoService.atualizarProduto(id, produto));
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deletarProduto(@PathVariable Long id) {
		produtoService.deletarProduto(id);
		return ResponseEntity.noContent().build();
	}
}
