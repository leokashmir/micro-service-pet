package com.petz.api.dto;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @NoArgsConstructor
public class PetDto {

    private Long idPed;
    private String nomePet;
    private String especie;
    private String sexo;

}
