package com.projeto.evoluasuasfinancas.controller.rendas;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projeto.evoluasuasfinancas.model.rendas.OutrasRendas;
import com.projeto.evoluasuasfinancas.service.rendas.OutrasRendasService;

@RestController
@RequestMapping("/api/outrasrendas")
public class OutrasRendasController {
	
	@Autowired
	private OutrasRendasService outrasRendasService;
	
	@GetMapping
	public ResponseEntity<List<OutrasRendas>> getAllOutrasRendas(){
		List<OutrasRendas> outrasRendas = outrasRendasService.getAllOutrasRendas();
		System.out.println("Busca realizada!");
		System.out.println("Total de Outras Rendas encontrado: "+outrasRendas.size());
		System.out.println("HttpStatus 200");
		return ResponseEntity.ok(outrasRendasService.getAllOutrasRendas());
	}
	@GetMapping("/{id}")
	public ResponseEntity<Optional<OutrasRendas>> getByIdOutrasRendas(@PathVariable Long id){
		Optional<OutrasRendas> outrasRendas = outrasRendasService.getByIdOutrasRendas(id);
		if(outrasRendas.isPresent()) {
			System.err.println("HttpStatus 200");
			return ResponseEntity.ok(outrasRendas);
		}
		else {
			System.out.println("Erro 404");
			System.out.println("Não encontrado.");
			return ResponseEntity.notFound().build();
		}
	}
	@PostMapping
	public ResponseEntity<OutrasRendas> createOutrasRendas(@RequestBody OutrasRendas outrasRendas){
		System.out.println("Outras Rendas salvo com sucesso!");
		System.out.println("Descrição: "+outrasRendas.getDescricao());
		System.out.println("HttpStatus 201");
		return new ResponseEntity<>(outrasRendasService.saveAllOutrasRendas(outrasRendas), HttpStatus.CREATED);
	}
	@PutMapping("/{id}")
	public ResponseEntity<OutrasRendas> updateOutrasRendas(@PathVariable Long id, @RequestBody OutrasRendas outrasRendas){
		Optional<OutrasRendas> existingOutrasRendas = outrasRendasService.getByIdOutrasRendas(id);
		if(existingOutrasRendas.isPresent()) {
			outrasRendas.setId(id);
			OutrasRendas updateOutrasRendas = outrasRendasService.saveAllOutrasRendas(outrasRendas);
			System.out.println("Outras Rendas atualizada com sucesso!");
			System.out.println("Descrição: "+existingOutrasRendas.get().getDescricao());
			System.out.println("HttpStatus 200");
			return ResponseEntity.ok(updateOutrasRendas);
		}
		else {
			System.out.println("Erro 404");
			System.out.println("Não encontrado.");
			return ResponseEntity.ok().build();
		}
	}
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteOutrasRendasById(@PathVariable long id){
		Optional<OutrasRendas> existingOutrasRendas = outrasRendasService.getByIdOutrasRendas(id);
		if(existingOutrasRendas.isPresent()) {
			outrasRendasService.deleteByIdOutrasRendas(id);
			System.out.println("Outras Rendas deletada com sucesso!");
			System.out.println("Descrição: "+existingOutrasRendas.get().getDescricao());
			System.out.println("HttpStatus 200");
			return ResponseEntity.noContent().build();
		}
		else {
			System.out.println("Erro 404");
			System.out.println("Não encontrado.");
			return ResponseEntity.notFound().build();
		}
	}
}
