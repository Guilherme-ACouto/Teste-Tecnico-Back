package com.pontta.vendas.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pontta.vendas.domain.Cliente;

@Repository
public interface ClienteRepository extends JpaRepository <Cliente, Long> {
    boolean existsByEmail(String email);
}
