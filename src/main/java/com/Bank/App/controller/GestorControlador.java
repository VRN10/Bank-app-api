package com.Bank.App.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Bank.App.exceptions.ResourceNotFoundException;
import com.Bank.App.model.Gestor;
import com.Bank.App.repository.GestoresRepositorio;

@RestController
@RequestMapping("/bankapp/v2")
@CrossOrigin(origins = "http://localhost:4200")
public class GestorControlador {

	@Autowired
	private GestoresRepositorio repositorio;

	@GetMapping("/gestores")
	public List<Gestor> mostrarTodosLosGestores() {
		return repositorio.findAll();
	}

	@PostMapping("/gestores")
	public Gestor guardarGestores(@RequestBody Gestor gestor) {
		return repositorio.save(gestor);
	}

	@GetMapping("/gestores/{id}")
	public ResponseEntity<Gestor> obtenerGestorPorID(@PathVariable int id) {
		Gestor gestor = repositorio.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("No existe el Gestor con ID: " + id));
		return ResponseEntity.ok(gestor);
	}

	@PutMapping("/gestores/{id}")
	public ResponseEntity<Gestor> actualizarGestor(@PathVariable int id, @RequestBody Gestor detallesGestor) {
		Gestor gestor = repositorio.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("No existe el Gestor con ID: " + id));

		gestor.setUsuario(detallesGestor.getUsuario());
		gestor.setPassword(detallesGestor.getPassword());
		gestor.setCorreo(detallesGestor.getCorreo());

		Gestor gestorActualizado = repositorio.save(gestor);
		return ResponseEntity.ok(gestorActualizado);
	}

	@DeleteMapping("/gestores/{id}")
	public ResponseEntity<Map<String, Boolean>> eliminarGestor(@PathVariable int id) {
		Gestor gestor = repositorio.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("No existe el Gestor con ID: " + id));

		repositorio.delete(gestor);
		Map<String, Boolean> respuesta = new HashMap<>();
		respuesta.put("eliminar", Boolean.TRUE);
		return ResponseEntity.ok(respuesta);
	}
}
