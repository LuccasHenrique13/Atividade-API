package org.example.controller;

import org.example.model.Venda;
import org.example.service.VendaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/vendas")
public class VendaController {

    @Autowired
    private VendaService vendaService;

    @GetMapping
    public List<Venda> findAll(){
        return vendaService.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Venda> findById(@PathVariable Long id){
        return vendaService.findById(id);
    }

    @PostMapping
    public Venda save(@RequestBody Venda venda){
        return vendaService.save(venda);
    }

    @PutMapping("/{id}")
    public Venda update(@PathVariable Long id, @RequestBody Venda venda){
        return vendaService.update(id, venda);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        vendaService.delete(id);
    }
}