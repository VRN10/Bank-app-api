package com.Bank.App.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Bank.App.model.Prestamo;
import com.Bank.App.repository.PrestamosRepositorio;

@RestController
@RequestMapping("/bankapp/v4")
@CrossOrigin(origins = "http://localhost:4200")
public class PrestamoControlador {

	@Autowired
	private PrestamosRepositorio repositorio;
	
	@GetMapping("/prestamos")
	public List<Prestamo> mostrarTodosLosPrestamos() {
		return repositorio.findAll();
	}
}
