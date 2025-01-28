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

    public void setCpf(String cpf) {
        if (!validarCPF(cpf)) {
            throw new IllegalArgumentException("CPF inválido: " + cpf);
        }
        this.cpf = cpf;
    }

    private boolean validarCPF(String cpf) {
        if (cpf == null) {
            return false;
        }

        cpf = cpf.replaceAll("[^\\d]", "");

        if (cpf.length() != 11) {
            return false;
        }

        if (cpf.matches("(\\d)\\1{10}")) {
            return false;
        }

        try {
            int sum = 0;
            for (int i = 0; i < 9; i++) {
                sum += Character.getNumericValue(cpf.charAt(i)) * (10 - i);
            }
            int firstCheckDigit = (sum * 10) % 11;
            if (firstCheckDigit == 10) {
                firstCheckDigit = 0;
            }

            if (firstCheckDigit != Character.getNumericValue(cpf.charAt(9))) {
                return false;
            }

            sum = 0;
            for (int i = 0; i < 10; i++) {
                sum += Character.getNumericValue(cpf.charAt(i)) * (11 - i);
            }
            int secondCheckDigit = (sum * 10) % 11;
            if (secondCheckDigit == 10) {
                secondCheckDigit = 0;
            }


            return secondCheckDigit == Character.getNumericValue(cpf.charAt(10));
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
