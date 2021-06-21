package com.petz.api.model;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;


@Getter
@Setter
@Entity
@Table(name ="tb_pet")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Pet {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cd_pet")
    private Long idPet;

    @Column(name = "nm_pet")
    private String nomePet;

    @Column(name = "ds_especie")
    private String especie;

    @Column(name = "ds_sexo")
    private String sexo;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name="fk_cd_cliente", referencedColumnName="cd_cliente" )
    @JsonBackReference
    private Cliente cliente;
}
