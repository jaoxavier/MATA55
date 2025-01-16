package io.github.jaoxavier.MATA55.domain.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Endereco // Usei essa API para referencia https://viacep.com.br/ws/41820021/json/
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @ManyToOne // Aqui é gerado a relação entre Municipio e Endereço, dizemos que terão vários (MANY) endereços para (TO) um municipio (ONE), afinal, teração vários endereços com o mesmo municipio
    private Municipio municipio;

    @ManyToOne
    private Pessoa pessoa;

    private String cep;
    private String logradouro;
    private String complemento;
    private String bairro;

    private boolean fiscal;
    private boolean principal;

}
