package io.github.jaoxavier.MATA55.domain.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.github.jaoxavier.MATA55.domain.enums.TipoContato;
import io.github.jaoxavier.MATA55.rest.dto.ContatoTO;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
public class Contato
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @ManyToOne
    @JsonIgnore
    private Pessoa pessoa;
    private TipoContato tipo;
    private String chave;

    //TODO PEGAR O MOLDE DA LISTA DE CONTATO E TRANSFORMAR NA ENTIDADE CONTATO
    public List<Contato> gerarContato(List<ContatoTO> dto)
    {
        return null;
    }
}
