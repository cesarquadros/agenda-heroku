package com.ninoxsolutions.salasagendamento.cliente.integration.persistence;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.util.ObjectUtils;

import com.ninoxsolutions.salasagendamento.cliente.domain.port.ClientePersistencePort;
import com.ninoxsolutions.salasagendamento.cliente.integration.parse.DocumentParaModel;
import com.ninoxsolutions.salasagendamento.cliente.integration.parse.ModelParaDocument;
import com.ninoxsolutions.salasagendamento.cliente.integration.repository.ClienteRepository;
import com.ninoxsolutions.salasagendamento.common.document.ClienteDocument;
import com.ninoxsolutions.salasagendamento.common.model.Autenticacao;
import com.ninoxsolutions.salasagendamento.common.model.Cliente;

@Repository
public class ClientePersistenceAdapter implements ClientePersistencePort {
	
	@Autowired
	private ClienteRepository repository;
	@Autowired
	private ModelParaDocument modelParaDocument;
	@Autowired
	private DocumentParaModel documentParaModel;
	
	private Logger LOG = LoggerFactory.getLogger(ClientePersistenceAdapter.class);
	
	@Override
	public Cliente salvar(Cliente cliente) {
		ClienteDocument clienteDocument = this.modelParaDocument.parse(cliente);
		clienteDocument = this.repository.save(clienteDocument);
		Cliente clienteSalvo = this.documentParaModel.parse(clienteDocument);
		return clienteSalvo;
	}
	@Override
	public List<Cliente> listarClientes() {
		List<ClienteDocument> listaClienteDocument = this.repository.findAll();
		List<Cliente> clientes = new ArrayList<>();
		listaClienteDocument.forEach(cliente -> clientes.add(this.documentParaModel.parse(cliente)));
		return clientes;
	}
	@Override
	public Cliente findByCpf(String cpf) {
		LOG.info(">>>>>>>>>>>>>>>>>> Realizando consulta do cliente: " + cpf); 
		ClienteDocument clienteDoc = this.repository.findByCpf(cpf);
		if(!ObjectUtils.isEmpty(clienteDoc)) {
			LOG.info(">>>>>>>>>>>>>>>>>> Cliente Existe, realizando conversão");
			return this.documentParaModel.parse(clienteDoc);
		}
		return null;
	}
	@Override
	public String deletar(String id) {
		return null;
	}
	@Override
	public Cliente existeUsuario(String user, String pass) {
		
		Autenticacao aut = new Autenticacao();
		aut.setPass(pass);
		aut.setUser(user);
		ClienteDocument findByAutenticacao = this.repository.findByAutenticacao(aut);
		if(!ObjectUtils.isEmpty(findByAutenticacao)) {
			return this.documentParaModel.parse(findByAutenticacao);
		}
		return null;
	}
}
