package com.bml.locadoraCarros.mapper;

import com.bml.locadoraCarros.DTO.CarroDTO;
import com.bml.locadoraCarros.entity.Carro;

import java.util.List;

public class CarroMapper {

    private CarroMapper() {
        // evita instanciar (classe utilitária)
    }

    public static CarroDTO toDTO(Carro carro) {
        if (carro == null) return null;

        return new CarroDTO(
                carro.getId(),
                carro.getNome(),
                carro.getAno(),
                MarcaMapper.toDTO(carro.getMarca()),
                carro.getProprietarios()
                        .stream()
                        .map(ProprietarioMapper::toDTO)
                        .toList()
        );
    }

    public static Carro toEntity(CarroDTO dto) {
        if (dto == null) return null;

        Carro carro = new Carro();
        carro.setId(dto.id());
        carro.setNome(dto.nome());
        carro.setAno(dto.ano());
        carro.setMarca(MarcaMapper.toEntity(dto.marca()));

        carro.setProprietarios(
                dto.proprietarios() == null
                        ? List.of()
                        : dto.proprietarios()
                        .stream()
                        .map(ProprietarioMapper::toEntity)
                        .toList()
        );

        return carro;
    }
}
