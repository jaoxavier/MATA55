package io.github.jaoxavier.MATA55.domain.entity;

import io.github.jaoxavier.MATA55.domain.enums.EstadoCivil;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Setter
@Getter
@Entity
@DiscriminatorValue("FISICA")
public class Fisica extends Pessoa
{
    private String nomeSocial;

    private String cpf;

    @Enumerated(EnumType.STRING)
    private EstadoCivil estadoCivil;

    private LocalDate dataNascimento;

    private String profissao;

    private String escolaridade;

    private double renda;

    private String mae;

    private String pai;

    private String naturalidade;

    public String getFiliacao(){
        return "Mãe: " + this.mae + " Pai: " + (this.pai == null ? "Não informado" : this.pai);
    }
}
