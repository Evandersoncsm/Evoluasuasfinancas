package com.projeto.evoluasuasfinancas.repository.ativos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.projeto.evoluasuasfinancas.model.ativos.TotalAtivos;

@Repository
public interface TotalAtivosRepository extends JpaRepository<TotalAtivos, Long>{

}
