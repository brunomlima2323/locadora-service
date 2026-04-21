package com.bml.locadoraCarros.service;

import com.bml.locadoraCarros.DTO.CarroDTO;
import com.bml.locadoraCarros.entity.Carro;
import com.bml.locadoraCarros.entity.Marca;
import com.bml.locadoraCarros.entity.Proprietario;
import com.bml.locadoraCarros.mapper.CarroMapper;
import com.bml.locadoraCarros.repository.CarroRepository;
import com.bml.locadoraCarros.util.CarroTestData;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class CarroServiceTest {

    @InjectMocks
    private CarroService carroService;

    @Mock
    private CarroRepository carroRepository;

    @Mock
    private MarcaService marcaService;

    @Mock
    private ProprietarioService proprietarioService;

    @Test
    void deveRetornarListaDeCarros() {

        when(carroRepository.findAll())
                .thenReturn(CarroTestData.listaCarros());

        List<CarroDTO> lista = carroService.findAll();

        assertEquals(2, lista.size());
    }

    @Test
    void deveSalvarCarroComSucesso() {

        CarroDTO dto = CarroMapper.toDTO(CarroTestData.carro3());

        Marca marca = CarroTestData.marcaJeep();

        List<Proprietario> proprietarios = CarroTestData.proprietarios2();

        // Mock das dependências
        when(marcaService.verificaMarca(any()))
                .thenReturn(marca);

        when(proprietarioService.verificaProprietario(any()))
                .thenReturn(proprietarios.get(0), proprietarios.get(1));

        when(carroRepository.save(any(Carro.class)))
                .thenAnswer(invocation -> invocation.getArgument(0));

        // Act
        String resultado = carroService.save(dto);

        // Assert
        assertEquals(dto.nome() + " salvo com sucesso!", resultado);

        // Verifica se salvou
        verify(carroRepository).save(any(Carro.class));
    }
}
