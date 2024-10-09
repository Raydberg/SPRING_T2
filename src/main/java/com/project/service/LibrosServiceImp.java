package com.project.service;

import com.project.model.Libros;
import com.project.repository.ILibrosRepository;
import com.project.repository.IOrdenesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class LibrosServiceImp implements ILibrosService {
    @Autowired
    private ILibrosRepository librosRepository;

    @Autowired
    private IOrdenesRepository ordenesRepository;


    @Override
    public List<Libros> listarLibros() {
        return librosRepository.findAll();
    }

    @Override
    public Libros guardarLibro(Libros libro) {
        return librosRepository.save(libro);
    }

    @Override
    public Optional<Libros> buscarLibro(long codigo) {
        Optional<Libros> libroOpt = librosRepository.findById(codigo);
        return libroOpt;
    }

    @Transactional
    public void eliminarLibro(long id) {
        ordenesRepository.deleteByLibrosId(id);
        librosRepository.deleteById(id);
    }
}
