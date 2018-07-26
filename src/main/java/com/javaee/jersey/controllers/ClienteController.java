package com.javaee.jersey.controllers;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.javaee.jersey.domain.Cliente;
import com.javaee.jersey.services.ClienteService;
import com.javaee.jersey.services.ClienteServiceImpl;

@Path("/clientes")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ClienteController {
	private static final Logger logger = LoggerFactory.getLogger(ClienteController.class);

	private ClienteService clienteService;
	
	public ClienteController() {
		clienteService = new ClienteServiceImpl();
	}
    
    @GET
    public List<Cliente> getAll() {
        logger.info("getAllClientes: {}");
        List<Cliente> clientes = clienteService.getAll();
        return clientes;
    }
}