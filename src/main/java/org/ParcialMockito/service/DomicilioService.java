package org.ParcialMockito.service;

import org.ParcialMockito.entidades.Domicilio;
import org.ParcialMockito.repository.DomicilioRepositoryImpl;
import org.jetbrains.annotations.NotNull;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DomicilioService {

    private static final Logger logger = LoggerFactory.getLogger(DomicilioService.class);

    @Autowired
    private DomicilioRepositoryImpl domicilioRepositoryImpl;

    public DomicilioService(DomicilioRepositoryImpl domicilioRepositoryImpl) {
        this.domicilioRepositoryImpl = domicilioRepositoryImpl;
    }

    public List<Domicilio> findAll() {
        logger.info("Fetching all domicilios");
        return domicilioRepositoryImpl.findAll();
    }

    public Optional<Domicilio> findById(@NotNull Long id) {
        logger.info("Fetching domicilio with id: " + id);
        Domicilio domicilio = domicilioRepositoryImpl.findOne(id);
        return Optional.ofNullable(domicilio);
    }

    public Domicilio save(@NotNull Domicilio domicilio) {
        logger.info("Saving domicilio: " + domicilio);
        return domicilioRepositoryImpl.save(domicilio);
    }

    public boolean deleteById(@NotNull Long id) {
        logger.info("Deleting domicilio with id: " + id);
        return domicilioRepositoryImpl.delete(id);
    }

    public void deleteAll() {
        logger.info("Deleting all domicilios");
        domicilioRepositoryImpl.deleteAll();
    }
}

