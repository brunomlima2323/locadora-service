package com.bml.locadoraCarros.controller;

import com.bml.locadoraCarros.DTO.CarroDTO;
import com.bml.locadoraCarros.service.CarroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/carro")
public class CarroController {

    @Autowired
    private CarroService carroService;

    @PostMapping("/save")
    public ResponseEntity<String> save(@RequestBody CarroDTO carroDTO) {
        try {
            String mensagem = this.carroService.save(carroDTO);
            return new ResponseEntity<>(mensagem,HttpStatus.CREATED);
        } catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(e.getMessage());
        }
    }

    @PatchMapping("/update/{id}")
    public ResponseEntity<String> update(@RequestBody CarroDTO carroDTO, @PathVariable Long id) {
        try {
            String mensagem = this.carroService.update(carroDTO, id);
            return new ResponseEntity<>(mensagem,HttpStatus.OK);
        } catch (Exception e) {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(e.getMessage());
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id) {
        try {
            String mensagem = this.carroService.delete(id);
            return new ResponseEntity<>(mensagem,HttpStatus.OK);
        } catch (Exception e) {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(e.getMessage());
        }
    }

    @GetMapping("/findAll")
    public ResponseEntity< List<CarroDTO> > findAll() {
        try {
            List<CarroDTO> lista = this.carroService.findAll();
            return new ResponseEntity<>(lista,HttpStatus.OK);
        } catch (Exception e) {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(null);
        }
    }

    @GetMapping("/findById/{id}")
    public ResponseEntity<CarroDTO> findById(@PathVariable Long id) {
        try {
            CarroDTO carroDTO = this.carroService.findById(id);
            return new ResponseEntity<>(carroDTO,HttpStatus.OK);
        } catch (Exception e) {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(null);
        }
    }

    @GetMapping("/findByNome")
    public ResponseEntity< List<CarroDTO>> findByNome(@RequestParam String nome) {
        try {
            List<CarroDTO> lista = this.carroService.findByNome(nome);
            return new ResponseEntity<>(lista,HttpStatus.OK);
        } catch (Exception e) {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(null);
        }
    }

    @GetMapping("/findByMarca")
    public ResponseEntity< List<CarroDTO> > findByMarca(@RequestParam int idMarca) {
        try {
            List<CarroDTO> lista = this.carroService.findByMarca(idMarca);
            return new ResponseEntity<>(lista,HttpStatus.OK);
        } catch (Exception e) {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(null);
        }
    }

    @GetMapping("/findAcimaAno")
    public ResponseEntity< List<CarroDTO> > findAcimaAno(@RequestParam int ano) {
        try {
            List<CarroDTO> lista = this.carroService.findAcimaAno(ano);
            return new ResponseEntity<>(lista,HttpStatus.OK);
        } catch (Exception e) {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(null);
        }
    }
}
