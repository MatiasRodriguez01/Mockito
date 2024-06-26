package org.PracticaMockito;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

public class UsuarioSevice2Test {
    @Mock
    private UsuarioRepository usuarioRepository;

    @InjectMocks
    private UsuarioService usuarioService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testUpdateUsuario() throws Exception {
        // Arrange
        int id = 1;
        String nuevoNombre = "Nombre Actualizado";
        Usuario existingUser = new Usuario((long) id, "Usuario " + id);
        when(usuarioRepository.findById(id)).thenReturn(existingUser);
        doNothing().when(usuarioRepository).update(existingUser);

        // Act
        usuarioService.updateUsuario(id, nuevoNombre);

        // Assert
        verify(usuarioRepository, times(1)).findById(id);
        verify(usuarioRepository, times(1)).update(existingUser);
        assertEquals(nuevoNombre, existingUser.getNombre());
    }

    @Test
    public void testUpdateUsuarioThrowsExceptionWhenNotFound() throws Exception {
        // Arrange
        int id = 2;
        String nuevoNombre = "Nombre Actualizado";
        when(usuarioRepository.findById(id)).thenReturn(null);

        // Act & Assert
        Exception exception = assertThrows(Exception.class, () -> {
            usuarioService.updateUsuario(id, nuevoNombre);
        });

        assertEquals("Usuario no encontrado", exception.getMessage());
    }

    @Test
    public void testUpdateUsuarioThrowsExceptionWhenInvalidId() {
        // Act & Assert
        Exception exception = assertThrows(Exception.class, () -> {
            usuarioService.updateUsuario(-1, "Nombre");
        });

        assertEquals("ID inválido", exception.getMessage());
    }

}
