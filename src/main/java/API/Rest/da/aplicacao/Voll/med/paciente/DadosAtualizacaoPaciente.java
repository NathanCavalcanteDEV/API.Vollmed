package API.Rest.da.aplicacao.Voll.med.paciente;
import API.Rest.da.aplicacao.Voll.med.endereco.DadosEndereco;
import jakarta.validation.Valid;

public record DadosAtualizacaoPaciente(
        Long id,
        String nome,
        String telefone,
        @Valid DadosEndereco endereco)
{

}