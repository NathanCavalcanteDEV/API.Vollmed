package API.Rest.da.aplicacao.Voll.med.domain.paciente;
import API.Rest.da.aplicacao.Voll.med.domain.endereco.DadosEndereco;
import jakarta.validation.Valid;

public record DadosAtualizacaoPaciente(
        Long id,
        String nome,
        String telefone,
        @Valid DadosEndereco endereco)
{

}