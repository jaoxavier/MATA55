package io.github.jaoxavier.MATA55.domain.repository;

import io.github.jaoxavier.MATA55.domain.entity.Municipio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MunicipioRepository extends JpaRepository<Municipio, Integer>
{
    Optional<Municipio> findByUfAndCidade(String uf, String cidade);
}
