package org.example.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Venda {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String descricao;
    private String dataVenda;
    private String nomeProduto;
    private Double valorProduto;
    private int qtd;
    private Double valorTotalVenda;

    public Venda() {}

    public Venda(Long id, String descricao, String dataVenda, String nomeProduto, Double valorProduto, int qtd, Double valorTotalVenda) {
        this.id = id;
        this.descricao = descricao;
        this.dataVenda = dataVenda;
        this.nomeProduto = nomeProduto;
        this.valorProduto = valorProduto;
        this.qtd = qtd;
        this.valorTotalVenda = valorTotalVenda;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getDescricao() { return descricao; }
    public void setDescricao(String descricao) { this.descricao = descricao; }

    public String getDataVenda() { return dataVenda; }
    public void setDataVenda(String dataVenda) { this.dataVenda = dataVenda; }

    public String getNomeProduto() { return nomeProduto; }
    public void setNomeProduto(String nomeProduto) { this.nomeProduto = nomeProduto; }

    public Double getValorProduto() { return valorProduto; }
    public void setValorProduto(Double valorProduto) { this.valorProduto = valorProduto; }

    public int getQtd() { return qtd; }
    public void setQtd(int qtd) { this.qtd = qtd; }

    public Double getValorTotalVenda() { return valorTotalVenda; }
    public void setValorTotalVenda(Double valorTotalVenda) { this.valorTotalVenda = valorTotalVenda; }
}