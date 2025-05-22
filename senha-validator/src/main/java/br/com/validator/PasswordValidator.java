package br.com.validator;

import java.util.ArrayList;
import java.util.List;

public class PasswordValidator {
    public ValidationResult validate(String senha) {
        List<String> errors = new ArrayList<>();

        if (senha.length() < 8) {
            errors.add("A senha deve ter pelo menos 8 caracteres");
        }

        return new ValidationResult(errors.isEmpty(), errors);
    }
}