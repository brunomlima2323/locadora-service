package com.bml.locadoraCarros.repository;

import com.bml.locadoraCarros.entity.Carro;
import com.bml.locadoraCarros.entity.Marca;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CarroRepository extends JpaRepository<Carro, Long> {

    List<Carro> findByNome(String nome);

    List<Carro> findByMarca(Marca marca);

    @Query("SELECT c FROM Carro c WHERE c.ano > :ano")
    List<Carro> findAcimaAno(Integer ano);

}
