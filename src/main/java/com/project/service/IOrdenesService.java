package com.project.service;

import com.project.model.Ordenes;

import java.util.List;
import java.util.Optional;

public interface IOrdenesService {
    public List<Ordenes> listarOrdenes();

    public Ordenes guardarOrden(Ordenes ordenes);

    public Optional<Ordenes> buscarOrden(long codigo);

    public void eliminarOrden(long codigo);

}
