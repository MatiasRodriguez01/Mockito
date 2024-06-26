package org.PracticaMockito;

import static org.mockito.Mockito.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.slf4j.Logger;

import java.lang.reflect.Field;

public class UsuarioServiceLoggingTest {

    @Mock
    private UsuarioRepository usuarioRepository;
    private UsuarioService usuarioService;

    @Mock
    private Logger logger;

    @BeforeEach
    void setUp() throws Exception {
        MockitoAnnotations.openMocks(this);
        usuarioService = new UsuarioService(usuarioRepository);

        // Usar reflexión para configurar el campo estático logger
        Field loggerField = UsuarioService.class.getDeclaredField("logger");
        loggerField.setAccessible(true);
        loggerField.set(null, logger);
    }

    @Test
    public void testGetUsuarioByIdLogsInfo() throws Exception {
        // Arrange
        int id = 1;
        Usuario expectedUser = new Usuario((long) id, "Usuario " + id);
        when(usuarioRepository.findById(id)).thenReturn(expectedUser);

        // Act
        usuarioService.getUsuarioById(id);

        // Assert
        verify(logger, times(1)).info("Fetching user with id: {}", id);
    }

}
