package com.aguacatech.service.impl;

import com.aguacatech.model.Abono;
import com.aguacatech.repository.AbonoRepository;
import com.aguacatech.service.AbonoService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AbonoServiceImpl implements AbonoService {

    private final AbonoRepository abonoRepository;

    public AbonoServiceImpl(AbonoRepository abonoRepository) {
        this.abonoRepository = abonoRepository;
    }

    @Override
    public List<Abono> findAll() {
        return abonoRepository.findAll();
    }

    @Override
    public Optional<Abono> findById(Integer id) {
        return abonoRepository.findById(id);
    }

    @Override
    public Abono save(Abono abono) {
        return abonoRepository.save(abono);
    }

    @Override
    public void deleteById(Integer id) {
        abonoRepository.deleteById(id);
    }
}
