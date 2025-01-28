package io.github.jaoxavier.MATA55.domain.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.github.jaoxavier.MATA55.domain.enums.TipoResponsavel;
import io.github.jaoxavier.MATA55.rest.dto.FiliacaoTO;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class Filiacao
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @ManyToOne
    @JsonIgnore
    private Fisica fisica;

    private String nome;
    private TipoResponsavel tipoResponsavel;

    // TODO PEGAR O MOLDE DE FILIAÇÃO E TRANSFORMAR NA ENTIDADE FILIACAO
    public List<Filiacao> gerarFiliacao(List<FiliacaoTO> dto)
    {
        return null;
    }
}
