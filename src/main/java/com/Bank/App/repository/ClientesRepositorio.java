package com.Bank.App.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Bank.App.model.Cliente;

@Repository
public interface ClientesRepositorio extends JpaRepository <Cliente, Integer> {

}
