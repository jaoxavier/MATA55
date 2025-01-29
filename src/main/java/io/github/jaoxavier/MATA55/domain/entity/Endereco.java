package io.github.jaoxavier.MATA55.domain.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.github.jaoxavier.MATA55.rest.dto.EnderecoTO;
import io.github.jaoxavier.MATA55.rest.dto.ResponseEnderecoTO;
import io.github.jaoxavier.MATA55.services.EnderecoService;
import jakarta.persistence.*;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.client.RestTemplate;

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

    private boolean validaCep(String cep){
        if(cep == null || !cep.matches("\\d{8}")){
            return false;
        }
        return true;
    }

    public ResponseEnderecoTO buscarPeloCEP(String cep)
        {
            if(validaCep(cep)){

                String url = "https://viacep.com.br/ws/" + cep + "/json/";

                RestTemplate restTemplate = new RestTemplate();

                try {
                    ResponseEnderecoTO response = restTemplate.getForObject(url, ResponseEnderecoTO.class);

                    if (response == null || response.getLogradouro() == null) {
                        throw new IllegalStateException("Não foi possível encontrar informações para o CEP informado.");
                    }
                    if ("true".equals(response.getErro())) {
                        throw new IllegalStateException("O CEP informado não está cadastrado.");
                    }
                    
                    return response;
            
                } catch (Exception e) {
                    throw new RuntimeException("Erro ao buscar informações de endereço: " + e.getMessage(), e);
                }
            }
            throw new IllegalArgumentException("CEP inválido. Deve conter 8 dígitos numéricos.");
        }

    // TODO PREENCHER AS INFORMAÇÕES RECEBIDAS E ALIMENTAR OS MUNICIPIOS
    // TODO BUSCAR AS INFORMAÇÕES DO MUNICIPIO NA NOSSA BASE, SE NÃO ENCONTRAR, UTILIZAR
    public Endereco criar(EnderecoTO dto)
    {
        return null;
    }

}
