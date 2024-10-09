package com.project.model;

import jakarta.persistence.*;

@Entity
@Table(name = "libros")
public class Libros {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titulo;
    @Column(name = "Nombre Autor")
    private String nameAuthor;
    @Column(name = "Apellido Autor")
    private String lastNameAuthor;
    @Column(name = "Categoria")
    private String category;
    @Column(name = "Precio")
    private Double price;

    public Libros() {
    }

    public Libros(Long id, String titulo, String nameAuthor, String lastNameAuthor, String category, Double price) {
        this.id = id;
        this.titulo = titulo;
        this.nameAuthor = nameAuthor;
        this.lastNameAuthor = lastNameAuthor;
        this.category = category;
        this.price = price;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getNameAuthor() {
        return nameAuthor;
    }

    public void setNameAuthor(String nameAuthor) {
        this.nameAuthor = nameAuthor;
    }

    public String getLastNameAuthor() {
        return lastNameAuthor;
    }

    public void setLastNameAuthor(String lastNameAuthor) {
        this.lastNameAuthor = lastNameAuthor;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}
