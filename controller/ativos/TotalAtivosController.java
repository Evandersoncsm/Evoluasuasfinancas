package com.projeto.evoluasuasfinancas.controller.ativos;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projeto.evoluasuasfinancas.model.ativos.TotalAtivos;
import com.projeto.evoluasuasfinancas.service.ativos.TotalAtivosService;

@RestController
@RequestMapping("/api/totalativos")
public class TotalAtivosController {
	
	@Autowired
	private TotalAtivosService totalAtivosService;
	
	@GetMapping
	public ResponseEntity<List<TotalAtivos>> getAllTotalAtivos(){
		List<TotalAtivos> totalAtivos = totalAtivosService.getAllTotalAtivos();
		System.out.println("Busca realizada!");
		System.out.println("Total ativos encotrado: " + totalAtivos.size());
		System.out.println("HttpStatus 200");
		return ResponseEntity.ok(totalAtivosService.getAllTotalAtivos());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Optional<TotalAtivos>> getByIdTotalAtivos(@PathVariable Long id){
		Optional<TotalAtivos> totalAtivos = totalAtivosService.getByIdTotalAtivos(id);
		if(totalAtivos.isPresent()) {
			System.out.println("HttpStatus 200");
			return ResponseEntity.ok(totalAtivos);
		}
		else {
			System.out.println("Erro 404");
			System.out.println("Não encontrado.");
			return ResponseEntity.notFound().build();
		}
	}
	
}
