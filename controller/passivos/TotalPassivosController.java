package com.projeto.evoluasuasfinancas.controller.passivos;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projeto.evoluasuasfinancas.model.passivos.TotalPassivos;
import com.projeto.evoluasuasfinancas.service.passivos.TotalPassivosService;

@RestController
@RequestMapping("/api/totalpassivos")
public class TotalPassivosController {
	
	@Autowired
	private TotalPassivosService totalPassivosService;
	
	@GetMapping
	public ResponseEntity<List<TotalPassivos>> getAllTotalPassivos(){
		List<TotalPassivos> totalPassivos = totalPassivosService.getAllTotalPassivos();
		System.out.println("Busca realizada!");
		System.out.println("Total de Passivos encontrado: "+totalPassivos.size());
		System.out.println("HttpStatus 200");
		return ResponseEntity.ok(totalPassivos);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Optional<TotalPassivos>> getByIdTotalPassivos(@PathVariable Long id){
		Optional<TotalPassivos> totalPassivos = totalPassivosService.getByIdTotalPassivos(id);
		if(totalPassivos.isPresent()) {
			System.out.println("HttpStatus 200");
			return ResponseEntity.ok(totalPassivos);
		}
		else {
			System.out.println("Erro 404");
			System.out.println("Não encontrado.");
			return ResponseEntity.notFound().build();
		}
	}
}







