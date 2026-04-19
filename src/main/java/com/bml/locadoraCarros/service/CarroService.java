package com.bml.locadoraCarros.service;

import com.bml.locadoraCarros.entity.Carro;
import com.bml.locadoraCarros.entity.Marca;
import com.bml.locadoraCarros.repository.CarroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CarroService {

    @Autowired
    private CarroRepository carroRepository;

    public String save(Carro carro) {
        this.carroRepository.save(carro);
        return carro.getNome() + " salvo com sucesso!";
    }

    public String update(Carro carro, Long id) {
        carro.setId(id);
        this.carroRepository.save(carro);
        return carro.getNome() + " foi atualizado com sucesso!";
    }

    public String delete(Long id) {
        this.carroRepository.deleteById(id);
        return "Carro foi deletado com sucesso!";
    }

    public List<Carro> findAll() {
        List<Carro> lista = this.carroRepository.findAll();
        return lista;
    }

    public Carro findById(Long id) {
        Carro carro = this.carroRepository.findById(id).get();
        return carro;
    }

    public List<Carro> findByNome (String nome){
       return this.carroRepository.findByNome(nome);
    }

    public List<Carro> findByMarca (long idMarca){
        Marca marca = new Marca();
        marca.setId(idMarca);
        return this.carroRepository.findByMarca(marca);
    }

    public List<Carro> findAcimaAno (int ano){
        return this.carroRepository.findAcimaAno(ano);
    }
}
