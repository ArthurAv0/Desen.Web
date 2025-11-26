package com.example.demo.controller;

import com.example.demo.dto.PedidoDTO;
import com.example.demo.entity.Pedido;
import com.example.demo.service.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("pedido")
public class PedidoController {

    @Autowired
    private PedidoService pedidoService;

    @GetMapping
    private List<PedidoDTO> buscarPedidos() {
        return pedidoService.findAllPedidos();
    }

    @GetMapping("/{id}")
    private ResponseEntity<PedidoDTO> buscarPedidoPorId(@PathVariable Long id) {
        return pedidoService.findPedidoById(id)
                .map(pedido -> new ResponseEntity<>(pedido, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    private PedidoDTO criarPedido(@RequestBody Pedido pedido) {
        return pedidoService.savePedido(pedido);
    }

    @DeleteMapping("/{id}")
    private ResponseEntity<Void> excluirPedido(@PathVariable Long id) {
        pedidoService.deletePedido(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping("/{id}")
    private PedidoDTO atualizarPedido(@PathVariable Long id, @RequestBody Pedido pedido) {
        return pedidoService.updatePedido(id, pedido);
    }
}
