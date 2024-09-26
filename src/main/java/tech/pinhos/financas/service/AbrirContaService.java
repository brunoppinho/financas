package tech.pinhos.financas.service;

import org.springframework.stereotype.Service;
import tech.pinhos.financas.dto.PessoaDTO;
import tech.pinhos.financas.model.Conta;
import tech.pinhos.financas.model.Pessoa;
import tech.pinhos.financas.repository.ContaRepository;

import java.math.BigDecimal;
import java.util.Collections;

@Service
public class AbrirContaService {

    private final ContaRepository contaRepository;
    private final BuscarPessoaService buscarPessoaService;

    public AbrirContaService(ContaRepository contaRepository, BuscarPessoaService buscarPessoaService) {
        this.contaRepository = contaRepository;
        this.buscarPessoaService = buscarPessoaService;
    }

    public Conta executar(String cpf) {
        Conta conta = new Conta();
        conta.setSaldo(BigDecimal.ZERO);
        conta.setTransacoes(Collections.emptyList());
        Pessoa titular = buscarPessoaService.buscarPessoaPorCpf(cpf).map(PessoaDTO::toEntity).orElseThrow();
        conta.setTitular(titular);
        return contaRepository.save(conta);
    }
}
