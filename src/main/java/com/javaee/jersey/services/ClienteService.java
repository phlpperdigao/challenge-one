package com.javaee.jersey.services;

import java.util.List;

import com.javaee.jersey.domain.Cliente;

public interface ClienteService {
	List<Cliente> getAll();

	Cliente findById(Integer id);
}