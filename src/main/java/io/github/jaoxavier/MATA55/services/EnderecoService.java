package io.github.jaoxavier.MATA55.services;

import io.github.jaoxavier.MATA55.domain.entity.Endereco;
import io.github.jaoxavier.MATA55.domain.entity.Municipio;
import io.github.jaoxavier.MATA55.domain.repository.EnderecoRepository;
import io.github.jaoxavier.MATA55.domain.repository.MunicipioRepository;
import io.github.jaoxavier.MATA55.rest.dto.EnderecoTO;
import io.github.jaoxavier.MATA55.rest.dto.ResponseEnderecoTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Optional;

@Service
public class EnderecoService
{
    @Autowired
    private EnderecoRepository enderecoRepository;

    @Autowired
    private MunicipioService municipioService;

    public Endereco criarEndereco(EnderecoTO dto)
    {
        ResponseEnderecoTO responseCorreios = getEnderecoByCep(dto.getCep());
        Optional<Municipio> optionalMunicipio = municipioService.procurarMunicipioPorUfCidade(dto);

        Municipio municipio = optionalMunicipio.orElseGet(
                () -> municipioService.criaMunicipio(responseCorreios)
        );

        Endereco endereco = new Endereco();

        endereco.setBairro(responseCorreios.getBairro());
        endereco.setCep(responseCorreios.getCep());
        endereco.setComplemento(dto.getComplemento());
        endereco.setLogradouro(responseCorreios.getLogradouro());
        endereco.setMunicipio(municipio);
        endereco.setFiscal(dto.isFiscal());
        endereco.setPrincipal(dto.isPrincipal());

        return enderecoRepository.save(endereco);
    }

    public ResponseEnderecoTO getEnderecoByCep(String cep)
    {
        RestTemplate restTemplate = new RestTemplate();
        return  restTemplate.getForObject("https://viacep.com.br/ws/" + cep + "/json", ResponseEnderecoTO.class);
    }
}
