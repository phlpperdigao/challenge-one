package com.javaee.jersey.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.javaee.jersey.domain.Cliente;
import com.javaee.jersey.domain.Endereco;

public class ClienteServiceImpl implements ClienteService {
	private List<Cliente> clientes = new ArrayList<>();
		
	public ClienteServiceImpl() {
		Endereco endereco1 = new Endereco();
		endereco1.setTipoLogradouro("Rua 1");
		endereco1.setLogradouro("Um");
		endereco1.setNumero("01");
		endereco1.setBairro("Bairro 1");
		endereco1.setCidade("Cidade 1");
		endereco1.setUf("UF 1");
		
		Cliente cliente1 = new Cliente();
		cliente1.setId(1);
		cliente1.setNome("Cliente 1");
		cliente1.setEmail("philipesp@live.com");
		cliente1.setEndereco(endereco1);
		clientes.add(cliente1);
		
		Endereco endereco2 = new Endereco();
		endereco2.setTipoLogradouro("Rua 2");
		endereco2.setLogradouro("Dois");
		endereco2.setNumero("02");
		endereco2.setBairro("Bairro 2");
		endereco2.setCidade("Cidade 2");
		endereco2.setUf("UF 2");
		
		Cliente cliente2 = new Cliente();
		cliente2.setId(2);
		cliente2.setNome("Cliente 2");
		cliente2.setEmail("phlpprdg23@gmail.com");
		cliente2.setEndereco(endereco2);
		clientes.add(cliente2);
	}
	
	@Override
	public List<Cliente> getAll() {
		return clientes;
	}
	
	@Override
    public Cliente findById(Integer id) {
        Optional<Cliente> clienteOptional = clientes.stream()
        		.filter(cliente -> cliente.getId().equals(id)).findFirst();

        return clienteOptional.orElse(null);
    }
}