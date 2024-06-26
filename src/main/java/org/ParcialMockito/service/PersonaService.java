package org.ParcialMockito.service;

import org.ParcialMockito.entidades.Persona;
import org.ParcialMockito.repository.PersonaRepository;
import org.jetbrains.annotations.NotNull;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PersonaService {

    private static final Logger logger = LoggerFactory.getLogger(PersonaService.class);

    @Autowired
    private PersonaRepository personaRepository;

    public PersonaService(PersonaRepository personaRepository) {
        this.personaRepository = personaRepository;
    }

    public List<Persona> findAll() {
        logger.info("Fetching all personas");
        return personaRepository.findAll();
    }

    public Optional<Persona> findById(@NotNull Long id) {
        logger.info("Fetching persona with id: " + id);
        Persona persona = personaRepository.findOne(id);
        return Optional.ofNullable(persona);
    }

    public Persona save(@NotNull Persona persona) {
        logger.info("Saving persona: " + persona);
        return personaRepository.save(persona);
    }

    public boolean deleteById(@NotNull Long id) {
        logger.info("Deleting persona with id: " + id);
        return personaRepository.delete(id);
    }

    public void deleteAll() {
        logger.info("Deleting all personas");
        personaRepository.deleteAll();
    }
}

