package com.bml.locadoraCarros.service;

import com.bml.locadoraCarros.DTO.MarcaDTO;
import com.bml.locadoraCarros.entity.Marca;
import com.bml.locadoraCarros.repository.MarcaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MarcaService {

    @Autowired
    private MarcaRepository marcaRepository;

    public Marca verificaMarca(MarcaDTO marcaDTO) {

        if (marcaDTO == null) {
            throw new RuntimeException("Marca é obrigatória");
        }

        Marca marca;

        if (marcaDTO.id() != null) {
            marca = marcaRepository.findById(marcaDTO.id())
                    .orElseThrow(() -> new RuntimeException("Marca não encontrada"));
        } else {
            if (marcaDTO.nome() == null || marcaDTO.cnpj() == null) {
                throw new RuntimeException("Dados da marca incompletos");
            }

            marca = new Marca();
            marca.setNome(marcaDTO.nome());
            marca.setCnpj(marcaDTO.cnpj());

            marca = marcaRepository.save(marca);
        }
        return marca;
    }
}
