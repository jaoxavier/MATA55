package io.github.jaoxavier.MATA55.rest.dto;

import io.github.jaoxavier.MATA55.domain.enums.EstadoCivil;
import lombok.Data;

@Data
public class FisicaTO
{
    //PF DADOS
    private EstadoCivil estadoCivil;
    private String profissao;
    private String escolaridade;
    private double renda;
    private String mae;
    private String pai;
    private String naturalidade;
}
