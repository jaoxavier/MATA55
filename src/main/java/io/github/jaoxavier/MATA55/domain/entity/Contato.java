package io.github.jaoxavier.MATA55.domain.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.github.jaoxavier.MATA55.domain.enums.TipoContato;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Contato
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private TipoContato tipo;
    private String chave;
}
