package org.ParcialMockito.repository;

import org.ParcialMockito.entidades.Persona;

import java.util.*;

public class PersonaRepositoryImpl implements PersonaRepository {

    private final Map<Long, Persona> personas = new HashMap<>();

    public PersonaRepositoryImpl() {
        // Demo data
        Persona persona1 = new Persona("Persona 1", 25);
        persona1.setId(1L);
        Persona persona2 = new Persona("Persona 2", 30);
        persona2.setId(2L);
        Persona persona3 = new Persona("Persona 3", 35);
        persona3.setId(3L);

        personas.put(1L, persona1);
        personas.put(2L, persona2);
        personas.put(3L, persona3);
    }

    @Override
    public Integer count() {
        return personas.size();
    }

    @Override
    public List<Persona> findAll() {
        return new ArrayList<>(personas.values());
    }

    @Override
    public Persona findOne(Long id) {
        System.out.println("PersonaRepositoryImpl ejecutando findOne para " + id);
        if (id == null) {
            throw new IllegalArgumentException("El ID no puede ser nulo!");
        }
        return personas.get(id);
    }

    @Override
    public Persona save(Persona persona) {
        if (persona.getId() == null || persona.getId() == 0L) {
            persona.setId(getMaxId() + 1);
        }
        personas.put(persona.getId(), persona);
        return persona;
    }

    private Long getMaxId() {
        if (personas.isEmpty()) {
            return 0L;
        }
        return Collections.max(personas.keySet());
    }

    @Override
    public boolean delete(Long id) {
        if (id == null || !personas.containsKey(id)) {
            return false;
        }
        personas.remove(id);
        return true;
    }

    @Override
    public void deleteAll() {
        personas.clear();
    }
}

