package com.example.demo.entity;

import jakarta.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Date dataPedido;
    private Double valorTotal;
    private String status; // Ex.: "PENDENTE", "PAGO", "CANCELADO"

    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;

    @OneToOne(mappedBy = "pedido", cascade = CascadeType.ALL)
    private Pagamento pagamento;

    @ManyToMany
    @JoinTable(
            name = "pedido_alimento", // tirar isso para adicionar classe "PedidoItem"
            joinColumns = @JoinColumn(name = "pedido_id"),
            inverseJoinColumns = @JoinColumn(name = "alimento_id")
    )
    private List<Alimento> alimentos;

    public Pedido() {
    }

    public Pedido(Long id, Date dataPedido, Double valorTotal, String status, Aluno aluno) {
        this.id = id;
        this.dataPedido = dataPedido;
        this.valorTotal = valorTotal;
        this.status = status;
        this.aluno = aluno;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id
