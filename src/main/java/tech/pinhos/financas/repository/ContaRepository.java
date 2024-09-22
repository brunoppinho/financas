package tech.pinhos.financas.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tech.pinhos.financas.model.Conta;

@Repository
public interface ContaRepository extends JpaRepository<Conta, Long> {
}
