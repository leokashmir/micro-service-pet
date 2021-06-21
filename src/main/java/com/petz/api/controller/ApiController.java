package com.petz.api.controller;


import com.petz.api.dto.ClienteRequestSaveDto;
import com.petz.api.dto.ClienteRequestUpdateDto;
import com.petz.api.dto.PetDto;
import com.petz.api.exceptions.GenericException;
import com.petz.api.exceptions.UniqueException;
import com.petz.api.model.Cliente;
import com.petz.api.model.Pet;
import com.petz.api.service.ApiService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/v1/api/petz")
public class ApiController {



    private static final String  EXCLUSAO = "Registro excluido com sucesso!";
    private ApiService service;

    @Autowired
    public ApiController(ApiService service) { this.service = service;  }


    @ApiOperation(value = " Obtém a informação de um Cliente e seus Pets, através do número do celular")
    @ApiResponses({
            @ApiResponse(code = 200, message = "Dados do cliente obtida com sucesso.",  responseContainer = "List"),
            @ApiResponse(code = 400, message = "A requisição foi malformada, omitindo atributos obrigatórios, seja no payload ou através de atributos na URL."),
            @ApiResponse(code = 404, message = "O recurso solicitado não existe ou não foi implementado"),
            @ApiResponse(code = 405, message = "Recurso com um método não suportado"),
            @ApiResponse(code = 500, message = "Ocorreu um erro no gateway da API ou no microsserviço")})
    @GetMapping("/search/cliente/{celular}/")
    public ResponseEntity<Cliente> getClientAndPetByCelular(@PathVariable  String celular) throws GenericException {
        return ResponseEntity.ok(service.findByCelular(celular));

    }

    @ApiOperation(value = " Obtém a lista de todos os clientes e seus pets.")
    @ApiResponses({
            @ApiResponse(code = 200, message = "Lista de Clientes obtida com sucesso.",  responseContainer = "List"),
            @ApiResponse(code = 400, message = "A requisição foi malformada, omitindo atributos obrigatórios, seja no payload ou através de atributos na URL."),
            @ApiResponse(code = 404, message = "O recurso solicitado não existe ou não foi implementado"),
            @ApiResponse(code = 405, message = "Recurso com um método não suportado"),
            @ApiResponse(code = 500, message = "Ocorreu um erro no gateway da API ou no microsserviço")})
    @GetMapping("/listar/clientes")
    public ResponseEntity<List<Cliente>> getAllClients() throws GenericException {
           return new ResponseEntity<List<Cliente>>(service.listAllClientes(), HttpStatus.OK);
    }


    @ApiOperation(value = " Obtém a informação de um Cliente e seus Pets, através do IdCliente .")
    @ApiResponses({
            @ApiResponse(code = 200, message = "Lista dos Pets obtida com sucesso.",  responseContainer = "List"),
            @ApiResponse(code = 400, message = "A requisição foi malformada, omitindo atributos obrigatórios, seja no payload ou através de atributos na URL."),
            @ApiResponse(code = 404, message = "O recurso solicitado não existe ou não foi implementado"),
            @ApiResponse(code = 405, message = "Recurso com um método não suportado"),
            @ApiResponse(code = 500, message = "Ocorreu um erro no gateway da API ou no microsserviço")})
    @GetMapping("/listar/{idCliente}/pets")
    public ResponseEntity<Cliente> getClienteAndPetByIdClient( @PathVariable  Long idCliente ) throws GenericException {
        return ResponseEntity.ok(service.findByCdCliente(idCliente));
    }

    @ApiOperation(value = " Cria o Cadastro do Cliente juntamente com seu(s) Pets")
    @ApiResponses({
            @ApiResponse(code = 200, message = "Cadastro realizado com sucesso.",  responseContainer = "List"),
            @ApiResponse(code = 400, message = "A requisição foi malformada, omitindo atributos obrigatórios, seja no payload ou através de atributos na URL."),
            @ApiResponse(code = 404, message = "O recurso solicitado não existe ou não foi implementado"),
            @ApiResponse(code = 405, message = "Recurso com um método não suportado"),
            @ApiResponse(code = 500, message = "Ocorreu um erro no gateway da API ou no microsserviço")})
    @PostMapping("/save")
    @ResponseBody
    public ResponseEntity<Cliente> saveClienteAndPet(@RequestBody ClienteRequestSaveDto cliente) throws UniqueException, GenericException {
        return  ResponseEntity.ok(service.saveClienteAndPet(cliente));
    }

