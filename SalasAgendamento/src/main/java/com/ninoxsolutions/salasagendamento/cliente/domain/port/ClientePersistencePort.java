package com.ninoxsolutions.salasagendamento.cliente.domain.port;

import java.util.List;

import com.ninoxsolutions.salasagendamento.common.model.Cliente;

public interface ClientePersistencePort {
	
	Cliente salvar(Cliente cliente);
	String deletar(String id);
	List<Cliente> listarClientes();
	Cliente findByCpf(String cpf);
	Cliente existeUsuario(String user, String pass);
}
