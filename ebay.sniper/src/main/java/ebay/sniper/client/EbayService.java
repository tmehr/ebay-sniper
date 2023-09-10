package ebay.sniper.client;

import ebay.sniper.domain.EbayBidRequest;
import org.eclipse.microprofile.rest.client.annotation.RegisterClientHeaders;
import org.springframework.web.bind.annotation.RequestBody;

import javax.ws.rs.*;
import java.util.LinkedHashMap;

@RegisterClientHeaders(RequestHeaderFactory.class)
public interface EbayService {
    @GET
    @Path("/buy/browse/v1/item/get_item_by_legacy_id")
    LinkedHashMap getItemDetailsById(@QueryParam("legacy_item_id") String itemId);

    @POST
    @Path("/buy/offer/v1_beta/bidding/{itemId}/place_proxy_bid")
    LinkedHashMap submitBid(@PathParam("itemId") String itemId, @RequestBody EbayBidRequest eBayBidRequest);
}
