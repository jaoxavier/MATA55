package io.github.jaoxavier.MATA55.domain.repository;

import io.github.jaoxavier.MATA55.domain.entity.Endereco;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EnderecoRepository extends JpaRepository<Endereco, Integer> {
}
