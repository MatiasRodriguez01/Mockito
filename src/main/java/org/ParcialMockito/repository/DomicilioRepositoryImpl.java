package org.ParcialMockito.repository;

import org.ParcialMockito.entidades.Domicilio;

import java.util.*;

public class DomicilioRepositoryImpl implements DomicilioRepository {

    private final Map<Long, Domicilio> domicilios = new HashMap<>();

    public DomicilioRepositoryImpl() {
        // Demo data
        Domicilio domicilio1 = new Domicilio("Calle 1", 123, 45678);
        domicilio1.setId(1L);
        Domicilio domicilio2 = new Domicilio("Calle 2", 456, 12345);
        domicilio2.setId(2L);
        Domicilio domicilio3 = new Domicilio("Calle 3", 789, 67890);
        domicilio3.setId(3L);

        domicilios.put(1L, domicilio1);
        domicilios.put(2L, domicilio2);
        domicilios.put(3L, domicilio3);
    }

    @Override
    public Integer count() {
        return domicilios.size();
    }

    @Override
    public List<Domicilio> findAll() {
        return new ArrayList<>(domicilios.values());
    }

    @Override
    public Domicilio findOne(Long id) {
        System.out.println("DomicilioRepositoryImpl ejecutando findOne para " + id);
        if (id == null) {
            throw new IllegalArgumentException("El ID no puede ser nulo!");
        }
        return domicilios.get(id);
    }

    @Override
    public Domicilio save(Domicilio domicilio) {
        if (domicilio.getId() == null || domicilio.getId() == 0L) {
            domicilio.setId(getMaxId() + 1);
        }
        domicilios.put(domicilio.getId(), domicilio);
        return domicilio;
    }

    private Long getMaxId() {
        if (domicilios.isEmpty()) {
            return 0L;
        }
        return Collections.max(domicilios.keySet());
    }

    @Override
    public boolean delete(Long id) {
        if (id == null || !domicilios.containsKey(id)) {
            return false;
        }
        domicilios.remove(id);
        return true;
    }

    @Override
    public void deleteAll() {
        domicilios.clear();
    }
}
