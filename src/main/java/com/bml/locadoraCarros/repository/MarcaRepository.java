package com.bml.locadoraCarros.repository;

import com.bml.locadoraCarros.entity.Marca;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MarcaRepository extends JpaRepository<Marca, Long> {
}
