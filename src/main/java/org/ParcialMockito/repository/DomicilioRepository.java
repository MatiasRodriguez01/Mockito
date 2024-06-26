package org.ParcialMockito.repository;

import org.ParcialMockito.entidades.Domicilio;

import java.util.List;

public interface DomicilioRepository {
    Integer count();

    List<Domicilio> findAll();

    Domicilio findOne(Long id);

    Domicilio save(Domicilio domicilio);

    boolean delete(Long id);

    void deleteAll();
}
