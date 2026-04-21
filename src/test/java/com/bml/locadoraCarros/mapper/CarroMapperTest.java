package com.bml.locadoraCarros.mapper;

import com.bml.locadoraCarros.DTO.CarroDTO;
import com.bml.locadoraCarros.entity.Carro;
import com.bml.locadoraCarros.util.CarroTestData;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
public class CarroMapperTest {

    @Test
    void deveConverterEntityParaDTO() {

        Carro carro = CarroTestData.carro3();

        CarroDTO dto = CarroMapper.toDTO(carro);

        assertAll(
            () -> assertEquals(carro.getId(), dto.id()),
            () -> assertEquals(carro.getNome(), dto.nome()),
            () -> assertEquals(carro.getAno(), dto.ano()),
            () -> assertEquals(carro.getMarca().getId(), dto.marca().id()),
            () -> assertEquals(carro.getMarca().getNome(), dto.marca().nome()),
            () -> assertEquals(carro.getMarca().getCnpj(), dto.marca().cnpj()),
            () -> assertEquals(2, dto.proprietarios().size()),
            () -> assertEquals(carro.getProprietarios().get(0).getNome(), dto.proprietarios().get(0).nome()),
            () -> assertEquals(carro.getProprietarios().get(0).getIdade(), dto.proprietarios().get(0).idade())
        );
    }

}
