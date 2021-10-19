package com.example.interfazService;

import com.example.modelo.Persona;

import java.util.List;

public interface IpersonaService {
    public List<Persona> listar();
    public Persona listarid(Persona persona);
    public void save(Persona p);
    public void delete(int id);
}
