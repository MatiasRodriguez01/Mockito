package org.PracticaMockito;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UsuarioService {

    private static final Logger logger = LoggerFactory.getLogger(UsuarioService.class);

    private final UsuarioRepository usuarioRepository;

    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }
    public Usuario getUsuarioById(int id) throws Exception {
        return usuarioRepository.findById(id);
    }
    public void createUsuario(Usuario usuario) throws Exception {
        usuarioRepository.save(usuario);
    }
    public void updateUsuario(int id, String nuevoNombre) throws Exception {
        validateId(id);
        Usuario usuario = usuarioRepository.findById(id);
        if (usuario == null) {
            throw new Exception("Usuario no encontrado");
        }
        usuario.setNombre(nuevoNombre);
        usuarioRepository.update(usuario);
    }


    private void validateId(int id) throws Exception {
        if (id < 0) {
            logger.error("Invalid ID: {}", id);
            throw new Exception("ID inválido");
        }
    }

    private void validateUsuario(Usuario usuario) throws Exception {
        if (usuario == null || usuario.getId() < 0) {
            logger.error("Invalid user: {}", usuario);
            throw new Exception("Usuario inválido");
        }
    }

}
