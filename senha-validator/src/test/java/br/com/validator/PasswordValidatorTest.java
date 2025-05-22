
package br.com.validator;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PasswordValidatorTest {

    @Test
    public void senhaCurtaDeveRetornarErro() {
        PasswordValidator validator = new PasswordValidator();
        ValidationResult result = validator.validate("abc");

        assertFalse(result.isValid());
        assertTrue(result.getErrors().contains("A senha deve ter pelo menos 8 caracteres"));
        assertTrue(result.getErrors().contains("A senha deve conter pelo menos 2 dígitos"));
        assertTrue(result.getErrors().contains("A senha deve conter pelo menos uma letra maiuscula"));
        assertTrue(result.getErrors().contains("A senha deve conter pelo menos um caractere especial"));
    }

    @Test
    public void senhaSemLetraMaiuscula() {
        PasswordValidator validator = new PasswordValidator();
        ValidationResult result = validator.validate("senha123!");

        assertFalse(result.isValid());
        assertTrue(result.getErrors().contains("A senha deve conter pelo menos uma letra maiuscula"));
    }

    @Test
    public void senhaSemDigitos_DeveRetornarErro() {
        ValidationResult result = validator.validate("Abcdef@#");
        assertFalse(result.isValida());
        assertTrue(result.getErros().contains("A senha deve conter pelo menos 2 dígitos"));
    }

    @Test
    public void senhaSemEspecial_DeveRetornarErro() {
        ValidationResult result = validator.validate("Abc12345");
        assertFalse(result.isValida());
        assertTrue(result.getErros().contains("A senha deve conter pelo menos um caractere especial"));
    }

    @Test
    public void senhaValida_DevePassar() {
        ValidationResult result = validator.validate("Ab12@abc");
        assertTrue(result.isValida());
        assertEquals(0, result.getErros().size());
    }

    @Test
    public void senhaVazia_DeveRetornarErro() {
        ValidationResult result = validator.validate("");
        assertFalse(result.isValida());
        assertTrue(result.getErros().contains("A senha não pode estar vazia"));
    }
}
