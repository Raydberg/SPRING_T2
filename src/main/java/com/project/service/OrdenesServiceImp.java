package com.project.service;

import com.project.model.Ordenes;
import com.project.repository.ILibrosRepository;
import com.project.repository.IOrdenesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class OrdenesServiceImp implements IOrdenesService {
    @Autowired
    IOrdenesRepository ordenesRepository;
    @Autowired
    ILibrosRepository librosRepository;

    @Override
    public List<Ordenes> listarOrdenes() {
        return ordenesRepository.findAll();
    }

    @Override
    public Ordenes guardarOrden(Ordenes ordenes) {
        return ordenesRepository.save(ordenes);
    }

    @Override
    public Optional<Ordenes> buscarOrden(long codigo) {
         Optional<Ordenes> ordenOpt = ordenesRepository.findById(codigo);
        return ordenOpt;
    }

    @Override
    public void eliminarOrden(long id) {
        ordenesRepository.deleteById(id);
    }
}
