package tech.pinhos.financas.dto;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public class EnderecoDTO {

    @NotBlank
    @Pattern(regexp = "\\d{8}", message = "O CEP deve possuir apenas 8 digitos.")
    private String cep;

    private String logradouro;

    @NotBlank(message = "É necessário preencher o complemento, como o número da imóvel")
    private String complemento;

    private String bairro;

    private String cidade;

    private String uf;

    public @NotBlank @Pattern(regexp = "\\d{8}", message = "O CEP deve possuir apenas 8 digitos.") String getCep() {
        return cep;
    }

    public void setCep(@NotBlank @Pattern(regexp = "\\d{8}", message = "O CEP deve possuir apenas 8 digitos.") String cep) {
        this.cep = cep;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public @NotBlank(message = "É necessário preencher o complemento, como o número da imóvel") String getComplemento() {
        return complemento;
    }

    public void setComplemento(@NotBlank(message = "É necessário preencher o complemento, como o número da imóvel") String complemento) {
        this.complemento = complemento;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }
}
