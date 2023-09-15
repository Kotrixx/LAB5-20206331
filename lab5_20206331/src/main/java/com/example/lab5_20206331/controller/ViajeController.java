package com.example.lab5_20206331.controller;

import com.example.lab5_20206331.entity.Mascota;
import com.example.lab5_20206331.entity.Viaje;
import com.example.lab5_20206331.repository.LugarRepository;
import com.example.lab5_20206331.repository.PersonaRepository;
import com.example.lab5_20206331.repository.ViajeRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

@Controller
@RequestMapping(value = "/viajes")
public class ViajeController {
    final ViajeRepository viajeRepository;
    final PersonaRepository personaRepository;
    final LugarRepository lugarRepository;

    public ViajeController(ViajeRepository viajeRepository, PersonaRepository personaRepository, LugarRepository lugarRepository) {
        this.viajeRepository = viajeRepository;
        this.personaRepository = personaRepository;
        this.lugarRepository = lugarRepository;
    }


    @RequestMapping(value = "")
    public String listarViajes(Model model){
        model.addAttribute("listaViaje",viajeRepository.findAll());
        return "viajes/list";
    }

    @RequestMapping(value = "/nuevo")
    public String nuevoViaje(Model model){
        model.addAttribute("listaPersonas",personaRepository.findAll());
        model.addAttribute("listaLugares",lugarRepository.findAll());

        return "viajes/nuevo";
    }
    @RequestMapping(value = "/editar")
    public String editarViaje(Model model, @RequestParam("id") int id){
        Optional<Viaje> optionalViaje = viajeRepository.findById(id);
        model.addAttribute("listaPersonas",personaRepository.findAll());
        model.addAttribute("listaLugares",lugarRepository.findAll());

        if (optionalViaje.isPresent()) {
            Viaje viaje = optionalViaje.get();
            model.addAttribute("viaje", viaje);
            return "/viajes/editar";
        } else {
            return "redirect:/viajes";
        }
    }
    @PostMapping(value = "/guardarEdit")
    public String guardarViajeEdit(Viaje viaje){
        viajeRepository.save(viaje);
        return "redirect:/viajes";
    }
    @PostMapping(value = "/guardar")
    public String guardarViaje(Viaje viaje){
        viajeRepository.save(viaje);
        return "redirect:/viajes";
    }

    @GetMapping(value = "/borrar")
    public String borrarViaje(Model model, @RequestParam("id") int id) {
        Optional<Viaje> optionalViaje = viajeRepository.findById(id);
        if (optionalViaje.isPresent()) {
            Viaje viaje = optionalViaje.get();
            viajeRepository.delete(viaje);
            return "/viajes/editar";
        } else {
            return "redirect:/viajes";
        }
    }
}
