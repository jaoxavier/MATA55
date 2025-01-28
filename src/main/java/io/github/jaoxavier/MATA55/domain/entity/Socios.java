package io.github.jaoxavier.MATA55.domain.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import io.github.jaoxavier.MATA55.rest.dto.SociosTO;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class Socios
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @ManyToOne
    private Pessoa pessoa;

    @ManyToOne
    @JsonIgnore
    private Juridica juridica;

    private Double cota;

    // TODO PEGAR A LISTA DE MOLDE DE SOCIOS E TRANSFORMAR NA ENTIDADE
    public List<Socios> gerarSociedade(List<SociosTO> dto)
    {
        return null;
    }
}
