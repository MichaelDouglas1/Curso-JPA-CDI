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

import com.stefanini.model.Perfil;
import com.stefanini.servico.PerfilServico;

@Path("perfil")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class PerfilResource {

	@Inject
	private PerfilServico perfilServico;

	@GET
	public Response obterListaperfil() {
		return Response.ok(perfilServico.getList().get()).build();
	}

	@POST
	public Response obterListaperfil(@Valid Perfil perfil) {
		return Response.ok(perfilServico.salvar(perfil)).build();
	}
	
	@PUT
	public Response alterarperfil(@Valid Perfil perfil) {
		return Response.ok(perfilServico.atualizar(perfil)).build();
	}
	
	@DELETE
	@Path("/{id}")
	public Response removerperfil(@PathParam("id") Long id) {
		perfilServico.remover(id);
		return Response.ok().build();
	}
	

	@GET
	@Path("/{id}")
	public Response obterPerfil(@PathParam("id") Long id) {
		return Response.status(Status.INTERNAL_SERVER_ERROR).entity("deu ruim").build();
//		return Response.ok(pessoaServico.encontrar(id).get()).build();
	}

}
