package tech.pinhos.financas.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tech.pinhos.financas.model.Transacao;

@Repository
public interface TransacaoRepository extends JpaRepository<Transacao, Long> {
}
