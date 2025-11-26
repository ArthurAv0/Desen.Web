package com.example.demo.controller;

import com.example.demo.dto.ContatoDTO;
import com.example.demo.entity.Contato;
import com.example.demo.service.ContatoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("contato")
public class ContatoController {

    @Autowired
    private ContatoService contatoService;

    @GetMapping
    private List<ContatoDTO> buscarContatos() {
        return contatoService.findAllContatos();
    }

    @GetMapping("/{id}")
    private ResponseEntity<ContatoDTO> buscarContatoPorId(@PathVariable Long id) {
        return contatoService.findContatoById(id)
                .map(contato -> new ResponseEntity<>(contato, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    private ContatoDTO criarContato(@RequestBody Contato contato) {
        return contatoService.saveContato(contato);
    }

    @DeleteMapping("/{id}")
    private ResponseEntity<Void> excluirContato(@PathVariable Long id) {
        contatoService.deleteContato(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping("/{id}")
    private ContatoDTO atualizarContato(@PathVariable Long id, @RequestBody Contato contato) {
        return contatoService.updateContato(id, contato);
    }
}
