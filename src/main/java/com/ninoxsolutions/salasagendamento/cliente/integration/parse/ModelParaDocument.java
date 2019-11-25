package com.ninoxsolutions.salasagendamento.cliente.integration.parse;

import org.springframework.stereotype.Component;

import com.ninoxsolutions.salasagendamento.common.document.ClienteDocument;
import com.ninoxsolutions.salasagendamento.common.model.Cliente;

@Component
public class ModelParaDocument {
	public ClienteDocument parse(Cliente cliente) {
		ClienteDocument clienteDocument = new ClienteDocument();
		clienteDocument.setId(cliente.getId());
		clienteDocument.setCpf(cliente.getCpf());
		clienteDocument.setDataNascimento(cliente.getDataNascimento());
		clienteDocument.setEmail(cliente.getEmail());
		clienteDocument.setNome(cliente.getNome());
		clienteDocument.setSexo(cliente.getSexo());
		clienteDocument.setSobrenome(cliente.getSobrenome());
		clienteDocument.setTelCelular(cliente.getTelCelular());
		clienteDocument.setTelFixo(cliente.getTelFixo());
		clienteDocument.setAutenticacao(cliente.getAutenticacao());
		return clienteDocument;
	}
}
