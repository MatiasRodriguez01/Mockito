package org.PracticaMockito;

public class UsuarioRepository {

    public Usuario findById(int id) throws Exception {
        if (id < 0) {
            throw new Exception("ID inválido");
        }
        return new Usuario((long) id,"Usuario " + id);
    }
    public void save(Usuario usuario) throws Exception {
        // Simulate saving the user
        if (usuario.getId() < 0) {
            throw new Exception("ID inválido");
        }
        System.out.println("Usuario " + usuario.getNombre() + " guardado.");
    }

    public void update(Usuario usuario) throws Exception {
        // Simulate updating the user
        if (usuario.getId() < 0) {
            throw new Exception("ID inválido");
        }
        System.out.println("Usuario " + usuario.getNombre() + " actualizado.");
    }


}
