package com.example.lab5.controller;

import com.example.lab5.entity.Viaje;
import com.example.lab5.repository.LugaresRepository;
import com.example.lab5.repository.PersonasRepository;
import com.example.lab5.repository.ViajesRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/viajes")
public class ViajesController {
    final ViajesRepository viajesRepository;
    final PersonasRepository personasRepository;
    final LugaresRepository lugaresRepository;

    public ViajesController(ViajesRepository viajesRepository, PersonasRepository personasRepository, LugaresRepository lugaresRepository) {
        this.viajesRepository = viajesRepository;
        this.personasRepository = personasRepository;
        this.lugaresRepository = lugaresRepository;
    }

    @GetMapping(value = {"","lista"})
    public String listaViajes (Model model){
        model.addAttribute("lista", viajesRepository.findAll());
        model.addAttribute("listaPersonas", personasRepository.findAll());
        model.addAttribute("listaLugares", lugaresRepository.findAll());
        return "listaViajes";
    };

    @GetMapping(value = {"","nuevo"})
    public String nuevoViaje (Model model){
        model.addAttribute("listaPersonas", personasRepository.findAll());
        model.addAttribute("listaLugares", lugaresRepository.findAll());
        return "nuevoViaje";
    };
    @PostMapping("/save")
    public String guardarViaje(Viaje viaje, RedirectAttributes attr) {
        viajesRepository.save(viaje);
        return "redirect:/lista";
    }




}
