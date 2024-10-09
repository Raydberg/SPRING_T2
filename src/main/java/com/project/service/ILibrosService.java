package com.project.service;

import com.project.model.Libros;

import java.util.List;
import java.util.Optional;

public interface ILibrosService {
    public List<Libros> listarLibros();

    public Libros guardarLibro(Libros libros);

    public Optional<Libros> buscarLibro(long codigo);

    public void eliminarLibro(long codigo);

}
