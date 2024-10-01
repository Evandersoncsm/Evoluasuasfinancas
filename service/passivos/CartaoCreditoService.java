package com.projeto.evoluasuasfinancas.service.passivos;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projeto.evoluasuasfinancas.model.passivos.CartaoCredito;
import com.projeto.evoluasuasfinancas.repository.passivos.CartaoCreditoRepository;

@Service
public class CartaoCreditoService {
	
	@Autowired
	private CartaoCreditoRepository cartaoCreditoRepository;
	
	public List<CartaoCredito> getAllCartaoCredito(){
		return cartaoCreditoRepository.findAll();
	}
	public Optional<CartaoCredito> getByIdCartaoCredito(Long id){
		return cartaoCreditoRepository.findById(id);
	}
	public CartaoCredito saveAllCartaoCredito(CartaoCredito cartaoCredito) {
		return cartaoCreditoRepository.save(cartaoCredito);
	}
	public void deleteByIdCartaoCredito(Long id) { 
		cartaoCreditoRepository.deleteById(id);	
	}
}
