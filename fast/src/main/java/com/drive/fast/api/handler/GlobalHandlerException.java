package com.drive.fast.api.handler;

import com.drive.fast.api.dto.response.ErrorResponse;
import com.drive.fast.domain.exception.client.ClientNotFound;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.dao.DataAccessResourceFailureException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.OptimisticLockingFailureException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalHandlerException {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorResponse> handleValidationErrors(MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getFieldErrors().forEach(error ->
                errors.put(error.getField(), error.getDefaultMessage())
        );

        return buildResponse(HttpStatus.BAD_REQUEST, "Erro de validação nos campos informados.", errors);
    }

    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity<ErrorResponse> handleDataIntegrity(DataIntegrityViolationException ex) {
        return buildResponse(HttpStatus.CONFLICT, "Conflito de integridade: o registro já existe ou viola regras de negócio.", null);
    }

    @ExceptionHandler(OptimisticLockingFailureException.class)
    public ResponseEntity<ErrorResponse> handleOptimisticLocking(OptimisticLockingFailureException ex) {
        return buildResponse(HttpStatus.CONFLICT, "O registro foi alterado por outro usuário. Por favor, recarregue os dados e tente novamente.", null);
    }

    @ExceptionHandler(DataAccessResourceFailureException.class)
    public ResponseEntity<ErrorResponse> handleDatabaseDown(DataAccessResourceFailureException ex) {
        return buildResponse(HttpStatus.SERVICE_UNAVAILABLE, "O serviço de banco de dados está temporariamente indisponível.", null);
    }


    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleEntityNotFound(EntityNotFoundException ex) {
        return buildResponse(HttpStatus.NOT_FOUND, ex.getMessage(), null);
    }

    @ExceptionHandler(ClientNotFound.class)
    public ResponseEntity<ErrorResponse> handleUserNotFound(ClientNotFound ex) {
        return buildResponse(HttpStatus.NOT_FOUND, ex.getMessage(), null);
    }


    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> handleGenericException(Exception ex) {
        return buildResponse(HttpStatus.INTERNAL_SERVER_ERROR, "Ocorreu um erro interno inesperado no servidor.", null);
    }

    private ResponseEntity<ErrorResponse> buildResponse(HttpStatus status, String message, Map<String, String> errors) {
        ErrorResponse errorResponseDTO = new ErrorResponse(
                LocalDateTime.now(),
                status.value(),
                message,
                errors
        );

        return ResponseEntity.status(status).body(errorResponseDTO);
    }
}