package tech.pinhos.financas.config;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

    // Captura erros de validação
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, String>> handleValidationExceptions(MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();

        // Percorre todos os erros encontrados nas validações
        ex.getBindingResult().getAllErrors().forEach(error -> {
            String fieldName = ((FieldError) error).getField();  // Nome do campo que falhou
            String errorMessage = error.getDefaultMessage();     // Mensagem de erro da validação
            errors.put(fieldName, errorMessage);                 // Adiciona ao mapa
        });

        // Retorna as mensagens de erro com status 400 BAD REQUEST
        return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
    }
}