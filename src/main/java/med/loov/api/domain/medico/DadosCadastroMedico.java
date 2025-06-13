package med.loov.api.domain.medico;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import med.loov.api.domain.endereco.DadosEndereco;

public record DadosCadastroMedico(
        @NotBlank //anotação bean validation para garantir que o campo nao seja nulo e nem vazio
        String nome,

        @NotBlank
        @Email //garante que o email tenha um formato valido
        String email,

        @NotBlank
        String telefone,

        @NotBlank
        @Pattern(regexp = "\\d{4,6}") //garante que o crm tenha um formato valido, tendo de 4 a 6 digitos
        String crm,

        @NotNull
        Especialidade especialidade,

        @NotNull
        @Valid //valida se tudo esta correto de acordo com as validçoes impostas no DTO DadosEndereco
        DadosEndereco endereco) {
}
