package tech.pinhos.financas.model;

import java.math.BigDecimal;
import java.util.List;

public class Conta {

    private BigDecimal saldo;
    private List<Transacao> transacoes;

    public BigDecimal getSaldo() {
        return saldo;
    }

    public void setSaldo(BigDecimal saldo) {
        this.saldo = saldo;
    }

    public List<Transacao> getTransacoes() {
        return transacoes;
    }

    public void setTransacoes(List<Transacao> transacoes) {
        this.transacoes = transacoes;
    }
}
