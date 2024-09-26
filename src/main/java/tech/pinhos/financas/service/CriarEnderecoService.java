package tech.pinhos.financas.service;

import org.springframework.stereotype.Service;
import tech.pinhos.financas.dto.CepDTO;
import tech.pinhos.financas.dto.EnderecoDTO;
import tech.pinhos.financas.gateway.CepGateway;
import tech.pinhos.financas.model.Endereco;
import tech.pinhos.financas.repository.EnderecoRepository;

@Service
public class CriarEnderecoService {

    private final EnderecoRepository enderecoRepository;
    private final CepGateway cepGateway;

    public CriarEnderecoService(EnderecoRepository enderecoRepository, CepGateway cepGateway) {
        this.enderecoRepository = enderecoRepository;
        this.cepGateway = cepGateway;
    }

    public Endereco executar(EnderecoDTO endereco) {
        Endereco end = preencheDadosViaCep(endereco.getCep());
        end.setComplemento(endereco.getComplemento());

        return enderecoRepository.save(end);
    }

    private Endereco preencheDadosViaCep(String cep) {
        CepDTO cepDTO = cepGateway.obterEnderecoPorCep(cep);
        Endereco end = new Endereco();
        end.setCep(cep);
        end.setLogradouro(cepDTO.getLogradouro());
        end.setBairro(cepDTO.getBairro());
        end.setCidade(cepDTO.getLocalidade());
        end.setUf(cepDTO.getUf());
        return end;
    }
}
