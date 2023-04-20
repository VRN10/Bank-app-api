package com.Bank.App.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Bank.App.model.Transferencia;

@Repository
public interface TransferenciasRepositorio extends JpaRepository <Transferencia, Integer>{

}
