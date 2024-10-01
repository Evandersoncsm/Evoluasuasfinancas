package com.projeto.evoluasuasfinancas.repository.rendas;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.projeto.evoluasuasfinancas.model.rendas.RendaPrincipal;

@Repository
public interface RendaPrincipalRepository extends JpaRepository<RendaPrincipal, Long>{

}
