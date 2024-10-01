package com.projeto.evoluasuasfinancas.repository.rendas;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.projeto.evoluasuasfinancas.model.rendas.OutrasRendas;

@Repository
public interface OutrasRendasRepository extends JpaRepository<OutrasRendas, Long>{

}
