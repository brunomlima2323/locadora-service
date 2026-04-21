package com.bml.locadoraCarros.util;

import com.bml.locadoraCarros.DTO.CarroDTO;
import com.bml.locadoraCarros.entity.Carro;
import com.bml.locadoraCarros.entity.Marca;
import com.bml.locadoraCarros.entity.Proprietario;
import com.bml.locadoraCarros.mapper.CarroMapper;

import java.util.List;

public class CarroTestData {

    private CarroTestData() {}

    public static Marca marcaToyota() {
        return new Marca(1L, "Toyota", "123", null);
    }

    public static Marca marcaJeep() {
        return new Marca(2L, "Jeep", "456", null);
    }

    public static List<Proprietario> proprietarios1() {
        return List.of(
                new Proprietario(1L, "Prop1", 30),
                new Proprietario(2L, "Prop2", 40)
        );
    }

    public static List<Proprietario> proprietarios2() {
        return List.of(
                new Proprietario(3L, "Prop1", 35),
                new Proprietario(4L, "Prop2", 38)
        );
    }

    public static Carro carro1() {
        return new Carro(1L, "Corolla", 2027, marcaToyota(), proprietarios1());
    }

    public static Carro carro2() {
        return new Carro(2L, "Compass", 2025, marcaJeep(), proprietarios2());
    }

    public static Carro carro3() {
        return new Carro(3L, "Renegade", 2026, marcaJeep(), proprietarios2());
    }

    public static List<Carro> listaCarros() {
        return List.of(carro1(), carro2());
    }

    public static List<CarroDTO> listaCarrosDTO() {
        return List.of( CarroMapper.toDTO(carro1()), CarroMapper.toDTO(carro2()) );
    }
}
