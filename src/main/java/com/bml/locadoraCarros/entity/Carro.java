package com.bml.locadoraCarros.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Carro {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Nome é obrigatório")
    private String nome;

    @NotNull(message = "Ano é obrigatório")
    private Integer ano;

    @ManyToOne
    @JsonIgnoreProperties("carros")
    @NotNull(message = "Marca é obrigatório")
    private Marca marca;

    @ManyToMany
    @JoinTable(name = "carro_proprietario")
    private List<Proprietario> proprietarios;
}
