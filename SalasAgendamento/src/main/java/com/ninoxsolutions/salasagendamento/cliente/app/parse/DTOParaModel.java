package com.ninoxsolutions.salasagendamento.cliente.app.parse;

import org.springframework.stereotype.Component;

import com.ninoxsolutions.salasagendamento.common.dto.ClienteDTO;
import com.ninoxsolutions.salasagendamento.common.model.Cliente;

@Component
public class DTOParaModel {
	
	public Cliente parse(ClienteDTO dto) {
		Cliente cliente = new Cliente();
		cliente.setCpf(dto.getCpf());
		cliente.setDataNascimento(dto.getDataNascimento());
		cliente.setEmail(dto.getEmail());
		cliente.setNome(dto.getNome());
		cliente.setSexo(dto.getSexo());
		cliente.setSobrenome(dto.getSobrenome());
		cliente.setTelCelular(dto.getTelCelular());
		cliente.setTelFixo(dto.getTelFixo());
		cliente.setAutenticacao(dto.getAutenticacao());
		return cliente;
 	}
}
