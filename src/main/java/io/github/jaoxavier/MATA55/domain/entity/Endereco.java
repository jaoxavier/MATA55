package io.github.jaoxavier.MATA55.domain.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.github.jaoxavier.MATA55.rest.dto.EnderecoTO;
import io.github.jaoxavier.MATA55.rest.dto.ResponseEnderecoTO;
import io.github.jaoxavier.MATA55.services.EnderecoService;
import jakarta.persistence.*;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;

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
    @JsonIgnore
    private Pessoa pessoa;

    private String cep;
    private String logradouro;
    private String complemento;
    private String bairro;

    private boolean fiscal;
    private boolean principal;

    // TODO BUSCAR INFORMAÇÕES DO ENDEREÇO COM BASE NO CEP NA API DOS CORREIOS
    // "https://viacep.com.br/ws/{CEP}/json"
    public ResponseEnderecoTO buscarPeloCEP(String cep)
    {
        return null;
    }

    // TODO PREENCHER AS INFORMAÇÕES RECEBIDAS E ALIMENTAR OS MUNICIPIOS
    // TODO BUSCAR AS INFORMAÇÕES DO MUNICIPIO NA NOSSA BASE, SE NÃO ENCONTRAR, UTILIZAR
    public Endereco criar(EnderecoTO dto)
    {
        return null;
    }

}
