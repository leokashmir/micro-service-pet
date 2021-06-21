package com.petz.api.service;

import com.petz.api.dto.ClienteRequestSaveDto;
import com.petz.api.dto.ClienteRequestUpdateDto;
import com.petz.api.dto.PetDto;
import com.petz.api.exceptions.GenericException;
import com.petz.api.exceptions.UniqueException;
import com.petz.api.model.Cliente;
import com.petz.api.model.Pet;
import com.petz.api.repository.ClienteRepository;
import com.petz.api.repository.PetRepository;
import lombok.extern.log4j.Log4j2;
import org.hibernate.exception.ConstraintViolationException;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
@Log4j2
public class ApiServiceImpl implements ApiService {


    private ClienteRepository clienteRepository;
    private PetRepository petRepository;

    private static final Logger LOGGER = LoggerFactory.getLogger(ApiServiceImpl.class);

    @Autowired
    public ApiServiceImpl(ClienteRepository repository, PetRepository petRepository) {
        this.clienteRepository = repository;
        this.petRepository = petRepository;
    }


    @Override
    public List<Cliente> listAllClientes() throws GenericException {
        LOGGER.info("stage=init method=ApiServiceImpl.listAllStores");

        List<Cliente> listreturnClients;
        try {
            listreturnClients = clienteRepository.findAll();
        } catch (Exception e) {
            LOGGER.error("state=erro method=ApiServiceImpl.listAllClientes", e.getStackTrace());
            throw new GenericException("Erro ao listar os clientes.");
        }

        return listreturnClients;
    }

    @Override
    public Cliente findByCelular(String celular) throws GenericException {
        LOGGER.info("stage=init method=ApiServiceImpl.findByCelular");
        Cliente cliente;

        try {
            cliente = clienteRepository.findByCelular(celular);
        } catch (Exception e) {
            LOGGER.error("state=erro method=ApiServiceImpl.findByCelular", e.getStackTrace());
            throw new GenericException("Erro ao tentar localizar o Cliente");
        }

        return cliente;
    }

    @Override
    public Cliente findByCdCliente(Long idCliente) throws GenericException {

        LOGGER.info("stage=init method=ApiServiceImpl.findByCdCliente");
        Cliente cliente;

        try {
            cliente = clienteRepository.findByIdCliente(idCliente);
        } catch (Exception e) {
            LOGGER.error("state=erro method=ApiServiceImpl.findByCdCliente", e.getStackTrace());
            throw new GenericException("Erro ao tentar localizar o Cliente");
        }

        return cliente;
    }

    @Override
    public Cliente saveClienteAndPet(ClienteRequestSaveDto clienteDto) throws UniqueException, GenericException {
        LOGGER.info("stage=init method=ApiServiceImpl.saveClienteAndPet");
        Cliente clienteSaved;

        try {
            ModelMapper modelMapper = new ModelMapper();
            clienteSaved = modelMapper.map(clienteDto, Cliente.class);
            return  clienteRepository.save(clienteSaved);


        } catch (ConstraintViolationException c) {
            LOGGER.error("state=erro method=ApiServiceImpl.saveClienteAndPet", c.getStackTrace());
            throw new UniqueException("Numero do celular do cliente ja esta cadastrado na base de dados");

        } catch (Exception e) {
            throw new GenericException(e.getMessage());
        }


    }

    @Override
    public Cliente updateCliente(ClienteRequestUpdateDto clienteRequestUpdateDto) throws GenericException {

        LOGGER.info("stage=init method=ApiServiceImpl.updateCliente");
        Cliente cliente;

        try {
            ModelMapper modelMapper = new ModelMapper();
            cliente = modelMapper.map(clienteRequestUpdateDto, Cliente.class);
            return  clienteRepository.save(cliente);

        } catch (Exception e) {
            LOGGER.error("state=erro method=ApiServiceImpl.updateCliente", e.getStackTrace());
            throw new GenericException("Erro ao Atualizar o Registro");
        }

    }

    @Override
    public Pet saveOrUpdatePet(PetDto petDto, Long idCliente) throws GenericException {
        LOGGER.info("stage=init method=ApiServiceImpl.saveOrUpdatePet");
        Pet petSaved;
        try {

            ModelMapper modelMapper = new ModelMapper();
            Pet pet = modelMapper.map(petDto, Pet.class);
            Cliente cli = clienteRepository.findByIdCliente(idCliente);
            pet.setCliente(cli);
            petSaved = petRepository.save(pet);


        } catch (Exception e) {
            LOGGER.error("state=erro method=ApiServiceImpl.deletePet", e.getStackTrace());
            throw new GenericException("Erro ao Atualizar o Registro");

        }
        return petSaved;
    }

    public void deleteCliente(Long idCliente) throws GenericException {
        LOGGER.info("stage=init method=ApiServiceImpl.deleteCliente");
        try {
            clienteRepository.deleteByIdCliente(idCliente);
        } catch (Exception e) {
            LOGGER.error("state=erro method=ApiServiceImpl.deleteCliente", e.getStackTrace());
            throw new GenericException("Erro ao Excluir o Registro");
        }

    }

    public void deletePet(Long pet) throws GenericException {
        LOGGER.info("stage=init method=ApiServiceImpl.deletePet");
        try {
            petRepository.deleteByIdPet(pet);
        } catch (Exception e) {
            LOGGER.error("state=erro method=ApiServiceImpl.deletePet", e.getStackTrace());
            throw new GenericException("Erro ao Excluir o Registro");
        }

    }
}
