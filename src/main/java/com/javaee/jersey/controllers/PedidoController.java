package com.javaee.jersey.controllers;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;
import javax.ws.rs.core.UriInfo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.javaee.emailsender.EmailConfig;
import com.javaee.jersey.domain.Cliente;
import com.javaee.jersey.domain.Pedido;
import com.javaee.jersey.services.ClienteService;
import com.javaee.jersey.services.ClienteServiceImpl;
import com.javaee.jersey.services.PedidoService;
import com.javaee.jersey.services.PedidoServiceImpl;

@Path("/pedidos")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class PedidoController {
	private static final Logger logger = LoggerFactory.getLogger(VehicleController.class);

	private PedidoService pedidoService;
	private ClienteService clienteService;
	
	public PedidoController() {
		pedidoService = new PedidoServiceImpl();
		clienteService = new ClienteServiceImpl();
	}
    
    @GET
    public List<Pedido> getAll() {
        logger.info("getAllPedidos: {}");
        List<Pedido> pedidos = pedidoService.getAll();
        return pedidos;
    }
    
    @POST
    public Response create(Pedido pedido, @Context UriInfo uriInfo) {
        logger.info("create: {}", pedido);
        Pedido savedPedido = pedidoService.savePedido(pedido);
        logger.debug("Pedido created with id = ", savedPedido.getId());
               
        EnviarEmail(savedPedido);
        
        UriBuilder builder = uriInfo.getAbsolutePathBuilder();
        builder.path(savedPedido.getId().toString());
        return Response.created(builder.build()).entity(savedPedido).build();
    }
    
    private void EnviarEmail(Pedido pedido) {
    	final String fromEmail = "example@gmail.com";
		final String password = "*********";
		
		Integer clienteId = pedido.getClienteId();
		Cliente cliente = clienteService.findById(clienteId);
		
		final String toEmail = cliente.getEmail();
		final String subject = "Registro de pedido";
		final String body = "Prezado " + cliente.getNome() +  ", o seu pedido " + pedido.getId() + " foi realizado com sucesso.";
		
		logger.info("Initializing email send");
		
		EmailConfig config = new EmailConfig();
		
		config.sendEmail(fromEmail, password, toEmail, subject, body);
    }
}