package med.loov.api.domain.paciente;


import jakarta.validation.constraints.NotNull;
import med.loov.api.domain.endereco.DadosEndereco;

public record DadosAtualizaPaciente(
    @NotNull
    Long id,
    String nome,
    String email,
    String telefone,
    DadosEndereco endereco
) {
}
