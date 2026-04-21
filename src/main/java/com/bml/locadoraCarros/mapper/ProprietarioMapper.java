package com.bml.locadoraCarros.mapper;

import com.bml.locadoraCarros.DTO.ProprietarioDTO;
import com.bml.locadoraCarros.entity.Proprietario;

public class ProprietarioMapper {

    private ProprietarioMapper() {}

    public static ProprietarioDTO toDTO(Proprietario prop) {
        if (prop == null) return null;

        return new ProprietarioDTO(
                prop.getId(),
                prop.getNome(),
                prop.getIdade()
        );
    }

    public static Proprietario toEntity(ProprietarioDTO dto) {
        if (dto == null) return null;

        Proprietario prop = new Proprietario();
        prop.setId(dto.id());
        prop.setNome(dto.nome());
        prop.setIdade(dto.idade());

        return prop;
    }
}
