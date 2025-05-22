
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
}
