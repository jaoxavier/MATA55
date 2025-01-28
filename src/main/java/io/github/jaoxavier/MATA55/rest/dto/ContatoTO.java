package io.github.jaoxavier.MATA55.rest.dto;

import io.github.jaoxavier.MATA55.domain.enums.TipoContato;
import lombok.Data;

@Data
public class ContatoTO
{
    private TipoContato tipo;
    private String chave;
}
