package org.PracticaMockito;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class UsuarioServiceTest {

    @Mock
    private UsuarioRepository usuarioRepository;

    @InjectMocks
    private UsuarioService usuarioService;

    /*
    @Test
    void getUsuarioById() {
    }

    @Test
    void createUsuario() {
    }

     */

    @BeforeEach
    void setUp(){
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testCreateUsuario() throws Exception {
        // Arrance
        Usuario newUser = new Usuario(2L, "Nuevo usuario");
        doNothing().when(usuarioRepository).save(newUser);

        // Act
        usuarioService.createUsuario(newUser);

        // Assert
        verify(usuarioRepository, times(1)).save(newUser);

    }

    @Test
    void testCreateUsuarioThrowsException() throws Exception {
        // Arrange
        Usuario newUser = new Usuario(-1L, "Usuario Inválido");
        doThrow(new Exception("ID inválido")).when(usuarioRepository).save(newUser);

        // Act & Assert
        Exception exception = assertThrows(Exception.class, () -> {
            usuarioService.createUsuario(newUser);
        });

        assertEquals("ID inválido", exception.getMessage());
    }

    @Test
    void testGetUsuarioByIdNotFound() throws Exception{
        // Arrange
        int id = 100;
        when(usuarioRepository.findById(id)).thenReturn(null);

        // Act
        Usuario actualUser = usuarioService.getUsuarioById(id);

        // Assert
        assertEquals(null, actualUser);

    }

    @Test
    void testGetUsuarioByIdThrowsAnotherException() throws Exception{
        // Arrange
        int id = 1;
        when(usuarioRepository.findById(id)).thenThrow(new Exception("Otro error"));

        // Act & Assert
        Exception exception = assertThrows(Exception.class, () -> {
            usuarioService.getUsuarioById(id);
        });

        assertEquals("Otro error", exception.getMessage());

    }


}