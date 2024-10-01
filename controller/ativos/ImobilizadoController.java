package com.projeto.evoluasuasfinancas.controller.ativos;

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

import com.projeto.evoluasuasfinancas.model.ativos.Imobilizado;
import com.projeto.evoluasuasfinancas.service.ativos.ImobilizadoService;

@RestController
@RequestMapping("/api/imobilizado")
public class ImobilizadoController {
	
	@Autowired
	private ImobilizadoService imobilizadoService;
	
	@GetMapping
	public ResponseEntity<List<Imobilizado>> getAllImobilizado(){
		List<Imobilizado> imobilizado = imobilizadoService.getAllImobilizado();
		System.out.println("Bsuca realizada!");
		System.out.println("Total de imobilizados encontrado: "+imobilizado.size());
		System.out.println("HttpStatus 200");
		return ResponseEntity.ok(imobilizadoService.getAllImobilizado());
	}
	@GetMapping("/{id}")
	public ResponseEntity<Optional<Imobilizado>> getByIdImobilizado(@PathVariable Long id){
		Optional<Imobilizado> imobilizado = imobilizadoService.getByIdImobilizado(id);
		if(imobilizado.isPresent()) {
			System.out.println("HttpStatus 200");
			return ResponseEntity.ok(imobilizado);
		}
		else {
			System.out.println("Erro 404");
			System.out.println("Não encontrado.");
			return ResponseEntity.notFound().build();
		}
	}
	@PostMapping
	public ResponseEntity<Imobilizado> createImobilizado(@RequestBody Imobilizado imobilizado){
		System.out.println("Imobilizado salvo com sucesso!");
		System.out.println("Descrição: "+imobilizado.getDescricao());
		System.out.println("Valor: "+imobilizado.getValor());
		System.out.println("HttpStatus 201");
		return new ResponseEntity<>(imobilizadoService.saveAllImobilizado(imobilizado), HttpStatus.CREATED);
	}
	@PutMapping("/{id}")
	public ResponseEntity<Imobilizado> updateImobilizado(@PathVariable Long id, @RequestBody Imobilizado imobilizado){
		Optional<Imobilizado> existingImobilizado = imobilizadoService.getByIdImobilizado(id);
		if(existingImobilizado.isPresent()) {
		imobilizado.setId(id);
		Imobilizado updateImobilizado = imobilizadoService.saveAllImobilizado(imobilizado);
		System.out.println("Imobilizado atualizado com sucesso!");
		System.out.println("Descrição: "+imobilizado.getDescricao());
		System.out.println("Valor: "+imobilizado.getValor());
		System.out.println("HttpStatus 200");
		return ResponseEntity.ok(updateImobilizado);
		}
	else {
		System.out.println("Erro 404");
		System.out.println("Não encontrado.");
		return ResponseEntity.notFound().build();
		}
	}
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteByIdImobilizado(@PathVariable Long id){
		Optional<Imobilizado> imobilizado = imobilizadoService.getByIdImobilizado(id);
		if(imobilizado.isPresent()) {
			imobilizadoService.deleteByIdImobilizado(id);
			System.out.println("Imobilizado excluído com sucesso!");
			System.out.println("Descrição: "+imobilizado.get().getDescricao());
			System.out.println("Valor: "+imobilizado.get().getValor());
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
