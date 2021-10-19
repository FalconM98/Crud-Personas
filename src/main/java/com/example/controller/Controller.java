package com.example.controller;

import com.example.interfazService.IpersonaService;
import com.example.modelo.Persona;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@org.springframework.stereotype.Controller
@RequestMapping
@Slf4j
public class Controller  {

    @Autowired
    private IpersonaService service;

    @GetMapping("/")
    public String listar(Model model){
        List<Persona> personas = service.listar();
        log.info("Se esta ejecuanto este controlador MVC");
        model.addAttribute("personas",personas);
        return "index";
    }

    @GetMapping("/agregar")
    public String agregar(Persona persona){
        return "modificar";
    }

    @PostMapping("/guardar")
    public String guardar(Persona persona){
        service.save(persona);
        return "redirect:/";
    }

    @GetMapping("/editar/{id}")
    public String editar(Persona persona, Model model){
        persona = service.listarid(persona);
        model.addAttribute("personas",persona);
        return "modificar";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminar(Model model, @PathVariable int id){
        service.delete(id);
        return "redirect:/";
    }
}
