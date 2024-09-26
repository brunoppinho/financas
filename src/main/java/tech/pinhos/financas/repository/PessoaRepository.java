package tech.pinhos.financas.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import tech.pinhos.financas.model.Pessoa;

import java.util.List;
import java.util.Optional;

@Repository
public interface PessoaRepository extends JpaRepository<Pessoa, Long> {

    Optional<Pessoa> findPessoaByCpf(String cpf);

    @Query("SELECT p FROM Pessoa p WHERE p.endereco.uf = :uf")
    List<Pessoa> findByUf(String uf);

    @Query(value = "SELECT p.* FROM pessoa p INNER JOIN endereco e ON p.endereco_id = e.id WHERE e.uf = :uf", nativeQuery = true)
    List<Pessoa> findByUfNativa(String uf);
}