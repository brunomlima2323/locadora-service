package com.bml.locadoraCarros.mapper;

import com.bml.locadoraCarros.DTO.MarcaDTO;
import com.bml.locadoraCarros.entity.Marca;

public class MarcaMapper {

    private MarcaMapper() {}

    public static MarcaDTO toDTO(Marca marca) {
        if (marca == null) return null;

        return new MarcaDTO(
                marca.getId(),
                marca.getNome(),
                marca.getCnpj()
        );
    }

    public static Marca toEntity(MarcaDTO dto) {
        if (dto == null) return null;

        Marca marca = new Marca();
        marca.setId(dto.id());
        marca.setNome(dto.nome());
        marca.setCnpj(dto.cnpj());

        return marca;
    }
}
