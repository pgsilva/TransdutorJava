package com.example.usjt.dto;

import java.util.List;

public class ResultadoDTO {

	private List<String> variaveis;
	private List<String> numeros;
	private String fita;

	public String getFita() {
		return fita;
	}

	public void setFita(String fita) {
		this.fita = fita;
	}

	public List<String> getVariaveis() {
		return variaveis;
	}

	public void setVariaveis(List<String> variaveis) {
		this.variaveis = variaveis;
	}

	public List<String> getNumeros() {
		return numeros;
	}

	public void setNumeros(List<String> numeros) {
		this.numeros = numeros;
	}

}
