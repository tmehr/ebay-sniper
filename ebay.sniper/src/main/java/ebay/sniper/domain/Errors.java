package ebay.sniper.domain;

public enum Errors {
    URL_NOT_PROVIDED(6001, "A url was not provided."),
    URL_NOT_SUPPORTED_OR_INVALID(6002, "The provided url is not supported or is invalid. Please verify" +
            " the url and retry."),
    MAX_BID_EXCEEDED(6003, "The current bid is higher than your maximum bid. Bid cannot be placed."),
    BID_NOT_SUBMITTED(6004, "Your bid could not be submitted. Try again later.");

    private final int code;
    private final String message;

    Errors(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }
    public String getMessage() {
        return message;
    }
}
