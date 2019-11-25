package com.ninoxsolutions.salasagendamento.cliente.app.rest;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.ninoxsolutions.salasagendamento.cliente.app.parse.DTOParaModel;
import com.ninoxsolutions.salasagendamento.cliente.app.port.ClienteRestPort;
import com.ninoxsolutions.salasagendamento.cliente.domain.service.ClienteService;
import com.ninoxsolutions.salasagendamento.common.dto.ClienteDTO;
import com.ninoxsolutions.salasagendamento.common.model.Cliente;

import io.swagger.annotations.Api;

@CrossOrigin(origins = "*")
@RestController
@Api(value = "Cliente", tags = "Cliente")
public class ClienteRestAdapter implements ClienteRestPort {
	
	@Autowired
	private ClienteService service;
	@Autowired
	private DTOParaModel dtoParaModel;
	
	private Logger LOG = LoggerFactory.getLogger(ClienteRestAdapter.class);

	@Override
	public ResponseEntity<Cliente> salvar(@RequestBody ClienteDTO clienteDTO) {
		Cliente cliente = this.dtoParaModel.parse(clienteDTO);
		cliente = this.service.salvar(cliente);
		return ResponseEntity.ok(cliente);
	}
	
	@Override
	public ResponseEntity<List<Cliente>> listarClientes() {
		List<Cliente> clientes = this.service.listarClientes();
		return ResponseEntity.ok(clientes);
	}
	
	@Override
	public ResponseEntity<Object> findByCpf(@PathVariable(value = "cpf") String cpf) {
		LOG.info(">>>>>>>>>>>>>>> Consultando cliente: "+cpf);
		Cliente cliente = this.service.findByCpf(cpf);
		if(ObjectUtils.isEmpty(cliente)) {
			ResponseEntity<Object> response = new ResponseEntity<>(HttpStatus.NO_CONTENT);
			return response;
		}
		return ResponseEntity.ok(cliente);
	}

	@Override
	public ResponseEntity<Object> findUsuario(@RequestHeader("user")String user,@RequestHeader("pass")String pass) {
		Cliente usuarioExiste = this.service.existeUsuario(user, pass);
		return ResponseEntity.ok(usuarioExiste);
	}
}
