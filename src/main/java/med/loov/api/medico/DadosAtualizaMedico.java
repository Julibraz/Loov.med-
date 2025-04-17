package med.loov.api.medico;

import jakarta.validation.constraints.NotNull;
import med.loov.api.endereco.DadosEndereco;

public record DadosAtualizaMedico(
        @NotNull
        Long id,
        String nome,
        String telefone,
        DadosEndereco endereco) {
}
