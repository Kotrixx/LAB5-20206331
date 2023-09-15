package com.example.lab5_20206331.controller;

import com.example.lab5_20206331.entity.Lugar;
import com.example.lab5_20206331.entity.Viaje;
import com.example.lab5_20206331.repository.LugarRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

@Controller
@RequestMapping(value = "/lugares")
public class LugarController {
    final LugarRepository lugarRepository;

    public LugarController(LugarRepository lugarRepository) {
        this.lugarRepository = lugarRepository;
    }

    @RequestMapping(value = "")
    public String listarLugares(Model model){
        model.addAttribute("listaLugares",lugarRepository.findAll());
        return "/lugares/list";
    }

    @RequestMapping(value = "/editar")
    public String editarViaje(Model model, @RequestParam("id") int id){
        Optional<Lugar> optionalLugar = lugarRepository.findById(id);
        if (optionalLugar.isPresent()) {
            Lugar lugar = optionalLugar.get();
            model.addAttribute("lugar", lugar);
            return "/lugares/editar";
        } else {
            return "redirect:/lugares";
        }
    }
    @PostMapping(value = "/guardarEdit")
    public String guardarViajeEdit(Lugar lugar){
        lugarRepository.save(lugar);
        return "redirect:/lugares";
    }
    @PostMapping(value = "/guardar")
    public String guardarViaje(Lugar lugar){
        lugarRepository.save(lugar);
        return "redirect:/lugares";
    }

    @GetMapping(value = "/borrar")
    public String borrarViaje(Model model, @RequestParam("id") int id) {
        Optional<Lugar> optionalLugar = lugarRepository.findById(id);
        if (optionalLugar.isPresent()) {
            Lugar lugar = optionalLugar.get();
            model.addAttribute("lugar", lugar);
            return "/lugares/editar";
        } else {
            return "redirect:/lugares";
        }
    }
}
