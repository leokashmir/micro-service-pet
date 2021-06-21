package com.petz.api.dto;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;



@Getter @Setter @NoArgsConstructor
public class ClienteRequestUpdateDto {


    private Long cdCliente;
    private String nome;
    private String email;
    private String celular;




}
