package com.ninoxsolutions.salasagendamento.cliente.integration.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.ninoxsolutions.salasagendamento.common.document.ClienteDocument;
import com.ninoxsolutions.salasagendamento.common.model.Autenticacao;

public interface ClienteRepository extends MongoRepository<ClienteDocument, String>{

	ClienteDocument findByCpf(String cpf);
	ClienteDocument findByAutenticacao(Autenticacao autenticacao);
}
