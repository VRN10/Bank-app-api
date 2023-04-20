package com.Bank.App.model;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "transferencias")
public class Transferencia {

	@Id
	private int id;
	
	private int id_ordenante;
	private int id_beneficiario;
	private int importe;
	private String concepto;
	private LocalDateTime fecha;
	
	public Transferencia() {
		
	}

	public Transferencia(int id, int id_ordenante, int id_beneficiario, int importe, String concepto, LocalDateTime fecha) {
		super();
		this.id = id;
		this.id_ordenante = id_ordenante;
		this.id_beneficiario = id_beneficiario;
		this.importe = importe;
		this.concepto = concepto;
		this.fecha = fecha;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getId_ordenante() {
		return id_ordenante;
	}

	public void setId_ordenante(int id_ordenante) {
		this.id_ordenante = id_ordenante;
	}

	public int getId_beneficiario() {
		return id_beneficiario;
	}

	public void setId_beneficiario(int id_beneficiario) {
		this.id_beneficiario = id_beneficiario;
	}

	public int getImporte() {
		return importe;
	}

	public void setImporte(int importe) {
		this.importe = importe;
	}

	public String getConcepto() {
		return concepto;
	}

	public void setConcepto(String concepto) {
		this.concepto = concepto;
	}

	public LocalDateTime getFecha() {
		return fecha;
	}

	public void setFecha(LocalDateTime fecha) {
		this.fecha = fecha;
	}
	
}
