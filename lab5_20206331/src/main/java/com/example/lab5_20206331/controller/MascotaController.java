package com.example.lab5_20206331.controller;

import com.example.lab5_20206331.entity.Mascota;
import com.example.lab5_20206331.repository.MascotaRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

@Controller
@RequestMapping(value = "/mascotas")
public class MascotaController {
    final MascotaRepository mascotaRepository;

    public MascotaController(MascotaRepository mascotaRepository) {
        this.mascotaRepository = mascotaRepository;
    }

    @GetMapping(value = "")
    public String listarMascotas(Model model){
        model.addAttribute("listaMascotas",mascotaRepository.findAll());
        return "/mascotas/list";
    }

    @GetMapping(value = "/edit")
    public String editarMascota(Model model, @RequestParam("id") int id){
        Optional<Mascota> optionalMascota = mascotaRepository.findById(id);
        if (optionalMascota.isPresent()) {
            Mascota mascotas = optionalMascota.get();
            model.addAttribute("mascotas", mascotas);
            return "/mascotas/nuevo";
        } else {
            return "redirect:/mascotas";
        }
    }
    @RequestMapping(value = "/nuevo")
    public String nuevaMascota(Model model){
        return "mascotas/nuevo";
    }
    @PostMapping(value = "/guardarNuevo")
    public String guardarNuevaMascota(Mascota mascota){
        mascotaRepository.save(mascota);
        return "/mascotas/nuevo";
    }
    @PostMapping(value = "/guardar")
    public String actualizarMascota(Mascota mascota){
        mascotaRepository.actualizarMascota(mascota.getNombreMascota(),mascota.getVacunado(),mascota.getDesparasitado());
        return "/mascotas/nuevo";
    }

    @GetMapping(value = "/borrar")
    public String borrarMascota(Mascota mascota,@RequestParam("id") int id){
        Optional<Mascota> optMascota = mascotaRepository.findById(id);

        if (optMascota.isPresent()) {
            mascotaRepository.deleteById(id);
        }
        return "redirect:/mascotas";
    }
}
