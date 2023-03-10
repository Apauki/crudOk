package com.itsqmet.CRUD_Ok.interfazServicio;

import com.itsqmet.CRUD_Ok.entidades.Persona;
import com.itsqmet.CRUD_Ok.repositorios.PersonaRepository;
import java.util.List;
import java.util.Optional;



public interface InterfazPersonaServicio {

    public List<Persona> listarPersonas(); //Leer  -  Read
    public Optional<Persona> listarId(int id); //Actualizar  - Update
    public int save(Persona persona); //Crear - Create

    public void delete(int id); //Eliminar- Remove
}
