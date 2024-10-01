package com.projeto.evoluasuasfinancas.controller.passivos;

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

import com.projeto.evoluasuasfinancas.model.passivos.Emprestimos;
import com.projeto.evoluasuasfinancas.service.passivos.EmprestimosService;

@RestController
@RequestMapping("/api/emprestimos")
public class EmprestimosController {
	
	@Autowired
	private EmprestimosService emprestimosService;
	
	@GetMapping
	public ResponseEntity<List<Emprestimos>> getAllEmprestimos(){
		List<Emprestimos> emprestimos = emprestimosService.getAllEmprestimos();
		System.out.println("Busca realizada!");
		System.out.println("Total de Empréstimos entrado: "+emprestimos.size());
		System.out.println("HttpStatus 200");
		return ResponseEntity.ok(emprestimosService.getAllEmprestimos());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Optional<Emprestimos>> getByIdEmprestimos(@PathVariable Long id){
		Optional<Emprestimos> exitingEmprestimos = emprestimosService.getByIdEmprestimos(id);
		if(exitingEmprestimos.isPresent()) {
			System.out.println("HttpStatus 200");
			return ResponseEntity.ok(exitingEmprestimos);
		}
		else {
			System.out.println("Erro 404");
			System.out.println("Não encontrado!");
			return ResponseEntity.notFound().build();
		}
	}
	
	@PostMapping
	public ResponseEntity<Emprestimos> createAllEmprestimos(@RequestBody Emprestimos emprestimos){
		System.out.println("Empréstimo salvo com sucesso!");
		System.out.println("Descrição: "+emprestimos.getDescricao());
		System.out.println("Valor: "+emprestimos.getValor());
		System.out.println("HttpStatus 201");
		return new ResponseEntity<>(emprestimosService.saveAllEmprestimos(emprestimos), HttpStatus.CREATED);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Emprestimos> updateByIdEmprestimos(@PathVariable Long id, @RequestBody Emprestimos emprestimos){
		Optional<Emprestimos> exitingEmprestimos = emprestimosService.getByIdEmprestimos(id);
		if(exitingEmprestimos.isPresent()) {
			emprestimos.setId(id);
			Emprestimos updateEmprestimos = emprestimosService.saveAllEmprestimos(emprestimos);
			System.out.println("Empréstimo atualizado com sucesso!");
			System.out.println("Descrição: "+updateEmprestimos.getDescricao());
			System.out.println("Valor: "+updateEmprestimos.getValor());
			System.out.println("HttpStatus 200");
			return ResponseEntity.ok(updateEmprestimos);
		}
		else {
			System.out.println("Erro 404");
			System.out.println("Não encontrado!");
			return ResponseEntity.notFound().build();
		}
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteByIdEmprestimos(@PathVariable Long id){
		Optional<Emprestimos> existingEmprestimos = emprestimosService.getByIdEmprestimos(id);
		if(existingEmprestimos.isPresent()) {
			emprestimosService.deleteByIdEmprestimos(id);
			System.out.println("Empréstimo excluído com sucesso!");
			System.out.println("Descrição: "+existingEmprestimos.get().getDescricao());
			System.out.println("valor: "+existingEmprestimos.get().getValor());
			System.out.println("HttpStatus 200");
			return ResponseEntity.noContent().build();
		}
		else {
			System.out.println("Erro 404");
			System.out.println("Não encontrado!");
			return ResponseEntity.notFound().build();
		}
	}
}
