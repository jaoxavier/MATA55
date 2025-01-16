package io.github.jaoxavier.MATA55.rest.dto;

import io.github.jaoxavier.MATA55.domain.enums.EstadoCivil;
import io.github.jaoxavier.MATA55.domain.enums.TipoTributario;
import lombok.Data;

import java.time.LocalDate;

@Data
public class PessoaTO // Um clienteTO significa que ele será usado de molde para receber a informação, não sendo necessário seguir regras
{
    private String nome;
    private boolean tipoPessoaJuridica; // 0 - PF / 1 - PJ
    private String cpf_cnpj;
    private String nome_social_ou_fantasia;
    private LocalDate data_nascimento_ou_criacao;

    private EnderecoTO enderecoTO;

    //PF DADOS
    private EstadoCivil estadoCivil;
    private String profissao;
    private String escolaridade;
    private double renda;
    private String mae;
    private String pai;
    private String naturalidade;

    //PJ DADOS
    private String cnae;
    private String inscricao_estadual;
    private boolean lucrativo;
    private TipoTributario tipoTributario;
    private double faturamento;
}
