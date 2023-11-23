package com.ep4.ep4.controller;

import com.ep4.ep4.Visita;
import com.ep4.ep4.service.VisitaService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class VisitaController {

    private VisitaService visitaService;

    public VisitaController(VisitaService visitaService) {
        super();
        this.visitaService = visitaService;
    }

    @GetMapping("/visitas")
    public String listVisitas(Model model) {
        model.addAttribute("visitas", visitaService.getAllVisitas());
        return "visitas";
    }

    @GetMapping("/visitas/new")
    public String createVisitaForm(Model model) {
            Visita visita = new Visita();
            model.addAttribute("visita", visita);
            return "create_visita";

    }

    @PostMapping("/visitas")
    public String saveVisita(@ModelAttribute("visita") Visita visita) throws Exception
    {
        visitaService.saveVisita(visita);
        return "redirect:/visitas";
    }

    @GetMapping("/visitas/edit/{id}")
    public String editVisitaForm(@PathVariable Long id, Model model) {
        Visita visita = visitaService.getVisitaById(id);
        if (visita == null) {
            return "error";  // Or another appropriate page
        }
        model.addAttribute("visita", visita);
        return "edit_visita";
    }


    @PostMapping("/visitas/{id}")
    public String updateVisita(@PathVariable Long id,
                                @ModelAttribute("visita") Visita visita,
                               Model model) throws Exception {

        // get student from database by id
        Visita existingVisita = visitaService.getVisitaById(id);
        existingVisita.setId(id);
        existingVisita.setLocal(visita.getLocal());
        existingVisita.setAffiliateDNI(visita.getAffiliateDNI());
        existingVisita.setDate(visita.getDate());
        existingVisita.setTime(visita.getTime());

        // save updated student object
        visitaService.updateVisita(existingVisita);
        return "redirect:/visitas";
    }

    // handler method to handle delete student request

    @GetMapping("/visitas/{id}")
    public String deleteVisita(@PathVariable Long id) {
        visitaService.deleteVisitaById(id);
        return "redirect:/visitas";
    }
}
