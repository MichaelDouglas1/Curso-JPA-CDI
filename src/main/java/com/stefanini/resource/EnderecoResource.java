package com.stefanini.resource;

import javax.inject.Inject;
import javax.validation.Valid;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import com.stefanini.model.Endereco;
import com.stefanini.servico.EnderecoServico;

@Path("enderecos")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class EnderecoResource {

	@Inject
	private EnderecoServico enderecoServico;

	@GET
	public Response obterListaEndereco() {
		return Response.ok(enderecoServico.getList().get()).build();
	}

	@POST
	public Response obterListaEndereco(@Valid Endereco endereco) {
		return Response.ok(enderecoServico.salvar(endereco)).build();
	}
	
	@PUT
	public Response alterarEndereco(@Valid Endereco endereco) {
		return Response.ok(enderecoServico.atualizar(endereco)).build();
	}
	
	@DELETE
	@Path("/{id}")
	public Response removerEndereco(@PathParam("id") Long id) {
		enderecoServico.remover(id);
		return Response.ok().build();
	}
	

	@GET
	@Path("/{id}")
	public Response obterEndereco(@PathParam("id") Long id) {
		return Response.status(Status.INTERNAL_SERVER_ERROR).entity("deu ruim").build();
//		return Response.ok(enderecoServico.encontrar(id).get()).build();
	}

}
