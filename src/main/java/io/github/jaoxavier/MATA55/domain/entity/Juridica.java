package io.github.jaoxavier.MATA55.domain.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import io.github.jaoxavier.MATA55.domain.enums.TipoTributario;
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

}
