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

@Controller
public class OrdenesController {
    @Autowired
    OrdenesServiceImp serviceOrden;
    @GetMapping("/ordenes")
    public String obtenerOrdenes(Model model) {
        model.addAttribute("ordenes", serviceOrden.listarOrdenes());
        return "ordenes";
    }

    @GetMapping("/agregarOrden")
    public String agregar(Model model) {
        model.addAttribute("employee", new Ordenes());
        return "form";
    }
    @GetMapping("/eliminarOrden/{id}")
    public String eliminarOrden(@PathVariable long id, Model model) {
        serviceOrden.eliminarOrden(id);
        return "redirect:/ordenes";
    }
}
