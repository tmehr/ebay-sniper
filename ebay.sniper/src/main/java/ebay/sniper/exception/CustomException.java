package ebay.sniper.exception;

import ebay.sniper.domain.Errors;

public class CustomException extends Exception {
    public CustomException() {

    }

    public CustomException(String message)
    {
        super(message);
    }

    public CustomException(Errors errors) {
        super(errors.getMessage());
    }

    @Override
    public Throwable fillInStackTrace() {
        return this;
    }
}
