package com.Bank.App.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Bank.App.model.Gestor;

@Repository
public interface GestoresRepositorio extends JpaRepository <Gestor, Integer> {

}
