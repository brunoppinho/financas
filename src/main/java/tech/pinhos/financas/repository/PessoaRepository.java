package tech.pinhos.financas.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tech.pinhos.financas.model.Pessoa;

import java.util.Optional;

public interface PessoaRepository extends JpaRepository<Pessoa, Long> {

    Optional<Pessoa> findPessoaByCpf(String cpf);
}