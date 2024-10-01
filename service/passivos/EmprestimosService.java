package com.projeto.evoluasuasfinancas.service.passivos;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projeto.evoluasuasfinancas.model.passivos.Emprestimos;
import com.projeto.evoluasuasfinancas.repository.passivos.EmprestimosRepository;

@Service
public class EmprestimosService {
	
	@Autowired
	private EmprestimosRepository emprestimosRepository;
	
	public List<Emprestimos> getAllEmprestimos(){
		return emprestimosRepository.findAll();
	}
	public Optional<Emprestimos> getByIdEmprestimos(Long id){
		return emprestimosRepository.findById(id);
	}
	public Emprestimos saveAllEmprestimos(Emprestimos emprestimos) {
		return emprestimosRepository.save(emprestimos);
	}
	public void deleteByIdEmprestimos(Long id) {
		emprestimosRepository.deleteById(id);
	}
}
