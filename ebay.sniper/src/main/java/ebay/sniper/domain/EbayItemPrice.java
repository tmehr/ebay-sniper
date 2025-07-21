package ebay.sniper.domain;

public class EbayItemPrice {
    private String value;
    private String currency;

    public String getValue() {
        return value;
    }

    public String getCurrency() {
        return currency;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }
}
