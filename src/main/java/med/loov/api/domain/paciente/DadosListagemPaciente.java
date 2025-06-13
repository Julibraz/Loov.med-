package med.loov.api.domain.paciente;

public record DadosListagemPaciente(String nome, String email, String telefone, String cpf) {

    public DadosListagemPaciente(Paciente paciente) {
        this(paciente.getNome(), paciente.getEmail(), paciente.getTelefone(), paciente.getCpf()); //this() chama o construtor da classe DadosListagemPaciente
    }
}
