package ebay.sniper.domain;

public class ItemDetail {
    private long itemId;
    private Price buyNowPrice;
    private Price currentBid;
    private int numberOfBids;
    private String title;
    private String description;
    private boolean fixedPrice;
    private boolean auction;

    public long getItemId() {
        return itemId;
    }

    public Price getBuyNowPrice() {
        return buyNowPrice;
    }
    public Price getCurrentBid() {
        return currentBid;
    }

    public int getNumberOfBids() {
        return numberOfBids;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public void setItemId(long itemId) {
       this.itemId = itemId;
    }

    public void setBuyNowPrice(Price buyNowPrice) {
        this.buyNowPrice = buyNowPrice;
    }

    public void setCurrentBid(Price currentBid) {
        this.currentBid = currentBid;
    }

    public void setNumberOfBids(int numberOfBids) {
        this.numberOfBids = numberOfBids;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isFixedPrice() {
        return this.fixedPrice;
    }

    public void setFixedPrice(boolean fixedPrice) {
        this.fixedPrice = fixedPrice;
    }

    public boolean isAuction() {
        return this.auction;
    }

    public void setAuction(boolean auction) {
        this.auction = auction;
    }
}
