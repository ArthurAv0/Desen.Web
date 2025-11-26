package com.example.demo.controller;

import com.example.demo.dto.AlimentoDTO;
import com.example.demo.entity.Alimento;
import com.example.demo.service.AlimentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("alimento")
public class AlimentoController {

    @Autowired
    private AlimentoService alimentoService;

    @GetMapping
    private List<AlimentoDTO> buscarAlimentos() {
        return alimentoService.findAllAlimentos();
    }

    @GetMapping("/{id}")
    private ResponseEntity<AlimentoDTO> buscarAlimentoPorId(@PathVariable Long id) {
        return alimentoService.findAlimentoById(id)
                .map(alimento -> new ResponseEntity<>(alimento, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    private AlimentoDTO criarAlimento(@RequestBody Alimento alimento) {
        return alimentoService.saveAlimento(alimento);
    }

    @DeleteMapping("/{id}")
    private ResponseEntity<Void> excluirAlimento(@PathVariable Long id) {
        alimentoService.deleteAlimento(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping("/{id}")
    private AlimentoDTO atualizarAlimento(@PathVariable Long id, @RequestBody Alimento alimento) {
        return alimentoService.updateAlimento(id, alimento);
    }
}
