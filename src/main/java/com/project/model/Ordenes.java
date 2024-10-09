package com.project.model;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "ordenes")
public class Ordenes {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String clienteId;
    @ManyToOne
    @JoinColumn
    private Libros libros;
    @Column(name = "Fecha de Orden")
    private LocalDate orderDate;

    public Ordenes() {
    }

    public Ordenes(Long id, String clienteId, Libros libros, LocalDate orderDate) {
        this.id = id;
        this.clienteId = clienteId;
        this.libros = libros;
        this.orderDate = orderDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getClienteId() {
        return clienteId;
    }

    public void setClienteId(String clienteId) {
        this.clienteId = clienteId;
    }

    public Libros getLibros() {
        return libros;
    }

    public void setLibros(Libros libros) {
        this.libros = libros;
    }

    public LocalDate getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(LocalDate orderDate) {
        this.orderDate = orderDate;
    }
}
