package com.javaee.jersey.services;

import java.util.ArrayList;
import java.util.List;

import com.javaee.jersey.domain.Produto;

public class ProdutoServiceImpl implements ProdutoService {
	private List<Produto> produtos = new ArrayList<>();
		
	public ProdutoServiceImpl() {
		for (int i = 1; i <= 10; i++) {
			Produto produto = new Produto();
			produto.setId(i);
			produto.setNome("Produto " + i);
			
			produtos.add(produto);
		}
	}
	
	@Override
	public List<Produto> getAll() {
		return produtos;
	}
}