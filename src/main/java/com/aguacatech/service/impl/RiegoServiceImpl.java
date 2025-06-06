package com.aguacatech.service.impl;

import com.aguacatech.model.Riego;
import com.aguacatech.repository.RiegoRepository;
import com.aguacatech.service.RiegoService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RiegoServiceImpl implements RiegoService {

    private final RiegoRepository riegoRepository;

    public RiegoServiceImpl(RiegoRepository riegoRepository) {
        this.riegoRepository = riegoRepository;
    }

    @Override
    public List<Riego> findAll() {
        return riegoRepository.findAll();
    }

    @Override
    public Optional<Riego> findById(Integer id) {
        return riegoRepository.findById(id);
    }

    @Override
    public Riego save(Riego riego) {
        return riegoRepository.save(riego);
    }

    @Override
    public void deleteById(Integer id) {
        riegoRepository.deleteById(id);
    }
}
