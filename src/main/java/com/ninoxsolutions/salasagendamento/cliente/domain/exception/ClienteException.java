package com.ninoxsolutions.salasagendamento.cliente.domain.exception;

public class ClienteException extends RuntimeException{

	private static final long serialVersionUID = 1L;

	public ClienteException(String mensagem) {
		super(mensagem);
	}
}
