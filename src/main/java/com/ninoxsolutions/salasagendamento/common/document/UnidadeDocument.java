package com.ninoxsolutions.salasagendamento.common.document;

import java.util.List;

import org.springframework.data.mongodb.core.mapping.Document;

import com.ninoxsolutions.salasagendamento.common.model.Sala;

@Document
public class UnidadeDocument {

	private String id;
	private String nomeUnidade;
	private String endereco;
	private List<Sala> listaSala;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getNomeUnidade() {
		return nomeUnidade;
	}
	public void setNomeUnidade(String nomeUnidade) {
		this.nomeUnidade = nomeUnidade;
	}
	public List<Sala> getListaSala() {
		return listaSala;
	}
	public void setListaSala(List<Sala> listaSala) {
		this.listaSala = listaSala;
	}
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	@Override
	public String toString() {
		return "UnidadeDocument [id=" + id + ", nomeUnidade=" + nomeUnidade + ", endereco=" + endereco + ", listaSala="
				+ listaSala + "]";
	}
}
