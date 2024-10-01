package com.projeto.evoluasuasfinancas.controller.patrimonio;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projeto.evoluasuasfinancas.model.patrimonio.Patrimonio;
import com.projeto.evoluasuasfinancas.service.patrimonio.PatrimonioService;

@RestController
@RequestMapping("/api/patrimonio")
public class PatrimonioController {
	
	@Autowired
	private PatrimonioService patrimonioService;
	
	@GetMapping
	public ResponseEntity<List<Patrimonio>> getAllPatrimonio(){
		List<Patrimonio> patrimonio = patrimonioService.getAllPatrimonio();
		System.out.println("Busca realizada!");
		System.out.println("Total de Passivos encontrado: " + patrimonio.size());
		System.out.println("HttpStatus 200");
		return ResponseEntity.ok(patrimonio);

	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Optional<Patrimonio>> getByIdPatrimonio(@PathVariable Long id){
		Optional<Patrimonio> patrimonio = patrimonioService.getByIdPatrimonio(id);
		if(patrimonio.isPresent()) {
			System.out.println("HttpStatus 200");
			return ResponseEntity.ok(patrimonio);
		}
		else {
			System.out.println("Erro 404");
			System.out.println("Não encontrado.");
			return ResponseEntity.notFound().build();
		}
	}
}
