package com.Bank.App.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Bank.App.model.Prestamo;

@Repository
public interface PrestamosRepositorio extends JpaRepository <Prestamo, Integer>{

}
