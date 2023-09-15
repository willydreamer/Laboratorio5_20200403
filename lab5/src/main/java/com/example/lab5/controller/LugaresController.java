package com.example.lab5.controller;

import com.example.lab5.entity.Lugar;
import com.example.lab5.entity.Mascota;
import com.example.lab5.repository.LugaresRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Optional;

@Controller
@RequestMapping("/lugares")
public class LugaresController {
    final LugaresRepository lugaresRepository;

    public LugaresController(LugaresRepository lugaresRepository) {
        this.lugaresRepository = lugaresRepository;
    }

    @GetMapping(value = {"","lista"})
    public String listarLugares (Model model){
        model.addAttribute("listaLugares", lugaresRepository.findAll());
        return "listaLugares";
    };
    @PostMapping("/save")
    public String guardarLugar(Lugar lugar, RedirectAttributes attr) {
        lugaresRepository.save(lugar);
        return "redirect:/lista";
    }

    @GetMapping("/editar")
    public String editarLugar(Model model, @RequestParam("id") int id) {

        Optional<Lugar> optProduct = lugaresRepository.findById(id);

        if (optProduct.isPresent()) {
            Lugar lugar = optProduct.get();
            model.addAttribute("lugar", lugar);
            return "editarLugar";
        } else {
            return "redirect:/lista";
        }
    }

    @GetMapping(value = {"","nuevo"})
    public String nuevoLugar (Model model){
        return "nuevoLugar";
    };

    @GetMapping("/delete")
    public String borrarLugar(Model model,
                                       @RequestParam("id") int id,
                                       RedirectAttributes attr) {

        Optional<Lugar> optProduct = lugaresRepository.findById(id);

        if (optProduct.isPresent()) {
            lugaresRepository.deleteById(id);
        }
        return "redirect:/lista";

    }
}
