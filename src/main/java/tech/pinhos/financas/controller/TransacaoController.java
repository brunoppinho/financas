package tech.pinhos.financas.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import tech.pinhos.financas.model.TipoTransacao;
import tech.pinhos.financas.model.Transacao;
import tech.pinhos.financas.repository.TransacaoRepository;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Random;

@RestController
@RequestMapping("api/v1/transacoes")
public class TransacaoController {

    @Autowired
    TransacaoRepository repository;

    @GetMapping("transacao")
    public Transacao obtemTransacao() {
        Transacao transacao = new Transacao();
        transacao.setDescricao("Minha primeira transacao");
        transacao.setValor(BigDecimal.valueOf(new Random().nextInt(100)));
        transacao.setHorario(LocalDateTime.now());
        transacao.setTipo(TipoTransacao.OUTROS);
        return repository.save(transacao);
    }

    @GetMapping()
    public List<Transacao> obtemTransacoes() {
        return repository.findAll();
    }
}
