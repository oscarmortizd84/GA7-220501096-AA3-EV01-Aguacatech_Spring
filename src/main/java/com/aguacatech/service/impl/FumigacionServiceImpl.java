package com.aguacatech.service.impl;

import com.aguacatech.model.Fumigacion;
import com.aguacatech.repository.FumigacionRepository;
import com.aguacatech.service.FumigacionService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FumigacionServiceImpl implements FumigacionService {

    private final FumigacionRepository fumigacionRepository;

    public FumigacionServiceImpl(FumigacionRepository fumigacionRepository) {
        this.fumigacionRepository = fumigacionRepository;
    }

    @Override
    public List<Fumigacion> findAll() {
        return fumigacionRepository.findAll();
    }

    @Override
    public Optional<Fumigacion> findById(Integer id) {
        return fumigacionRepository.findById(id);
    }

    @Override
    public Fumigacion save(Fumigacion fumigacion) {
        return fumigacionRepository.save(fumigacion);
    }

    @Override
    public void deleteById(Integer id) {
        fumigacionRepository.deleteById(id);
    }
}
