package ebay.sniper.client;

import ebay.sniper.domain.EbayBidRequest;
import org.eclipse.microprofile.rest.client.RestClientBuilder;

import javax.enterprise.context.ApplicationScoped;
import java.net.URI;
import java.util.LinkedHashMap;

@ApplicationScoped
public class EbayResource {
    private final EbayService ebayService;

    public EbayResource() {
        ebayService = RestClientBuilder.newBuilder()
                .baseUri(URI.create("https://api.ebay.com"))
                .build(EbayService.class);
    }

    public LinkedHashMap getItemDetails(String itemId) {
        return ebayService.getItemDetailsById(itemId);
    }

    public LinkedHashMap submitBid(String itemId, EbayBidRequest ebayBidRequest) {
        LinkedHashMap ebayBid = ebayService.submitBid(itemId, ebayBidRequest);
        return ebayBid;
    }
}
