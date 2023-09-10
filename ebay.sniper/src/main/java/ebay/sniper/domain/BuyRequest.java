package ebay.sniper.domain;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

public class BuyRequest {
    @NotBlank
    private String productUrl;
    @NotNull
    private BigDecimal maxBid;

    public String getProductUrl() {
        return productUrl;
    }

    public BigDecimal getMaxBid() {
        return maxBid;
    }

    public void setProductUrl(String productUrl) {
        this.productUrl = productUrl;
    }

    public void setMaxBid(BigDecimal maxBid) {
        this.maxBid = maxBid;
    }
}
