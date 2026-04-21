package com.bml.locadoraCarros.repository;

import com.bml.locadoraCarros.entity.Proprietario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProprietarioRepository extends JpaRepository<Proprietario, Long> {
}
