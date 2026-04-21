package com.bml.locadoraCarros.DTO;

import java.util.List;

public record CarroDTO(Long id, String nome, Integer ano, MarcaDTO marca, List<ProprietarioDTO> proprietarios) {
}
