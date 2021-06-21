package com.petz.api.repository;

import com.petz.api.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {

    Cliente findByCelular(String celular);

    Cliente findByIdCliente(Long idCliente);

    @Transactional
    void deleteByIdCliente(Long idCliente);
}
