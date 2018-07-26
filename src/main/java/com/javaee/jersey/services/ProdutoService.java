package com.javaee.jersey.services;

import java.util.List;

import com.javaee.jersey.domain.Produto;

public interface ProdutoService {
	List<Produto> getAll();
}