package ebay.sniper.domain;

import java.math.BigDecimal;

public class Price {
    private BigDecimal value;
    private String currency;

    public BigDecimal getValue() {
        return value;
    }

    public String getCurrency() {
        return currency;
    }

    public void setValue(BigDecimal value) {
        this.value = value;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }
}