    @ApiOperation(value = " Cria ou Atualiza o cadastro do Pet.")
    @ApiResponses({
            @ApiResponse(code = 200, message = "Cadastro realizado com sucesso.",  responseContainer = "List"),
            @ApiResponse(code = 400, message = "A requisição foi malformada, omitindo atributos obrigatórios, seja no payload ou através de atributos na URL."),
            @ApiResponse(code = 404, message = "O recurso solicitado não existe ou não foi implementado"),
            @ApiResponse(code = 405, message = "Recurso com um método não suportado"),
            @ApiResponse(code = 500, message = "Ocorreu um erro no gateway da API ou no microsserviço")})
    @PostMapping("/save/{idCliente}/pet")
    public ResponseEntity<Pet> savePet(@RequestBody PetDto pet, @PathVariable Long idCliente) throws GenericException {
        return ResponseEntity.ok(service.saveOrUpdatePet(pet, idCliente));
    }

    @ApiOperation(value = " Atualiza o Cadastro do Cliente.")
    @ApiResponses({
            @ApiResponse(code = 200, message = "Atualização realizada com sucesso.",  responseContainer = "List"),
            @ApiResponse(code = 400, message = "A requisição foi malformada, omitindo atributos obrigatórios, seja no payload ou através de atributos na URL."),
            @ApiResponse(code = 404, message = "O recurso solicitado não existe ou não foi implementado"),
            @ApiResponse(code = 405, message = "Recurso com um método não suportado"),
            @ApiResponse(code = 500, message = "Ocorreu um erro no gateway da API ou no microsserviço")})
    @PutMapping("/update/cliente")
    @ResponseBody
    public ResponseEntity<Cliente> updateCliente(@RequestBody ClienteRequestUpdateDto cliente) throws GenericException {
        return   ResponseEntity.ok(service.updateCliente(cliente));
    }

    @ApiOperation(value = " Exclui o Cadastro do Cliente.")
    @ApiResponses({
            @ApiResponse(code = 200, message = "Exclusão feita com sucesso.",  responseContainer = "List"),
            @ApiResponse(code = 400, message = "A requisição foi malformada, omitindo atributos obrigatórios, seja no payload ou através de atributos na URL."),
            @ApiResponse(code = 404, message = "O recurso solicitado não existe ou não foi implementado"),
            @ApiResponse(code = 405, message = "Recurso com um método não suportado"),
            @ApiResponse(code = 500, message = "Ocorreu um erro no gateway da API ou no microsserviço")})
    @DeleteMapping("/delete/cliente/{id}")
    public ResponseEntity<String> deleteCliente(@PathVariable Long id) throws GenericException {
        service.deleteCliente(id);
        return  ResponseEntity.ok(EXCLUSAO);
    }

    @ApiOperation(value = " Exclui  o Cadastro do pet.")
    @ApiResponses({
            @ApiResponse(code = 200, message = "Exclusão feita com sucesso.",  responseContainer = "List"),
            @ApiResponse(code = 400, message = "A requisição foi malformada, omitindo atributos obrigatórios, seja no payload ou através de atributos na URL."),
            @ApiResponse(code = 404, message = "O recurso solicitado não existe ou não foi implementado"),
            @ApiResponse(code = 405, message = "Recurso com um método não suportado"),
            @ApiResponse(code = 500, message = "Ocorreu um erro no gateway da API ou no microsserviço")})
    @DeleteMapping("/delete/pet/{id}")
    public ResponseEntity<String> deletePet(@PathVariable Long id) throws GenericException {
        service.deletePet(id);
        return  ResponseEntity.ok(EXCLUSAO);
    }




}
