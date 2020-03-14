package com.stefanini.servico;


import java.io.Serializable;
import java.util.List;
import java.util.Optional;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.inject.Inject;
import javax.validation.Valid;

import com.stefanini.dao.PessoaPerfilDao;
import com.stefanini.model.PessoaPerfil;

@Stateless
@TransactionManagement(TransactionManagementType.CONTAINER)
@TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
public class PessoaPerfilServico implements Serializable {

	
	private static final long serialVersionUID = 1L;
	
	
	@Inject
	private PessoaPerfilDao PessoaPerfilDao;

	
	@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
	public PessoaPerfil salvar(@Valid PessoaPerfil pessoa) {
		return PessoaPerfilDao.salvar(pessoa);
	}

	@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
	public PessoaPerfil atualizar(@Valid PessoaPerfil entity) {
		return PessoaPerfilDao.atualizar(entity);
	}

	@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
	public void remover(@Valid Long id) {
		PessoaPerfilDao.remover(id);
	}

	
	public Optional<List<PessoaPerfil>> getList() {
		return PessoaPerfilDao.getList();
	}

	
	public Optional<PessoaPerfil> encontrar(Long id) {
		return PessoaPerfilDao.encontrar(id);
	}

}