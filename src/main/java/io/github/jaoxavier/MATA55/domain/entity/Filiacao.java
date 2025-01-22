package io.github.jaoxavier.MATA55.domain.entity;

import io.github.jaoxavier.MATA55.domain.enums.TipoResponsavel;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Filiacao
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String nome;
    private TipoResponsavel tipoResponsavel;
}
