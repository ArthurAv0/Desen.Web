package com.example.demo.controller;

import com.example.demo.dto.PagamentoDTO;
import com.example.demo.entity.Pagamento;
import com.example.demo.service.PagamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("pagamento")
public class PagamentoController {

    @Autowired
    private PagamentoService pagamentoService;

    @GetMapping
    private List<PagamentoDTO> buscarPagamentos() {
        return pagamentoService.findAllPagamentos();
    }

    @GetMapping("/{id}")
    private ResponseEntity<PagamentoDTO> buscarPagamentoPorId(@PathVariable Long id) {
        return pagamentoService.findPagamentoById(id)
                .map(pagamento -> new ResponseEntity<>(pagamento, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    private PagamentoDTO criarPagamento(@RequestBody Pagamento pagamento) {
        return pagamentoService.savePagamento(pagamento);
    }

    @DeleteMapping("/{id}")
    private ResponseEntity<Void> excluirPagamento(@PathVariable Long id) {
        pagamentoService.deletePagamento(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping("/{id}")
    private PagamentoDTO atualizarPagamento(@PathVariable Long id, @RequestBody Pagamento pagamento) {
        return pagamentoService.updatePagamento(id, pagamento);
    }
}
