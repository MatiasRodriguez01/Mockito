package org.ParcialMockito.repository;

import org.ParcialMockito.entidades.Persona;

import java.util.List;

public interface PersonaRepository {
    Integer count();

    List<Persona> findAll();

    Persona findOne(Long id);

    Persona save(Persona persona);

    boolean delete(Long id);

    void deleteAll();
}
