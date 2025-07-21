package ebay.sniper.controller;

import ebay.sniper.domain.BuyRequest;
import ebay.sniper.exception.CustomException;
import ebay.sniper.service.BidSnipingService;
import org.eclipse.microprofile.jwt.JsonWebToken;
import org.jboss.logging.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.security.PermitAll;
import javax.inject.Inject;
import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.SecurityContext;
import java.security.Principal;

@RestController
@RequestMapping("/ebay-sniper")
public class EbaySniperController {

    private static final Logger log = Logger.getLogger(EbaySniperController.class);

    @Inject
    private BidSnipingService bidSnipingService;
    @Inject
    JsonWebToken jwt;

    @GetMapping("/hello")
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() {
        log.info("Received call to api /hello.");
        return "Hello World, ebay sniper";
    }

    @PostMapping("/submit-bid")
    @PermitAll
    @Consumes(MediaType.APPLICATION_JSON)
    public ResponseEntity<String> submitBid(@Valid BuyRequest buyRequest, @Context SecurityContext ctx)
            throws CustomException {

        log.info("Received call to api /submit-bid.");

        Principal principal = ctx.getUserPrincipal();
        bidSnipingService.submitBid(buyRequest);
        return new ResponseEntity<>("Bid successfully submitted.", HttpStatus.CREATED);
    }
}