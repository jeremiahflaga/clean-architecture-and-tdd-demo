package com.example.interactors.createcat;

/**
 * Created by Dev on 19/10/2017.
 */

public class CreateCatValidator {

    public ValidationResult validate(CreateCatRequest request) {
        ValidationResult validationResult = new ValidationResult();
        validationResult.valid = true;
        if (request.name.equalsIgnoreCase("Devil")) {
            validationResult.valid = false;
            validationResult.errorMessage = "Sorry! We do not want the devil to become a god.";
        }

        return validationResult;
    }

    public static class ValidationResult {
        private boolean valid;
        public String errorMessage;

        public boolean isValid() {
            return valid;
        }

        public String errorMessage() {
            return errorMessage;
        }
    }
}
