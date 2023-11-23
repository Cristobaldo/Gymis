package com.ep4.ep4.service;


import com.ep4.ep4.Visita;
import com.ep4.ep4.repository.VisitaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class VisitaServiceImplementation implements VisitaService{
    @Autowired
    private VisitaRepository visitaRepository;

    public VisitaServiceImplementation(VisitaRepository visitaRepository) {
        super();
        this.visitaRepository = visitaRepository;
    }


    @Override
    public List<Visita> getAllVisitas() {
        return visitaRepository.findAll();
    }

    @Override
    public Visita saveVisita(Visita visita) throws Exception {
        if(visitaRepository.findByAffiliateDNI(visita.getAffiliateDNI()) != null) {
            throw new Exception("Affiliate DNI already exists");
        }

        return visitaRepository.save(visita);
    }

    @Override
    public Visita getVisitaById(Long id) {
        return null;
    }

    @Override
    public Visita updateVisita(Visita visita) throws Exception {
        Visita existingVisita = visitaRepository.findByAffiliateDNI(visita.getAffiliateDNI());
        if(existingVisita != null && !existingVisita.getId().equals(visita.getId())) {
            throw new Exception("Affiliate DNI already exists");
        }

        return visitaRepository.save(visita);
    }

    @Override
    public void deleteVisitaById(Long id) { visitaRepository.deleteById(id);

    }
}
