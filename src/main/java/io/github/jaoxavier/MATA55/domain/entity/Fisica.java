package io.github.jaoxavier.MATA55.domain.entity;

import io.github.jaoxavier.MATA55.domain.enums.EstadoCivil;
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

}
