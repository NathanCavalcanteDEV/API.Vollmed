package API.Rest.da.aplicacao.Voll.med.paciente;

import API.Rest.da.aplicacao.Voll.med.endereco.Endereco;
import API.Rest.da.aplicacao.Voll.med.medico.Especialidade;
import API.Rest.da.aplicacao.Voll.med.medico.Medico;

public record DadosDetalhamentoPaciente(Long id, String nome, String email, String telefone,  Endereco endereco) {
    public DadosDetalhamentoPaciente(Paciente paciente) {
        this(paciente.getId(), paciente.getNome(), paciente.getEmail(), paciente.getTelefone(), paciente.getEndereco());
    }

}