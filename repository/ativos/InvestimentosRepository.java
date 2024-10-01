package com.projeto.evoluasuasfinancas.repository.ativos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.projeto.evoluasuasfinancas.model.ativos.Investimentos;

@Repository
public interface InvestimentosRepository extends JpaRepository<Investimentos, Long>{

}
