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

import com.projeto.evoluasuasfinancas.model.passivos.CartaoCredito;
import com.projeto.evoluasuasfinancas.service.passivos.CartaoCreditoService;

@RestController
@RequestMapping("/api/cartoescredito")
public class CartaoCreditoController {
	
	@Autowired
	private CartaoCreditoService cartaoCreditoService;
	
	@GetMapping
	public ResponseEntity<List<CartaoCredito>> getAllCartaoCredito(){
		List<CartaoCredito> cartaoCredito = cartaoCreditoService.getAllCartaoCredito();
		System.out.println("Busca realizada!");
		System.out.println("Total de Cartões de Crédito econtrado: "+cartaoCredito.size());
		System.out.println("HttpStatus 200");
		return ResponseEntity.ok(cartaoCreditoService.getAllCartaoCredito());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Optional<CartaoCredito>> getByIdCartaoCredito(@PathVariable Long id){
		Optional<CartaoCredito> cartaoCredito = cartaoCreditoService.getByIdCartaoCredito(id);
		if(cartaoCredito.isPresent()) {
			System.out.println("HttpStatus 200");
			return ResponseEntity.ok(cartaoCredito);
		}
		else {
			System.out.println("Erro 404");
			System.out.println("Não encontrado.");
			return ResponseEntity.notFound().build();
		}
	}
	
	@PostMapping
	public ResponseEntity<CartaoCredito> createAllCartaoCredito(@RequestBody CartaoCredito cartaoCredito){
		System.out.println("Conta do Cartão de Crédito salvo com sucesso!!");
		System.out.println("Descrição: "+cartaoCredito.getDescricao());
		System.out.println("Valor: "+cartaoCredito.getValor());
		System.out.println("HttpStatus 201");
		return new ResponseEntity<>(cartaoCreditoService.saveAllCartaoCredito(cartaoCredito), HttpStatus.CREATED);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<CartaoCredito> updateCartaoCredito(@PathVariable Long id, @RequestBody CartaoCredito cartaoCredito){
		Optional<CartaoCredito> existingCartaoCredito = cartaoCreditoService.getByIdCartaoCredito(id);
		if(existingCartaoCredito.isPresent()) {
			cartaoCredito.setId(id);
			CartaoCredito updateCartaoCredito = cartaoCreditoService.saveAllCartaoCredito(cartaoCredito);
			System.out.println("Conta do Cartão de Crédito atualizada com sucesso!");
			System.out.println("Descrição: "+existingCartaoCredito.get().getDescricao());
			System.out.println("Valor: "+cartaoCredito.getValor());
			System.out.println("HttpStatus 200");
			return ResponseEntity.ok(updateCartaoCredito);
		}
		else {
			System.out.println("Erro 404");
			System.out.println("Não encontrado.");
			return ResponseEntity.notFound().build();
		}
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteByIdCartaoCredito(@PathVariable Long id){
		Optional<CartaoCredito> existingCartaoCredito = cartaoCreditoService.getByIdCartaoCredito(id);
		if(existingCartaoCredito.isPresent()) {
			cartaoCreditoService.deleteByIdCartaoCredito(id);
			System.out.println("Conta do Cartão de Crédito excluída com sucesso!");
			System.out.println("Descrição: "+existingCartaoCredito.get().getDescricao());
			System.out.println("Valor: "+existingCartaoCredito.get().getValor());
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









