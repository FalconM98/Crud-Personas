package com.example.service;

import com.example.interfaz.IPersona;
import com.example.interfazService.IpersonaService;
import com.example.modelo.Persona;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PersonaService implements IpersonaService {

    @Autowired
    private IPersona personaService;

    @Override
    @Transactional(readOnly = true)
    public List<Persona> listar() {
        return (List<Persona>) personaService.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Persona listarid(Persona persona) {
        return personaService.findById(persona.getId()).orElse(null);
    }

    @Override
    @Transactional
    public void save(Persona p) {
        personaService.save(p);
    }

    @Override
    @Transactional
    public void delete(int id) {
        personaService.deleteById(id);
    }

}
