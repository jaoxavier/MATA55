package io.github.jaoxavier.MATA55.rest.dto;

import io.github.jaoxavier.MATA55.domain.entity.Contato;
import io.github.jaoxavier.MATA55.domain.entity.Filiacao;
import io.github.jaoxavier.MATA55.domain.enums.EstadoCivil;
import io.github.jaoxavier.MATA55.domain.enums.TipoTributario;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
public class PessoaTO // Um clienteTO significa que ele será usado de molde para receber a informação, não sendo necessário seguir regras
{
    private ComumTO comum;
    private FisicaTO fisica;
    private JuridicaTO juridica;

    private List<ContatoTO> contatos;
    private List<FiliacaoTO> filiacao;
    private List<SociosTO> socios;

    private EnderecoTO enderecoTO;
}
