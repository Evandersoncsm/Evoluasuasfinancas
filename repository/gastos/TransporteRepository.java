package com.projeto.evoluasuasfinancas.repository.gastos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.projeto.evoluasuasfinancas.model.gastos.Transporte;

@Repository
public interface TransporteRepository extends JpaRepository<Transporte, Long>{

}
