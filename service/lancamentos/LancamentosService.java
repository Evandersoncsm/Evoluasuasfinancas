package com.projeto.evoluasuasfinancas.service.lancamentos;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projeto.evoluasuasfinancas.model.lancamento.Lancamentos;
import com.projeto.evoluasuasfinancas.repository.lancamentos.LancamentosRepository;

@Service
public class LancamentosService {

    @Autowired
    private LancamentosRepository lancamentosRepository;

    public List<Lancamentos> getAllLancamentos() {
        return lancamentosRepository.findAll();
    }

    public Lancamentos getLancamentoById(Long id) {
        return lancamentosRepository.findById(id).orElse(null);
    }

    public Lancamentos saveLancamento(Lancamentos lancamento) {
        return lancamentosRepository.save(lancamento);
    }

    public void deleteLancamento(Long id) {
        lancamentosRepository.deleteById(id);
    }
    public void deleteAllLancamentos(Lancamentos lancamentos) {
    	lancamentosRepository.deleteAll();
    }
}

