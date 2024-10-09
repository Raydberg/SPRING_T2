package com.project.controller;

import com.project.model.Libros;
import com.project.service.LibrosServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Optional;

@Controller
public class LibrosController {
    @Autowired
    LibrosServiceImp service;

     @GetMapping("/")
    public String index() {
         return "index";
     }
    @GetMapping("/libros")
    public String showLibros(Model model) {
        model.addAttribute("libros", service.listarLibros());
        model.addAttribute("libro", new Libros());
        return "libros";
    }

    @GetMapping("/agregarLibro")
    public String mostrarFormulario(Model model) {
        model.addAttribute("libros", new Libros());
        return "libros";
    }

    @PostMapping("/agregarLibro")
    public String agregar(@ModelAttribute Libros libro) {
        service.guardarLibro(libro);
        return "redirect:/libros";
    }
    @GetMapping("/editarLibro/{id}")
    public String mostrarFormularioEdicion(@PathVariable Long id, Model model) {
        Optional<Libros> libro = service.buscarLibro(id);
        if (libro.isPresent()) {
            model.addAttribute("libro", libro.get());
            return "Form"; // Redirige a Form.html
        } else {
            return "redirect:/libros";
        }
    }
    @PostMapping("/editarLibro/{id}")
    public String actualizarLibro(@PathVariable Long id, @ModelAttribute Libros libro) {
        libro.setId(id);
        service.guardarLibro(libro);
        return "redirect:/libros";
    }
    @GetMapping("/eliminar/{id}")
    public String eliminarLibro(Model model, @PathVariable long id) {
        service.eliminarLibro(id);
        return "redirect:/libros";
    }
}
