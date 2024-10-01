package com.projeto.evoluasuasfinancas.repository.ativos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.projeto.evoluasuasfinancas.model.ativos.Disponibilidades;

@Repository
public interface DisponibilidadesRepository extends JpaRepository<Disponibilidades, Long>{

}
