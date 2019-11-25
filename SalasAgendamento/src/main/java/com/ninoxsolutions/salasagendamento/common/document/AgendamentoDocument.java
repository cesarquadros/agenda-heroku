package com.ninoxsolutions.salasagendamento.common.document;

import java.time.LocalDate;
import java.time.LocalTime;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.ninoxsolutions.salasagendamento.common.model.Agendamento.Status;
import com.ninoxsolutions.salasagendamento.common.model.Cliente;
import com.ninoxsolutions.salasagendamento.common.model.Sala;
import com.querydsl.core.annotations.QueryEntity;

@QueryEntity
@Document
public class AgendamentoDocument {

	@Id
	private String id;
	private Cliente cliente;
	private LocalDate dataAgendamento;
	private Status status;
	private LocalTime hora;
	private Sala sala;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	public LocalDate getDataAgendamento() {
		return dataAgendamento;
	}
	public void setDataAgendamento(LocalDate dataAgendamento) {
		this.dataAgendamento = dataAgendamento;
	}
	public Status getStatus() {
		return status;
	}
	public void setStatus(Status status) {
		this.status = status;
	}
	public LocalTime getHora() {
		return hora;
	}
	public void setHora(LocalTime hora) {
		this.hora = hora;
	}
	public Sala getSala() {
		return sala;
	}
	public void setSala(Sala sala) {
		this.sala = sala;
	}
	@Override
	public String toString() {
		return "AgendamentoDocument [id=" + id + ", cliente=" + cliente + ", dataAgendamento=" + dataAgendamento
				+ ", status=" + status + ", hora=" + hora + ", sala=" + sala + "]";
	}
}
