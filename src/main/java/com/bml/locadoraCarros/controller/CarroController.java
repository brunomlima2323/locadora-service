package com.bml.locadoraCarros.controller;

import com.bml.locadoraCarros.entity.Carro;
import com.bml.locadoraCarros.service.CarroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/carro")
public class CarroController {

    @Autowired
    private CarroService carroService;

    @PostMapping("/save")
    public ResponseEntity<String> save(@RequestBody Carro carro) {
        System.out.println(carro.toString());
        try {
            String mensagem = this.carroService.save(carro);
            return new ResponseEntity<String>(mensagem,HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null,HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<String> update(@RequestBody Carro carro, @PathVariable Long id) {
        try {
            String mensagem = this.carroService.update(carro, id);
            return new ResponseEntity<String>(mensagem,HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null,HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id) {
        try {
            String mensagem = this.carroService.delete(id);
            return new ResponseEntity<String>(mensagem,HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null,HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/findAll")
    public ResponseEntity< List<Carro> > findAll() {
        try {
            List<Carro> lista = this.carroService.findAll();
            return new ResponseEntity<List<Carro>>(lista,HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null,HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/findById/{id}")
    public ResponseEntity<Carro> findById(@PathVariable Long id) {
        try {
            Carro carro = this.carroService.findById(id);
            return new ResponseEntity<Carro>(carro,HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null,HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/findByNome")
    public ResponseEntity< List<Carro> > findByNome(@RequestParam String nome) {
        try {
            List<Carro> lista = this.carroService.findByNome(nome);
            return new ResponseEntity<List<Carro>>(lista,HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null,HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/findByMarca")
    public ResponseEntity< List<Carro> > findByMarca(@RequestParam int idMarca) {
        try {
            List<Carro> lista = this.carroService.findByMarca(idMarca);
            return new ResponseEntity<List<Carro>>(lista,HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null,HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/findAcimaAno")
    public ResponseEntity< List<Carro> > findAcimaAno(@RequestParam int ano) {
        try {
            List<Carro> lista = this.carroService.findAcimaAno(ano);
            return new ResponseEntity<List<Carro>>(lista,HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null,HttpStatus.BAD_REQUEST);
        }
    }
}
