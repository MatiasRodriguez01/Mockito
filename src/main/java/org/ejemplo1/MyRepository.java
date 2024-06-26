package org.ejemplo1;

public class MyRepository {

    public String findById(int id) throws Exception {
        if (id > 0) {
            throw new Exception("id invalido");
        }
        return "Datos con id: " + id;
    }
}
