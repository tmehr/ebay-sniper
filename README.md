# ebay-sniper
`Quarkus` application written in Java with REST endpoints for eBay bid sniping.

### Disclaimer
For educational purposes only. See eBay API License Agreement for details if you intend to use this.

### Prerequisites
- an eBay API token, which can be obtained by signing up for an eBay developer account (if you are actually bidding, it needs those permissions)
- Curl client/API client of choice (I used Postman)

### Context 
My company made the decision to move from `Spring Boot` to `Quarkus` as the technical direction for new microservices/API's.
I wanted to get familiar with `Quarkus` as quickly as possible, so I started this project as a proof of concept. Basically,
create a few API's with authentication, call out to a 3rd party API, get a feel for some of the different annotations 
and the ways `Quarkus` differed from `Spring Boot`, etc. <br>
<br>
I decided on a programmatic eBay bidder as I was looking to buy a film camera at the time and had been sniped 4x in a row. 
It was intended to be for personal use in order to buy that camera. I got a good enough of a feel for the `Quarkus` 
framework and my `Quarkus` work at my job had ramped up enough, so I abandoned this project. This application is  at a 
point where you can grab a for sale or auctioning item's details based on that item id. There is no automated scheduling or 
feature that determines the countdown of the auction timer.<br>
<br>
_~tmehr_
