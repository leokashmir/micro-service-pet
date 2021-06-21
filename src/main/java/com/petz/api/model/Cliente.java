package com.petz.api.model;


import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;
import javax.persistence.*;
import java.util.List;


@Getter
@Setter
@Builder
@Entity
@Table(name ="tb_cliente")
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Cliente {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cd_cliente")
    private Long idCliente;

    @Column(name = "nm_cliente")
    private String nome;

    @Column(name = "ds_email")
    private String email;

    @Column(name = "ds_celular")
    private String celular;

    @OneToMany (
            cascade  = CascadeType.PERSIST,
            mappedBy="cliente")
    @JsonManagedReference
    private List<Pet> listPes;

}
