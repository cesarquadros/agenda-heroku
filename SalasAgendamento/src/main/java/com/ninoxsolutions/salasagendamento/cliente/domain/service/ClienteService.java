package com.ninoxsolutions.salasagendamento.cliente.domain.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import com.ninoxsolutions.salasagendamento.cliente.domain.exception.ClienteException;
import com.ninoxsolutions.salasagendamento.cliente.domain.port.ClientePersistencePort;
import com.ninoxsolutions.salasagendamento.common.model.Cliente;

@Service
public class ClienteService {
	
	private static final String CLIENTE_JA_CADASTRADO = "Cliente ja cadastrado";
	
	@Autowired
	private ClientePersistencePort adapter;

	public Cliente salvar(Cliente cliente) {
		if(!ObjectUtils.isEmpty(findByCpf(cliente.getCpf()))) {
			throw new ClienteException(CLIENTE_JA_CADASTRADO);
		}
		return this.adapter.salvar(cliente);
	}
	
	public List<Cliente> listarClientes(){
		return this.adapter.listarClientes();
	}
	
	public Cliente findByCpf(String cpf) {
		return this.adapter.findByCpf(cpf);
	}
	
	public Cliente existeUsuario(String user, String pass) {
		return this.adapter.existeUsuario(user, pass);
	}
}
