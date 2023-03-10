package com.itsqmet.CRUD_Ok.controller;

import com.itsqmet.CRUD_Ok.entidades.Persona;
import com.itsqmet.CRUD_Ok.interfazServicio.InterfazPersonaServicio;
import java.util.List;
import java.util.Optional;


import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping
public class PersonaController {

    @Autowired
    private InterfazPersonaServicio servicio;

    @GetMapping("/")
    public String home(){
        return "home";
    }

    @GetMapping("/listar")
    public String listar(Model model){
        List<Persona> personas= servicio.listarPersonas();
        model.addAttribute("personas", personas);
        return "visualizar";
    }



//Crear una persona
    @GetMapping("/form")
    public String crear (Model model){
        model.addAttribute("persona", new Persona());
        return "form";
    }

    @PostMapping("/guardar")
    public String guardar (@Valid Persona persona, Model model){
        servicio.save(persona);
        return "redirect:/listar";
    }


//Actualizar datos de una persona
    @GetMapping("/editar/{id}")
    public String editar(@PathVariable int id , Model model){
        Optional<Persona> persona= servicio.listarId(id);
        model.addAttribute("persona", persona);
        return "form";
    }
    
  //Eliminar una persona del registro
    @GetMapping("/eliminar/{id}")
    public String eliminar (@PathVariable int id){
        servicio.delete(id);
        return "redirect:/listar";
    }
    

}
