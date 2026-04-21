package com.bml.locadoraCarros.service;

import com.bml.locadoraCarros.DTO.CarroDTO;
import com.bml.locadoraCarros.entity.Carro;
import com.bml.locadoraCarros.entity.Marca;
import com.bml.locadoraCarros.entity.Proprietario;
import com.bml.locadoraCarros.mapper.CarroMapper;
import com.bml.locadoraCarros.repository.CarroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CarroService {

    @Autowired
    private CarroRepository carroRepository;

    @Autowired
    private ProprietarioService proprietarioService;

    @Autowired
    private MarcaService marcaService;

    @Transactional
    public String save(CarroDTO dto) {
        System.out.println(dto);

        Marca marca = this.marcaService.verificaMarca(dto.marca());

        List<Proprietario> proprietarios = dto.proprietarios()
                .stream()
                .map(proprietarioService::verificaProprietario)
                .toList();

        Carro carro = new Carro(null,dto.nome(),dto.ano(),marca,proprietarios);
        this.carroRepository.save(carro);
        return carro.getNome() + " salvo com sucesso!";
    }

    public String update(CarroDTO dto, Long id) {

        Carro carro = carroRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Carro não encontrado"));

        if(dto.nome() != null){
            carro.setNome(dto.nome());
        }

        if(dto.ano() != null){
            carro.setAno(dto.ano());
        }

        if(dto.marca() != null){
            Marca marca = this.marcaService.verificaMarca(dto.marca());
            carro.setMarca(marca);
        }

        if( dto.proprietarios() != null && !dto.proprietarios().isEmpty() ){
            List<Proprietario> proprietarios = dto.proprietarios()
                    .stream()
                    .map(proprietarioService::verificaProprietario)
                    .collect(Collectors.toList());

            carro.setProprietarios(proprietarios);
        }

        this.carroRepository.save(carro);
        return carro.getNome() + " foi atualizado com sucesso!";
    }

    public String delete(Long id) {
        this.carroRepository.deleteById(id);
        return "Carro foi deletado com sucesso!";
    }

    public List<CarroDTO> findAll() {
        List<Carro> carros = this.carroRepository.findAll();
        return carros.stream().map(CarroMapper::toDTO).toList();
    }

    public CarroDTO findById(Long id) {
        Carro carro = this.carroRepository.findById(id).orElseThrow(() -> new RuntimeException("Carro não encontrado"));
        return CarroMapper.toDTO(carro);
    }

    public List<CarroDTO> findByNome (String nome){
        List<Carro> carros = this.carroRepository.findByNome(nome);
        return carros.stream().map(CarroMapper::toDTO).toList();
    }

    public List<CarroDTO> findByMarca (long idMarca){
        Marca marca = new Marca();
        marca.setId(idMarca);
        List<Carro> carros = this.carroRepository.findByMarca(marca);
        return carros.stream().map(CarroMapper::toDTO).toList();
    }

    public List<CarroDTO> findAcimaAno (int ano){
        List<Carro> carros = this.carroRepository.findAcimaAno(ano);
        return carros.stream().map(CarroMapper::toDTO).toList();
    }
}
