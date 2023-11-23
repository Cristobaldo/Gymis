package com.ep4.ep4.service;

import com.ep4.ep4.Visita;

import java.util.List;


public interface VisitaService {
    List<Visita> getAllVisitas();

    Visita saveVisita(Visita visita) throws Exception;

   Visita getVisitaById(Long id);

    Visita updateVisita(Visita visita) throws Exception;

    void deleteVisitaById(Long id);
}