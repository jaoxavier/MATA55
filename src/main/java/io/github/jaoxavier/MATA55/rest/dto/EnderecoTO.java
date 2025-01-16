package io.github.jaoxavier.MATA55.rest.dto;

import lombok.Data;

@Data
public class EnderecoTO
{
    private String cidade;
    private String uf;

    private String cep;
    private String logradouro;
    private String complemento;
    private String bairro;

    private boolean fiscal;
    private boolean principal;
}
