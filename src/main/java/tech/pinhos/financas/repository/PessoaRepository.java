package tech.pinhos.financas.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tech.pinhos.financas.model.Pessoa;

public interface PessoaRepository extends JpaRepository<Pessoa, Long> {
}