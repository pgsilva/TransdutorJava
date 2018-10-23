package com.example.usjt.controller;


import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.usjt.dto.FitaDTO;
import com.example.usjt.dto.ResultadoDTO;
import com.example.usjt.service.FitaService;

@CrossOrigin
@RestController
@Transactional
public class TransdutorController {


	@Autowired
	private FitaService fitaService;
	

	@Transactional
	@RequestMapping(method = RequestMethod.POST, value = "/api/verificaFita")
	public ResponseEntity<ResultadoDTO> verificaFita(@RequestBody FitaDTO fita) {
		try {
			ResultadoDTO form = fitaService.verificaFita(fita);

			return new ResponseEntity<>(form, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
}
