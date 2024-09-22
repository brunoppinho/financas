package tech.pinhos.financas.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tech.pinhos.financas.model.Conta;
import tech.pinhos.financas.model.TipoTransacao;
import tech.pinhos.financas.model.Transacao;
import tech.pinhos.financas.repository.ContaRepository;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Random;

@RestController
@RequestMapping("/api/v1/contas")
public class ContaController {

    @Autowired
    ContaRepository contaRepository;

    // Método 1: Usando @RequestParam para buscar conta pelo ID
    @GetMapping("buscar")
    public Conta getContaByIdRequestParam(@RequestParam Long id) {
        var conta = new Conta();
        conta.setSaldo(BigDecimal.TEN);
        contaRepository.save(conta);
        return contaRepository.findById(id).orElse(null);
    }

    // Método 2: Usando @PathVariable para buscar conta pelo ID
    @GetMapping("/{id}")
    public Conta getContaByIdPathVariable(@PathVariable Long id) {
        Transacao transacao = new Transacao();
        transacao.setDescricao("Minha primeira transacao");
        transacao.setValor(BigDecimal.valueOf(new Random().nextInt(100)));
        transacao.setHorario(LocalDateTime.now());
        transacao.setTipo(TipoTransacao.OUTROS);
        var conta = new Conta();
        conta.setSaldo(BigDecimal.ONE);
        conta.setTransacoes(List.of(transacao));
        contaRepository.save(conta);
        return contaRepository.findById(id).orElse(null);
    }

    @GetMapping()
    public List<Conta> getContas() {
        return contaRepository.findAll();
    }
}
