package org.ParcialMockito.service;

import static org.junit.jupiter.api.Assertions.*;

import org.ParcialMockito.entidades.Domicilio;
import org.ParcialMockito.repository.DomicilioRepository;
import org.ParcialMockito.repository.DomicilioRepositoryImpl;
import org.ejemplo2.repository.EmployeeRepositoryImpl;
import org.ejemplo2.service.EmployeeServiceImpl;
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

class DomicilioServiceTest {

    @Mock
    private DomicilioRepositoryImpl domicilioRepository;

    @InjectMocks
    private DomicilioService domicilioService;

    private Domicilio domicilio;

    @BeforeEach
    void setUp() {
        domicilio = new Domicilio("Calle Falsa", 123, 45678);
        domicilio.setId(1L);
        domicilioRepository = mock(DomicilioRepositoryImpl.class); // objeto ficticio creado por Mockito
        domicilioService = new DomicilioService(domicilioRepository);
    }

    @Test
    void testFindAll() {
        List<Domicilio> domicilios = Arrays.asList(domicilio);
        when(domicilioRepository.findAll()).thenReturn(domicilios);

        List<Domicilio> result = domicilioService.findAll();
        assertEquals(1, result.size());
        assertEquals(domicilio, result.get(0));

        verify(domicilioRepository, times(1)).findAll();
    }

    @Test
    void testFindById() {
        when(domicilioRepository.findOne(1L)).thenReturn(domicilio);

        Optional<Domicilio> result = domicilioService.findById(1L);
        assertTrue(result.isPresent());
        assertEquals(domicilio, result.get());

        verify(domicilioRepository, times(1)).findOne(1L);
    }

    @Test
    void testSave() {
        when(domicilioRepository.save(domicilio)).thenReturn(domicilio);

        Domicilio result = domicilioService.save(domicilio);
        assertEquals(domicilio, result);

        verify(domicilioRepository, times(1)).save(domicilio);
    }

    @Test
    void testDeleteById() {
        when(domicilioRepository.delete(1L)).thenReturn(true);

        boolean result = domicilioService.deleteById(1L);
        assertTrue(result);

        verify(domicilioRepository, times(1)).delete(1L);
    }

    @Test
    void testDeleteAll() {
        doNothing().when(domicilioRepository).deleteAll();

        domicilioService.deleteAll();

        verify(domicilioRepository, times(1)).deleteAll();
    }
}