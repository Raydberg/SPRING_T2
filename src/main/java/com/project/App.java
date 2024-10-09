package com.project;

import com.project.model.Libros;
import com.project.model.Ordenes;
import com.project.repository.ILibrosRepository;
import com.project.repository.IOrdenesRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.time.LocalDate;
import java.util.List;

@SpringBootApplication
public class App {

	public static void main(String[] args) {
	 ApplicationContext context = SpringApplication.run(App.class, args);
		ILibrosRepository libroRepo = context.getBean(ILibrosRepository.class);
		IOrdenesRepository ordenesRepo = context.getBean(IOrdenesRepository.class);

		List<Libros> libros = List.of(
				new Libros(null,"Titulo1","Autor1","Apellido1","Categoria1",100.0),
				new Libros(null,"Titulo2","Autor2","Apellido2","Categoria2",200.0),
				new Libros(null,"Titulo3","Autor3","Apellido3","Categoria3",300.0),
				new Libros(null,"Titulo4","Autor4","Apellido4","Categoria4",400.0),
				new Libros(null,"Titulo5","Autor5","Apellido5","Categoria5",500.0),
				new Libros(null,"Titulo6","Autor6","Apellido6","Categoria6",600.0)
		);
		libroRepo.saveAll(libros);
		List<Libros> savedLibros = libroRepo.findAll();
		List<Ordenes> ordenes = List.of(
				new Ordenes(null, "Cliente1", savedLibros.get(0), LocalDate.now()),
				new Ordenes(null,"Cliente2",libros.get(1), LocalDate.now()),
				new Ordenes(null,"Cliente3",libros.get(2), LocalDate.now()),
				new Ordenes(null,"Cliente4",libros.get(3), LocalDate.now()),
				new Ordenes(null,"Cliente5",libros.get(4), LocalDate.now())
		);

		ordenesRepo.saveAll(ordenes);






	}

}
