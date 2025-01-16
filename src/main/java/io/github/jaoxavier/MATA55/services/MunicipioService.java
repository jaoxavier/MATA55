package io.github.jaoxavier.MATA55.services;

import io.github.jaoxavier.MATA55.domain.entity.Municipio;
import io.github.jaoxavier.MATA55.domain.repository.MunicipioRepository;
import io.github.jaoxavier.MATA55.rest.dto.EnderecoTO;
import io.github.jaoxavier.MATA55.rest.dto.ResponseEnderecoTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Optional;

@Service
public class MunicipioService {

    @Autowired
    private MunicipioRepository municipioRepository;


    public Optional<Municipio> procurarMunicipioPorUfCidade(EnderecoTO dto)
    {
        return municipioRepository.findByUfAndCidade(dto.getUf(), dto.getCidade());
    }

    public Municipio criaMunicipio(ResponseEnderecoTO responseCorreios)
    {
        Municipio municipio = new Municipio();

        municipio.setUf(responseCorreios.getUf());
        municipio.setCidade(responseCorreios.getLocalidade());
        municipio.setEstado(responseCorreios.getEstado());
        municipio.setRegiao(responseCorreios.getRegiao());
        municipio.setDdd(responseCorreios.getDdd());

        return municipioRepository.save(municipio);
    }
}
