package org.example.service;

import org.example.model.Venda;
import org.example.repository.VendaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VendaService {

    @Autowired
    private VendaRepository vendaRepository;

    public List<Venda> findAll(){
        return vendaRepository.findAll();
    }

    public Optional<Venda> findById(Long id){
        return vendaRepository.findById(id);
    }

    public Venda save(Venda venda){
        // Regra de negócio: calcular valorTotalVenda
        if(venda.getValorProduto() != null) {
            venda.setValorTotalVenda(venda.getValorProduto() * venda.getQtd());
        }
        return vendaRepository.save(venda);
    }

    public Venda update(Long id, Venda vendaAtualizada){
        Optional<Venda> vendaExistente = vendaRepository.findById(id);
        if (vendaExistente.isPresent()){
            Venda venda = vendaExistente.get();
            venda.setDescricao(vendaAtualizada.getDescricao());
            venda.setDataVenda(vendaAtualizada.getDataVenda());
            venda.setNomeProduto(vendaAtualizada.getNomeProduto());
            venda.setValorProduto(vendaAtualizada.getValorProduto());
            venda.setQtd(vendaAtualizada.getQtd());

            // Regra de negócio: recalcular valorTotalVenda na atualização
            if(venda.getValorProduto() != null) {
                venda.setValorTotalVenda(venda.getValorProduto() * venda.getQtd());
            }

            return vendaRepository.save(venda);
        }
        return null;
    }

    public void delete(Long id){
        vendaRepository.deleteById(id);
    }
}