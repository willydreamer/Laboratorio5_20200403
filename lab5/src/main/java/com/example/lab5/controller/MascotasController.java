package com.example.lab5.controller;

import com.example.lab5.entity.Mascota;
import com.example.lab5.entity.Viaje;
import com.example.lab5.repository.MascotasRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Optional;

@Controller
@RequestMapping("/mascotas")
public class MascotasController {
    final MascotasRepository mascotasRepository;
    int nitems;

    public MascotasController(MascotasRepository mascotasRepository) {
        this.mascotasRepository = mascotasRepository;
    }

    @GetMapping(value = {"","lista"})
    public String listaMascotas (Model model){
        model.addAttribute("listaMascotas", mascotasRepository.findAll());

        return "listaMascotas";
    };
    @GetMapping(value = {"","nuevo"})
    public String nuevaMascota (Model model){
        return "nuevaMascota";
    };

    @PostMapping("/save")
    public String guardarViaje(Mascota mascota, RedirectAttributes attr) {
        mascotasRepository.save(mascota);
        return "redirect:/lista";
    }

    @GetMapping("/editar")
    public String editarMascota(Model model, @RequestParam("id") int id) {

        Optional<Mascota> optProduct = mascotasRepository.findById(id);

        if (optProduct.isPresent()) {
            Mascota mascota = optProduct.get();
            model.addAttribute("mascota", mascota);
            return "editarMascota";
        } else {
            return "redirect:/lista";
        }
    }

}
