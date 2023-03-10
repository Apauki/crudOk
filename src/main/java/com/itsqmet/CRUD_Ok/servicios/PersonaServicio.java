package com.itsqmet.CRUD_Ok.servicios;

import com.itsqmet.CRUD_Ok.entidades.Persona;
import com.itsqmet.CRUD_Ok.interfazServicio.InterfazPersonaServicio;
import com.itsqmet.CRUD_Ok.repositorios.PersonaRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonaServicio  implements InterfazPersonaServicio {

    @Autowired
    private PersonaRepository personaRepository;

    @Override
    public List<Persona> listarPersonas() {
        return (List<Persona>)personaRepository.findAll();
    }

    @Override
    public Optional<Persona> listarId(int id) {
        return personaRepository.findById(id);
    }

    @Override
    public int save(Persona persona) {

        int respuesta=0;
        Persona persona1= personaRepository.save(persona);

        if(!persona1.equals(null)){
            respuesta=1;
        }

        return respuesta;
    }

    @Override
    public void delete(int id) {
        personaRepository.deleteById(id);
    }
}
