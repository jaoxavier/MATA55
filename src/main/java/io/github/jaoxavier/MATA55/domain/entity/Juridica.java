package io.github.jaoxavier.MATA55.domain.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import io.github.jaoxavier.MATA55.domain.enums.TipoTributario;
import io.github.jaoxavier.MATA55.rest.dto.JuridicaTO;
import io.github.jaoxavier.MATA55.rest.dto.PessoaTO;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


@EqualsAndHashCode(callSuper = true)
@Entity
@Data
@DiscriminatorValue("JURIDICA") // Definimos como pessoa vai entender esse valor
public class Juridica extends Pessoa
{

    @OneToMany(
            mappedBy = "pessoa",
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY
    )
    @JsonManagedReference
    private List<Socios> socios = new ArrayList<>();

    private String nomeFantasia;

    private String cnpj;

    private LocalDate dataAbertura;

    private String cnae; // Área de atuação

    private String inscricaoEstadual;

    private boolean lucrativo;

    @Enumerated(EnumType.STRING)
    private TipoTributario tipoTributario;

    private double faturamento;

    //TODO PREENCHER AS INFORMAÇÕES DE PESSOAS JURIDICAS COM AS INFORMAÇÕES BÁSICAS
    @Override
    public Juridica criar(PessoaTO dto) {
        return null;
    }

    //TODO VALIDAR SE O CNPJ É VÁLIDO
    @Override
    public String validarDocumento(String CNPJ)
    {
        return CNPJ;
    }
}
