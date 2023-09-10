package ebay.sniper.domain;

public class EbayBidRequest {

    private MaxAmount maxAmount;

    public MaxAmount getMaxAmount() {
        return maxAmount;
    }

    public void setMaxAmount(MaxAmount maxAmount) {
        this.maxAmount = maxAmount;
    }

    public EbayBidRequest(String currency, String value) {
        this.maxAmount = new MaxAmount();
        this.maxAmount.currency = currency;
        this.maxAmount.value = value;
    }

    class MaxAmount {
        private String currency;
        private String value;

        public String getCurrency() {
            return currency;
        }

        public void setCurrency(String currency) {
            this.currency = currency;
        }

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }
    }
}
