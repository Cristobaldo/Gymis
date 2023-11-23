package com.ep4.ep4.repository;

import com.ep4.ep4.Visita;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface VisitaRepository extends JpaRepository<Visita, Long>{
    @Query("SELECT s FROM Visita s WHERE s.AffiliateDNI = ?1")
    Visita findByAffiliateDNI(String AffiliateDNI);

}
