package tech.pinhos.financas.gateway;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import tech.pinhos.financas.dto.CepDTO;

@Service
public class CepGateway {

    private static final String VIA_CEP_URL = "https://viacep.com.br/ws/{cep}/json/";

    public CepDTO obterEnderecoPorCep(String cep) {
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForObject(VIA_CEP_URL, CepDTO.class, cep);
    }

}
