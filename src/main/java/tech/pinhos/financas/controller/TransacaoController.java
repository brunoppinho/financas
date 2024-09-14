package tech.pinhos.financas.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import tech.pinhos.financas.model.Conta;
import tech.pinhos.financas.model.TipoTransacao;
import tech.pinhos.financas.model.Transacao;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;

@Controller
public class TransacaoController {

    @RequestMapping("transacao")
    @ResponseBody
    public Transacao obtemTransacao() {
        Transacao transacao = new Transacao();
        transacao.setDescricao("Minha primeira transacao");
        transacao.setValor(new BigDecimal("100.00"));
        transacao.setHorario(LocalDateTime.now());
        transacao.setTipo(TipoTransacao.OUTROS);
        return transacao;
    }
}
