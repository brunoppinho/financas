package tech.pinhos.financas.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import org.hibernate.validator.constraints.br.CPF;

public class PessoaRequestDTO {

    @Size(min = 3, max = 100, message = "O nome deve ter entre 3 e 100 caracteres")
    @NotBlank(message = "O nome não pode estar em branco.")
    private String nome;

    @CPF
    @Pattern(regexp = "\\d{11}", message = "O CPF deve ter 11 dígitos.")
    private String cpf;

    @NotBlank(message = "O e-mail é obrigatório.")
    @Email(message = "Formato de e-mail inválido.")
    private String email;

    @Pattern(regexp = "\\(\\d{2}\\) \\d{4,5}-\\d{4}", message = "O telefone deve seguir o formato (99) 99999-9999.")
    private String telefone;

    @Valid
    @NotNull(message = "É necessário um endereço com CEP e complemento.")
    private EnderecoRequestDTO endereco;

    public @Size(min = 3, max = 100, message = "O nome deve ter entre 3 e 100 caracteres") @NotBlank(message = "O nome não pode estar em branco.") String getNome() {
        return nome;
    }

    public void setNome(@Size(min = 3, max = 100, message = "O nome deve ter entre 3 e 100 caracteres") @NotBlank(message = "O nome não pode estar em branco.") String nome) {
        this.nome = nome;
    }

    public @CPF @Pattern(regexp = "\\d{11}", message = "O CPF deve ter 11 dígitos.") String getCpf() {
        return cpf;
    }

    public void setCpf(@CPF @Pattern(regexp = "\\d{11}", message = "O CPF deve ter 11 dígitos.") String cpf) {
        this.cpf = cpf;
    }

    public @NotBlank(message = "O e-mail é obrigatório.") @Email(message = "Formato de e-mail inválido.") String getEmail() {
        return email;
    }

    public void setEmail(@NotBlank(message = "O e-mail é obrigatório.") @Email(message = "Formato de e-mail inválido.") String email) {
        this.email = email;
    }

    public @Pattern(regexp = "\\(\\d{2}\\) \\d{4,5}-\\d{4}", message = "O telefone deve seguir o formato (99) 99999-9999.") String getTelefone() {
        return telefone;
    }

    public void setTelefone(@Pattern(regexp = "\\(\\d{2}\\) \\d{4,5}-\\d{4}", message = "O telefone deve seguir o formato (99) 99999-9999.") String telefone) {
        this.telefone = telefone;
    }

    public @Valid @NotNull(message = "É necessário um endereço com CEP e complemento.") EnderecoRequestDTO getEndereco() {
        return endereco;
    }

    public void setEndereco(@Valid @NotNull(message = "É necessário um endereço com CEP e complemento.") EnderecoRequestDTO endereco) {
        this.endereco = endereco;
    }
}
