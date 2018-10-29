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
		StringBuilder fitaFinal = new StringBuilder("");
		String[] tokens = fita.getFita().split(" ");

		for (int i = 0; i < tokens.length; i++) {
			for (Character c : tokens[i].toCharArray()) {
				if (Character.isDigit(c)) {
					Integer index = null;
					for (Character c2 : tokens[i].toCharArray()) {
						if(Character.isLetter(c2)) {
							index = tokens[i].indexOf(c2);
							break;
						}
					}
					if(index != null) {
						String variavel = tokens[i].substring(index);
						String numeral = tokens[i].substring(0, index);
						
						if (!numeros.contains(numeral) && !"".equals(numeral)) {
							numeros.add(numeral);
							fitaFinal.append("N(").append(numeral).append(")");
						}
						
						if (!variaveis.contains(variavel) && !"".equals(variavel)) {
							fitaFinal.append("V(").append(variaveis.size()).append(")");
							variaveis.add(variavel);
						} else {
							fitaFinal.append("V(").append(variaveis.indexOf(variavel)).append(")");
						}
						break;
					} else {
						if (!numeros.contains(tokens[i])) {
							numeros.add(tokens[i]);
							fitaFinal.append("N(").append(tokens[i]).append(")");
							break;
						}
					}
				} else {
					if (!variaveis.contains(tokens[i])) {
						fitaFinal.append("V(").append(variaveis.size()).append(")");
						variaveis.add(tokens[i]);
					} else {
						fitaFinal.append("V(").append(variaveis.indexOf(tokens[i])).append(")");
					}
					break;
				}
			}
		}

		System.out.println("TABELA DE VARIÁVEIS");
		for (int i = 0; i < variaveis.size(); i++) {
			System.out.println(i + " ... " + variaveis.get(i));
			result.setVariaveis(variaveis);

		}

		System.out.println("");

		System.out.println("TABELA DE NUMEROS");
		for (int i = 0; i < numeros.size(); i++) {
			System.out.println(i + " ... " + numeros.get(i));
			result.setNumeros(numeros);
		}
		
		System.out.println("LISTA DA FITA LÁ");
		System.out.println(fitaFinal.toString());
		result.setFita(fitaFinal.toString());

		return result;
	}

}
