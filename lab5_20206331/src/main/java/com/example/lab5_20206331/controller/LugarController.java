package com.example.lab5_20206331.controller;

import com.example.lab5_20206331.repository.LugarRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

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
}
