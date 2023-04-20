package com.Bank.App.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Bank.App.model.Mensaje;

@Repository
public interface MensajesRepositorio extends JpaRepository<Mensaje, Integer> {

	
}
