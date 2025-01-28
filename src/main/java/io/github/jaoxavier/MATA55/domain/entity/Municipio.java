package io.github.jaoxavier.MATA55.domain.entity;

import io.github.jaoxavier.MATA55.rest.dto.ResponseMunicipioTO;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Municipio
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String cidade;
    private String uf;
    private String estado;
    private String regiao;
    private String ddd;

    // TODO BUSCAR INFORMAÇÕES DO MUNICIPIO COM BASE DO CÓDIGO DO IBGE EM ALGUMA API (PROCURAR API) E CRIAR RESPONSE
    public ResponseMunicipioTO buscarPeloIbge(String ibge)
    {
        return null;
    }

    // TODO PREENCHER AS INFORMAÇÕES RECEBIDAS
    public Municipio criar(ResponseMunicipioTO response)
    {
        return null;
    }
}
