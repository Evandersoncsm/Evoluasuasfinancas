package com.projeto.evoluasuasfinancas.controller.passivos;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projeto.evoluasuasfinancas.model.passivos.Fornecedores;
import com.projeto.evoluasuasfinancas.service.passivos.FornecedoresService;

@RestController
@RequestMapping("/api/fornecedores")
public class FornecedoresController {
	
	@Autowired
	private FornecedoresService fornecedoresService;
	
	@GetMapping
	public ResponseEntity<List<Fornecedores>> getAllFornecedores(){
		List<Fornecedores> fornecedores = fornecedoresService.getAllFornecedores();
		System.out.println("Busca realizada!");
		System.out.println("Total de Fornecedores encontrado: "+fornecedores.size());
		System.out.println("HttpStatus 200");
		return ResponseEntity.ok(fornecedoresService.getAllFornecedores());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Optional<Fornecedores>> getByIdFornecedores(@PathVariable Long id){
		Optional<Fornecedores> existingFornecedores = fornecedoresService.getByIdFornecedores(id);
		if(existingFornecedores.isPresent()) {
			System.out.println("HttpStatus 200");
			return ResponseEntity.ok(existingFornecedores);
		}
		else {
			System.out.println("Erro 404");
			System.out.println("Não encontrado.");
			return ResponseEntity.notFound().build();
		}
	}
	
	@PostMapping
	public ResponseEntity<Fornecedores> createAllFornecedores(@RequestBody Fornecedores fornecedores){
		System.out.println("Fornecedor salvo com sucesso!");
		System.out.println("Descrição: "+fornecedores.getDescricao());
		System.out.println("Valor: "+fornecedores.getValor());
		System.out.println("HttpStatus 201");
		return new ResponseEntity<>(fornecedoresService.saveAllFornecedores(fornecedores), HttpStatus.CREATED);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Fornecedores> updateByIdFornecedores(@PathVariable Long id, @RequestBody Fornecedores fornecedores){
		Optional<Fornecedores> existingFornecedores = fornecedoresService.getByIdFornecedores(id);
		if(existingFornecedores.isPresent()) {
			fornecedores.setId(id);
			Fornecedores updateByIdFornecedores = fornecedoresService.saveAllFornecedores(fornecedores);
			System.out.println("Fornecedor atualizado com sucesso!");
			System.out.println("Descrição: "+fornecedores.getDescricao());
			System.out.println("Valor: "+fornecedores.getValor());
			System.out.println("HttpStatus 200");
			return ResponseEntity.ok(updateByIdFornecedores);
		}
		else {
			System.out.println("Erro 404");
			System.out.println("Não encontrado.");
			return ResponseEntity.notFound().build();
		}
		
	}

}
