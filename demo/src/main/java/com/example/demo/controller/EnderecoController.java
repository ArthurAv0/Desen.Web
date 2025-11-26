package com.example.demo.controller;

import com.example.demo.dto.EnderecoDTO;
import com.example.demo.entity.Endereco;
import com.example.demo.service.EnderecoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("endereco")
public class EnderecoController {

    @Autowired
    private EnderecoService enderecoService;

    @GetMapping
    private List<EnderecoDTO> buscarEnderecos() {
        return enderecoService.findAllEnderecos();
    }

    @GetMapping("/{id}")
    private ResponseEntity<EnderecoDTO> buscarEnderecoPorId(@PathVariable Long id) {
        return enderecoService.findEnderecoById(id)
                .map(endereco -> new ResponseEntity<>(endereco, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    private EnderecoDTO criarEndereco(@RequestBody Endereco endereco) {
        return enderecoService.saveEndereco(endereco);
    }

    @DeleteMapping("/{id}")
    private ResponseEntity<Void> excluirEndereco(@PathVariable Long id) {
        enderecoService.deleteEndereco(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping("/{id}")
    private EnderecoDTO atualizarEndereco(@PathVariable Long id, @RequestBody Endereco endereco) {
        return enderecoService.updateEndereco(id, endereco);
    }
}
