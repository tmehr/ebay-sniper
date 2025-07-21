package ebay.sniper.service;

import ebay.sniper.client.EbayResource;
import ebay.sniper.domain.*;
import ebay.sniper.exception.CustomException;
import org.apache.commons.lang3.StringUtils;
import org.jboss.logging.Logger;

import javax.enterprise.context.ApplicationScoped;
import java.math.BigDecimal;
import java.util.*;

@ApplicationScoped
public class BidSnipingService {

    private static final Logger log = Logger.getLogger(BidSnipingService.class);
    private static final String EBAY_URL_PATTERN = "ebay.com/itm";

    private final EbayResource ebayResource = new EbayResource();

    public void submitBid(BuyRequest buyRequest) throws CustomException {

        String itemId = getItemIdFromUrl(buyRequest.getProductUrl());
        ItemDetail itemDetail = getItemDetails(itemId);

        //todo add in max bid check
        if (itemDetail.isFixedPrice() && itemDetail.getBuyNowPrice().getValue().compareTo(buyRequest.getMaxBid()) < 0) {
            log.info("Buying item now for item with itemId: " + itemDetail.getItemId());
            //todo buy now method
            //submit buyNow
            return;
        }

        //todo check if starting bid is < than max
        if (itemDetail.isAuction()) {
            log.info("Submitting bid for item with itemId: " + itemDetail.getItemId());
            //todo submit bid, hardcoded for now
            EbayBidRequest ebayBidRequest = new EbayBidRequest("USD", "5.00");
            ebayResource.submitBid(itemId, ebayBidRequest);
            return;
        }

        log.error(Errors.BID_NOT_SUBMITTED);
        throw new CustomException(Errors.BID_NOT_SUBMITTED);
    }

    public ItemDetail getItemDetails(String itemId) {

        log.info("Getting item details for item: " + itemId);
        LinkedHashMap itemDetailsMap = ebayResource.getItemDetails(itemId);

        //convert to ItemDetail object
        return convertToItemDetail(itemDetailsMap);
    }

    public ItemDetail convertToItemDetail(LinkedHashMap itemDetailsMap) {
        ItemDetail itemDetail = new ItemDetail();
        String[] itemIdArray = itemDetailsMap.get("itemId").toString().split("\\|");
        itemDetail.setItemId(Long.parseLong(itemIdArray[1]));

        LinkedHashMap itemPrice = (LinkedHashMap) itemDetailsMap.get("price");
        Price buyNowPrice = new Price();
        buyNowPrice.setValue(new BigDecimal(itemPrice.get("value").toString()));
        buyNowPrice.setCurrency( itemPrice.get("currency").toString());
        itemDetail.setBuyNowPrice(buyNowPrice);

        itemDetail.setTitle(itemDetailsMap.get("title").toString());
        itemDetail.setDescription(itemDetailsMap.get("shortDescription").toString());

        ArrayList buyingOptions = (ArrayList) Collections.singletonList(itemDetailsMap.get("buyingOptions")).get(0);
        if (buyingOptions.contains("FIXED_PRICE")) {
            itemDetail.setFixedPrice(true);
        }

        if (buyingOptions.contains("AUCTION")) {
            itemDetail.setAuction(true);
        }

        return itemDetail;
    }

    private String getItemIdFromUrl(String url) {

        if (StringUtils.isBlank(url)) {
            log.error(Errors.URL_NOT_PROVIDED);
        }
        if (!url.toLowerCase().contains(EBAY_URL_PATTERN)) {
            log.error(Errors.URL_NOT_SUPPORTED_OR_INVALID);
        }

        return url.substring(url.lastIndexOf("/") + 1);
    }
}
