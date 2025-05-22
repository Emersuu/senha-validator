
package br.com.validator;

import java.util.ArrayList;
import java.util.List;

public class PasswordValidator {

    public ValidationResult validate(String senha) {
        List<String> errors = new ArrayList<>();

        if (senha.length() < 8) {
            errors.add("A senha deve ter pelo menos 8 caracteres");
        }

        long digitCount = senha.chars().filter(Character::isDigit).count();
        if (digitCount < 2) {
            errors.add("A senha deve conter pelo menos 2 dígitos");
        }

        boolean hasUppercase = senha.chars().anyMatch(Character::isUpperCase);
        if (!hasUppercase) {
            errors.add("A senha deve conter pelo menos uma letra maiuscula");
        }

        boolean hasSpecialChar = senha.chars().anyMatch(c -> "!@#$%^&*()-_=+[{]}|;:'",<.>/?`~".indexOf(c) >= 0);
        if (!hasSpecialChar) {
            errors.add("A senha deve conter pelo menos um caractere especial");
        }

        return new ValidationResult(errors.isEmpty(), errors);
    }
}
