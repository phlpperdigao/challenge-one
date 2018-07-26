package com.javaee.jersey.controllers;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.javaee.jersey.domain.Produto;
import com.javaee.jersey.services.ProdutoService;
import com.javaee.jersey.services.ProdutoServiceImpl;

@Path("/produtos")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ProdutoController {
	private static final Logger logger = LoggerFactory.getLogger(ProdutoController.class);

	private ProdutoService produtoService;
	
	public ProdutoController() {
		produtoService = new ProdutoServiceImpl();
	}
    
    @GET
    public List<Produto> getAll() {
        logger.info("getAllProdutos: {}");
        List<Produto> produtos = produtoService.getAll();
        return produtos;
    }
}