package io.github.jaoxavier.MATA55.rest.dto;

import io.github.jaoxavier.MATA55.domain.enums.TipoTributario;
import lombok.Data;

@Data
public class JuridicaTO
{
    //PJ DADOS
    private String cnae;
    private String inscricao_estadual;
    private boolean lucrativo;
    private TipoTributario tipoTributario;
    private double faturamento;
}
