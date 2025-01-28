package io.github.jaoxavier.MATA55.rest.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class ComumTO
{
    private String nome;
    private boolean tipoPessoaJuridica; // 0 - PF / 1 - PJ
    private String cpf_cnpj;
    private String nome_social_ou_fantasia;
    private LocalDate data_nascimento_ou_criacao;
}
