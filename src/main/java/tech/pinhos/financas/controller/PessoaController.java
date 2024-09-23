package tech.pinhos.financas.controller;

import org.springframework.web.bind.annotation.*;
import tech.pinhos.financas.model.Pessoa;
import tech.pinhos.financas.service.BuscarPessoaService;
import tech.pinhos.financas.service.CriarPessoaService;

import java.util.List;

@RestController
@RequestMapping("/api/v1/pessoas")
public class PessoaController {

    private final CriarPessoaService criarPessoaService;
    private final BuscarPessoaService buscarPessoaService;

    public PessoaController(CriarPessoaService criarPessoaService, BuscarPessoaService buscarPessoaService) {
        this.criarPessoaService = criarPessoaService;
        this.buscarPessoaService = buscarPessoaService;
    }

    @GetMapping()
    public List<Pessoa> listar() {
        return buscarPessoaService.buscarTodas();
    }

    @PostMapping()
    public Pessoa criarPessoa(@RequestBody Pessoa pessoa) {
        return criarPessoaService.executar(pessoa);
    }
}
