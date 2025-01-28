package io.github.jaoxavier.MATA55.domain.entity;

import io.github.jaoxavier.MATA55.domain.enums.EstadoCivil;
import io.github.jaoxavier.MATA55.rest.dto.PessoaTO;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
@Entity
@DiscriminatorValue("FISICA")
public class Fisica extends Pessoa
{
    @OneToMany(
            mappedBy = "fisica",
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY
    )
    private List<Filiacao> filiacao = new ArrayList<>();

    private String nomeSocial;

    private String cpf;

    @Enumerated(EnumType.STRING)
    private EstadoCivil estadoCivil;

    private LocalDate dataNascimento;

    private String profissao;

    private String escolaridade;

    private double renda;

    private String naturalidade;


    //TODO PREENCHER AS INFORMAÇÕES DE PESSOAS FISICAS COM AS INFORMAÇÕES BÁSICAS
    @Override
    public Fisica criar(PessoaTO dto) {
        return null;
    }

    //TODO VALIDAR SE O CNPJ É VÁLIDO
    @Override
    public String validarDocumento(String CNPJ)
    {
        return CNPJ;
    }
}
