package com.Bank.App.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "prestamos")
public class Prestamo {

	@Id
	private int id;
	
	private String nombre;
	private Double comision;
	private int meses;
	
	public Prestamo() {
		
	}

	public Prestamo(int id, String nombre, Double comision, int meses) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.comision = comision;
		this.meses = meses;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Double getComision() {
		return comision;
	}

	public void setComision(Double comision) {
		this.comision = comision;
	}

	public int getMeses() {
		return meses;
	}

	public void setMeses(int meses) {
		this.meses = meses;
	}
	
}
