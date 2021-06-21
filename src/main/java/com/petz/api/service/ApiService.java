package com.petz.api.service;

import com.petz.api.dto.ClienteRequestSaveDto;
import com.petz.api.dto.ClienteRequestUpdateDto;
import com.petz.api.dto.PetDto;
import com.petz.api.exceptions.GenericException;
import com.petz.api.exceptions.UniqueException;
import com.petz.api.model.Cliente;
import com.petz.api.model.Pet;

import java.util.List;

public interface ApiService {

    List<Cliente> listAllClientes() throws GenericException;

    Cliente findByCelular(String celular) throws GenericException;

    Cliente findByCdCliente(Long idCliente) throws GenericException;

    Cliente saveClienteAndPet(ClienteRequestSaveDto cliente) throws UniqueException, GenericException;

    Cliente updateCliente(ClienteRequestUpdateDto cliente) throws GenericException;

    Pet saveOrUpdatePet(PetDto pet, Long idCliente) throws GenericException;

    void deleteCliente(Long idCliente) throws GenericException;

    void deletePet(Long idPet) throws GenericException;
}
