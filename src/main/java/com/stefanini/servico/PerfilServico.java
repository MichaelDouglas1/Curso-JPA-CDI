package com.stefanini.servico;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

import javax.inject.Inject;
import javax.validation.Valid;

import com.stefanini.dao.EnderecoDao;
import com.stefanini.dao.PerfilDao;
import com.stefanini.model.Endereco;
import com.stefanini.model.Perfil;

public class PerfilServico implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Inject
	private PerfilDao dao;


	//@Override
	public Perfil salvar(@Valid Perfil entity) {
		return dao.salvar(entity);
	}

	//@Override
	public Perfil atualizar(@Valid Perfil entity) {
		return dao.atualizar(entity);
	}

	//@Override
	public void remover(Long id) {
	dao.remover(id);
	}

	//@Override
	public Optional<List<Perfil>> getList() {
		return dao.getList();
	}

	//@Override
	public Optional<Perfil> encontrar(Long id) {
		return dao.encontrar(id);
	}
}