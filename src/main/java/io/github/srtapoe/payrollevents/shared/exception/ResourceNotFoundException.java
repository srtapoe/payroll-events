package io.github.srtapoe.payrollevents.shared.exception;

/**
 * Lançada quando um recurso não existe (ex.: colaborador com id inexistente).
 * Vira HTTP 404 no {@link GlobalExceptionHandler}.
 */
public class ResourceNotFoundException extends RuntimeException {

    public ResourceNotFoundException(String message) {
        super(message);
    }
}
