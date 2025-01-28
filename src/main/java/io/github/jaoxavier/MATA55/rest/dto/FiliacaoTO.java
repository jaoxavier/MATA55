package io.github.jaoxavier.MATA55.rest.dto;

import io.github.jaoxavier.MATA55.domain.enums.TipoResponsavel;
import lombok.Data;

@Data
public class FiliacaoTO
{
    private String nome;
    private TipoResponsavel tipo;
}
