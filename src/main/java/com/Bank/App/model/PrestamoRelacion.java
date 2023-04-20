package com.Bank.App.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "prestamos_relacion")
public class PrestamoRelacion {

	@Id
	private int id_prestamo;
	
	private int id_cliente;	
	
	public PrestamoRelacion() {
		
	}

	public PrestamoRelacion(int id_prestamo, int id_cliente) {
		super();
		this.id_prestamo = id_prestamo;
		this.id_cliente = id_cliente;
	}

	public int getId_prestamo() {
		return id_prestamo;
	}

	public void setId_prestamo(int id_prestamo) {
		this.id_prestamo = id_prestamo;
	}

	public int getId_cliente() {
		return id_cliente;
	}

	public void setId_cliente(int id_cliente) {
		this.id_cliente = id_cliente;
	}
	
}
