package com.airbnb.clone.airbnbclone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class ListingController {
    @Autowired
    private ListingService listingService;
    @GetMapping("/listings")
    public List<Listing> getAllListings() {
        return listingService.getAllListings();
    }
    @GetMapping("/listings/{ListingID}")
    public Optional<Listing> getListing(@PathVariable int ListingID){
        Optional<Listing> theListing=listingService.getListingById(ListingID);
        if  (theListing.isEmpty()){
            throw new RuntimeException("Listing id can not found enter a correct id -"+ListingID);
        }
        return theListing;
    }
    @PostMapping("/listings")
    public Listing addListing(@RequestBody Listing theListing){
        theListing.setId(0);
        return listingService.saveListing(theListing);
    }
    @PutMapping("/listings/{theListing}")
    public Listing updateListing(@PathVariable int theListing,@RequestBody Listing theinput){
       Optional<Listing> existing=listingService.getListingById(theListing);
        if (existing.isEmpty()){
            throw new RuntimeException("Id cannot be found");
        }

       Listing newlisting=existing.get();
      newlisting.setHost_first_name(theinput.getHost_first_name());
      newlisting.setHost_last_name(theinput.getHost_last_name());
      newlisting.setHost_email(theinput.getHost_email());
      newlisting.setTitle(theinput.getTitle());
      newlisting.setDescription(theinput.getDescription());
      newlisting.setPrice(theinput.getPrice());
      theinput.setLocation(theinput.getLocation());

      return listingService.saveListing(newlisting);
    }
    @DeleteMapping("/listings/{listingId}")
    public String deleteListing(@PathVariable int listingId ){

        Optional<Listing> Listing2bdeleted=listingService.getListingById(listingId );
        if (Listing2bdeleted==null){
            throw new RuntimeException("com.airbnb.clone.airbnbclone.Listing Not found"+listingId);
        }
       listingService.deleteListing(listingId);
        return "Deleted com.airbnb.clone.airbnbclone.Listing id "+ listingId;
    }
}

