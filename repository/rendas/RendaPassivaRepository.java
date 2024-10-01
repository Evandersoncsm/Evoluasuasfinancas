package com.projeto.evoluasuasfinancas.repository.rendas;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.projeto.evoluasuasfinancas.model.rendas.RendaPassiva;

@Repository
public interface RendaPassivaRepository extends JpaRepository<RendaPassiva, Long>{

}
