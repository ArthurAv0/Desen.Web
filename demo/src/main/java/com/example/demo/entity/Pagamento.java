package com.example.demo.entity;

import jakarta.persistence.*;
import java.util.Date;

@Entity
public class Pagamento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String metodo; // exemplo: PIX, Cartão, Dinheiro
    private Date dataPagamento;
    private String status; // Pendente ou Aprovado

    @OneToOne
    @JoinColumn(name = "pedido_id")
    private Pedido pedido;

    public Pagamento() {
    }

    public Pagamento(Long id, Double valor, String metodo, Date dataPagamento, Pedido pedido) {
        this.id = id;
        this.valor = valor;
        this.metodo = metodo;
        this.dataPagamento = dataPagamento;
        this.pedido = pedido;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public String getMetodo() {
        return metodo;
    }

    public void setMetodo(String metodo) {
        this.metodo = metodo;
    }

    public Date getDataPagamento() {
        return dataPagamento;
    }

    public void setDataPagamento(Date dataPagamento) {
        this.dataPagamento = dataPagamento;
    }

    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }
}
