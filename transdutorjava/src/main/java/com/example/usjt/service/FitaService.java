package com.example.usjt.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.usjt.dto.FitaDTO;
import com.example.usjt.dto.ResultadoDTO;

@Service
public class FitaService {

	public ResultadoDTO verificaFita(FitaDTO fita) {
		ResultadoDTO result = new ResultadoDTO();

		List<String> numeros = new ArrayList<>();
		List<String> variaveis = new ArrayList<>();

		String[] tokens = fita.getFita().split(" ");

		for (int i = 0; i < tokens.length; i++) {
			for (Character c : tokens[i].toCharArray()) {
				if (Character.isDigit(c)) {
					continue;
				} else {
					if (!variaveis.contains(tokens[i])) {
						variaveis.add(tokens[i]);
						break;
					}
				}
			}
		}

		System.out.println("TABELA DE VARIÁVEIS");
		for (int i = 0; i < variaveis.size(); i++) {
			System.out.println(i + " ... " + variaveis.get(i));
			result.setVariaveis(variaveis);

		}

		System.out.println("");

		for (int i = 0; i < tokens.length; i++) {
			if (!variaveis.contains(tokens[i])) {
				if (!numeros.contains(tokens[i])) {
					numeros.add(tokens[i]);
				}
			}
		}

		System.out.println("TABELA DE NUMEROS");
		for (int i = 0; i < numeros.size(); i++) {
			System.out.println(i + " ... " + numeros.get(i));
			result.setNumeros(numeros);
		}
		
		System.out.println("LISTA DA FITA LÁ");
		StringBuilder fitaFinal = new StringBuilder("");
		Integer indexNumerais = 0;
		for (int i = 0; i < tokens.length; i++) {
			if(variaveis.contains(tokens[i])) {
				fitaFinal.append("V(").append(i).append(")");
			} else {
				fitaFinal.append("N(").append(numeros.get(indexNumerais)).append(")");
				indexNumerais++;
			}
		}
		System.out.println(fitaFinal.toString());
		result.setFita(fitaFinal.toString());

		return result;
	}

}
