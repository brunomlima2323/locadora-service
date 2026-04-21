package com.bml.locadoraCarros.controller;

import com.bml.locadoraCarros.DTO.CarroDTO;
import com.bml.locadoraCarros.service.CarroService;
import com.bml.locadoraCarros.util.CarroTestData;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class CarroControllerTest {

    @InjectMocks
    private CarroController carroController;

    @Mock
    private CarroService carroService;

    @BeforeEach void setup() {
        when(carroService.findAll())
                .thenReturn(CarroTestData.listaCarrosDTO());
    }

    @Test
    void cenario01() {

        ResponseEntity<List<CarroDTO>> retorno = carroController.findAll();

        assertEquals(HttpStatus.OK, retorno.getStatusCode());
        assertNotNull(retorno.getBody());
        assertEquals(2, retorno.getBody().size());
    }
}
