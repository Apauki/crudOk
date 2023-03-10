package com.itsqmet.CRUD_Ok.repositorios;

import com.itsqmet.CRUD_Ok.entidades.Persona;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonaRepository extends JpaRepository<Persona, Integer> {
}
