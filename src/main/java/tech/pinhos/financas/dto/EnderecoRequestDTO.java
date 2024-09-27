package tech.pinhos.financas.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public class EnderecoRequestDTO {

    @NotBlank
    @Pattern(regexp = "\\d{8}", message = "O CEP deve possuir apenas 8 digitos.")
    private String cep;

    @NotBlank(message = "É necessário preencher o complemento, como o número da imóvel")
    private String complemento;

    public @NotBlank @Pattern(regexp = "\\d{8}", message = "O CEP deve possuir apenas 8 digitos.") String getCep() {
        return cep;
    }

    public void setCep(@NotBlank @Pattern(regexp = "\\d{8}", message = "O CEP deve possuir apenas 8 digitos.") String cep) {
        this.cep = cep;
    }

    public @NotBlank(message = "É necessário preencher o complemento, como o número da imóvel") String getComplemento() {
        return complemento;
    }

    public void setComplemento(@NotBlank(message = "É necessário preencher o complemento, como o número da imóvel") String complemento) {
        this.complemento = complemento;
    }
}
