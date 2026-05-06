package API.Rest.da.aplicacao.Voll.med.medico;

import API.Rest.da.aplicacao.Voll.med.endereco.DadosEndereco;
import jakarta.validation.constraints.NotNull;

public record DadosAtualizacaoMedico(
        @NotNull
        Long id,
        String nome,
        String telefone,
        DadosEndereco endereco) {



}
