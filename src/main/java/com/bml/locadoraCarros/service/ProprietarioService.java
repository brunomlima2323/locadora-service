package com.bml.locadoraCarros.service;

import com.bml.locadoraCarros.DTO.ProprietarioDTO;
import com.bml.locadoraCarros.entity.Proprietario;
import com.bml.locadoraCarros.repository.ProprietarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProprietarioService {

    @Autowired
    ProprietarioRepository proprietarioRepository;

    public Proprietario verificaProprietario(ProprietarioDTO dto) {
        if (dto.id() != null) {
            return proprietarioRepository.findById(dto.id())
                    .orElseThrow(() -> new RuntimeException("Proprietario não encontrado"));
        }

        if (dto.nome() == null || dto.idade() == null) {
            throw new RuntimeException("Dados do proprietário incompletos");
        }

        Proprietario p = new Proprietario();
        p.setNome(dto.nome());
        p.setIdade(dto.idade());
        p = proprietarioRepository.save(p);
        return p;
    }
}
