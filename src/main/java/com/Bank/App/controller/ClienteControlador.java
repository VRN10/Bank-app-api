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
import com.Bank.App.model.Cliente;
import com.Bank.App.repository.ClientesRepositorio;

@RestController
@RequestMapping("/bankapp/v1/")
@CrossOrigin(origins = "http://localhost:4200")
public class ClienteControlador {

	@Autowired
	private ClientesRepositorio repositorio;

	@GetMapping("/clientes")
	public List<Cliente> mostrarTodosLosClientes() {
		return repositorio.findAll();
	}

	@PostMapping("/clientes")
	public Cliente guardarClientes(@RequestBody Cliente cliente) {
		return repositorio.save(cliente);
	}

	@GetMapping("/clientes/{id}")
	public ResponseEntity<Cliente> obtenerClientePorId(@PathVariable int id) {
		Cliente cliente = repositorio.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("No existe el Cliente con ID: " + id));
		return ResponseEntity.ok(cliente);
	}

	@PutMapping("/clientes/{id}")
	public ResponseEntity<Cliente> actualizarCliente(@PathVariable int id, @RequestBody Cliente detallesCliente) {
		Cliente cliente = repositorio.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("No existe el Cliente con ID: " + id));

		cliente.setId_gestor(detallesCliente.getId_gestor());
		cliente.setUsuario(detallesCliente.getUsuario());
		cliente.setPassword(detallesCliente.getPassword());
		cliente.setCorreo(detallesCliente.getCorreo());
		cliente.setSaldo(detallesCliente.getSaldo());

		Cliente clienteActualizado = repositorio.save(cliente);
		return ResponseEntity.ok(clienteActualizado);
	}

	@DeleteMapping("/clientes/{id}")
	public ResponseEntity<Map<String, Boolean>> eliminarCliente(@PathVariable int id) {
		Cliente cliente = repositorio.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("No existe el Cliente con ID: " + id));

		repositorio.delete(cliente);
		Map<String, Boolean> respuesta = new HashMap<>();
		respuesta.put("eliminar", Boolean.TRUE);
		return ResponseEntity.ok(respuesta);
	}

}
