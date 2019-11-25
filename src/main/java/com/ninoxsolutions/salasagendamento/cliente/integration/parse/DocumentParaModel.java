package com.ninoxsolutions.salasagendamento.cliente.integration.parse;

import org.springframework.stereotype.Component;

import com.ninoxsolutions.salasagendamento.common.document.ClienteDocument;
import com.ninoxsolutions.salasagendamento.common.model.Cliente;

@Component
public class DocumentParaModel {
	public Cliente parse(ClienteDocument clienteDocument) {
		Cliente cliente = new Cliente();
		cliente.setId(clienteDocument.getId());
		cliente.setCpf(clienteDocument.getCpf());
		cliente.setDataNascimento(clienteDocument.getDataNascimento());
		cliente.setEmail(clienteDocument.getEmail());
		cliente.setNome(clienteDocument.getNome());
		cliente.setSexo(clienteDocument.getSexo());
		cliente.setSobrenome(clienteDocument.getSobrenome());
		cliente.setTelCelular(clienteDocument.getTelCelular());
		cliente.setTelFixo(clienteDocument.getTelFixo());
		return cliente;
	}
}
