package com.project.controller;

import com.project.model.Ordenes;
import com.project.service.IOrdenesService;
import com.project.service.LibrosServiceImp;
import com.project.service.OrdenesServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Optional;

@Controller
public class OrdenesController {
    @Autowired
    OrdenesServiceImp serviceOrden;
    @GetMapping("/ordenes")
    public String obtenerOrdenes(Model model) {
        model.addAttribute("ordenes", serviceOrden.listarOrdenes());
        model.addAttribute("orden", new Ordenes());
        return "ordenes";
    }

    @GetMapping("/agregarOrden")
    public String agregar(Model model) {
        model.addAttribute("employee", new Ordenes());
        return "ordenes";
    }

    @PostMapping("/agregarOrden")
    public String agregarOrden(Ordenes orden) {
        serviceOrden.guardarOrden(orden);
        return "redirect:/ordenes";
    }
    @GetMapping("/editarOrden/{id}")
    public String mostrarFormularioEdicion(@PathVariable Long id, Model model) {
        Optional<Ordenes> optionalOrden = serviceOrden.buscarOrden(id);
        if (optionalOrden.isPresent()) {
            model.addAttribute("orden", optionalOrden.get());
            return "FormOrder";
        } else {
            return "redirect:/ordenes";
        }
    }
    @PostMapping("/editarOrden/{id}")
    public String actualizarOrden(@PathVariable Long id, Ordenes orden) {
        orden.setId(id);
        serviceOrden.guardarOrden(orden);
        return "redirect:/ordenes";
    }
    @GetMapping("/eliminarOrden/{id}")
    public String eliminarOrden(@PathVariable long id, Model model) {
        serviceOrden.eliminarOrden(id);
        return "redirect:/ordenes";
    }
}
