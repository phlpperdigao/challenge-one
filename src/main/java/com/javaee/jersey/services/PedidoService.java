package com.javaee.jersey.services;

import java.util.List;

import com.javaee.jersey.domain.Pedido;

public interface PedidoService {
	List<Pedido> getAll();

	Pedido savePedido(Pedido pedido);
	
	void deleteById(Integer id);
}