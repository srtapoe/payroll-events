package io.github.srtapoe.payrollevents.shared.exception;

/**
 * Lançada quando uma regra de negócio é violada
 * (ex.: admissão com data futura além do permitido, CPF já admitido).
 * Vira HTTP 422 no {@link GlobalExceptionHandler}.
 */
public class BusinessException extends RuntimeException {

    public BusinessException(String message) {
        super(message);
    }
}
