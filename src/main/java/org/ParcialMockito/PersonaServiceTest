package org.ParcialMockito.service;

import org.ParcialMockito.entidades.Persona;
import org.ParcialMockito.repository.PersonaRepository;
import org.ParcialMockito.repository.PersonaRepositoryImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

public class PersonaServiceTest {

    @Mock
    private PersonaRepositoryImpl personaRepository;

    @InjectMocks
    private PersonaService personaService;

    private Persona persona;

    @BeforeEach
    void setUp() {
        persona = new Persona("John Doe", 25);
        persona.setId(1L);
        personaRepository = mock(PersonaRepositoryImpl.class);
        personaService = new PersonaService(personaRepository);
    }

    @Test
    void testFindAll() {
        List<Persona> personas = Arrays.asList(persona);
        when(personaRepository.findAll()).thenReturn(personas);

        List<Persona> result = personaService.findAll();
        assertEquals(1, result.size());
        assertEquals(persona, result.get(0));

        verify(personaRepository, times(1)).findAll();
    }

    @Test
    void testFindById() {
        when(personaRepository.findOne(1L)).thenReturn(persona);

        Optional<Persona> result = personaService.findById(1L);
        assertTrue(result.isPresent());
        assertEquals(persona, result.get());

        verify(personaRepository, times(1)).findOne(1L);
    }

    @Test
    void testSave() {
        when(personaRepository.save(persona)).thenReturn(persona);

        Persona result = personaService.save(persona);
        assertEquals(persona, result);

        verify(personaRepository, times(1)).save(persona);
    }

    @Test
    void testDeleteById() {
        when(personaRepository.delete(1L)).thenReturn(true);

        boolean result = personaService.deleteById(1L);
        assertTrue(result);

        verify(personaRepository, times(1)).delete(1L);
    }

    @Test
    void testDeleteAll() {
        doNothing().when(personaRepository).deleteAll();

        personaService.deleteAll();

        verify(personaRepository, times(1)).deleteAll();
    }
}
