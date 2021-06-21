package com.petz.api.dto;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


import java.util.List;

@Getter @Setter @NoArgsConstructor
public class ClienteRequestSaveDto {


    private String nome;
    private String email;
    private String celular;
    private List<PetDto> listPes;
}
