package com.aguacatech.service.impl;

import com.aguacatech.model.Lote;
import com.aguacatech.repository.LoteRepository;
import com.aguacatech.service.LoteService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LoteServiceImpl implements LoteService {

    private final LoteRepository loteRepository;

    public LoteServiceImpl(LoteRepository loteRepository) {
        this.loteRepository = loteRepository;
    }

    @Override
    public List<Lote> findAll() {
        return loteRepository.findAll();
    }

    @Override
    public Optional<Lote> findById(Integer id) {
        return loteRepository.findById(id);
    }

    @Override
    public Lote save(Lote lote) {
        return loteRepository.save(lote);
    }

    @Override
    public void deleteById(Integer id) {
        loteRepository.deleteById(id);
    }
}
