package com.example.lab5_20206331.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/viajes")
public class ViajeController {

    @RequestMapping(value = "")
    public String listarViajes(){

        return "viajes/listar";
    }
}
