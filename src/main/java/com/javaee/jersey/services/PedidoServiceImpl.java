package com.javaee.jersey.services;

import java.util.ArrayList;
import java.util.List;

import com.javaee.jersey.domain.Pedido;

public class PedidoServiceImpl implements PedidoService {
	private static List<Pedido> pedidos = new ArrayList<>();
	private static Integer actualId = 0;
	
	public PedidoServiceImpl() {
		
	}
	
	@Override
	public List<Pedido> getAll() {
		return pedidos;
	}

    @Override
    public Pedido savePedido(Pedido pedido) {
    	if(pedido.getId() != null) {
    		this.deleteById(pedido.getId());
    	} else {
    		actualId++;
    		pedido.setId(actualId);
    	}
    	PedidoServiceImpl.pedidos.add(pedido);
        return pedido;
    }
    
    @Override
    public void deleteById(Integer id) {
    	PedidoServiceImpl.pedidos.removeIf(pedido -> pedido.getId().equals(id));
    }
}