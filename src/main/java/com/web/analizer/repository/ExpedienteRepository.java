package com.web.analizer.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.web.analizer.model.Expediente;
import com.web.analizer.model.User;

@Repository
public interface ExpedienteRepository extends JpaRepository<Expediente, Long> {
    
	Optional<Expediente> findByAdn(Expediente expediente);
    
    Boolean findByName(String Name);
    
    /* mutation=true, Unmutation=false */
    List<Expediente> findByResult(Boolean mutation);
}
