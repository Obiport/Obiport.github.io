package com.airbnb.clone.airbnbclone;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import jakarta.validation.Valid;
import java.util.List;
import java.util.Optional;
@RestController
@RequestMapping("/api")
@Validated
public class ListingController {
    @Autowired
    private ListingService listingService;

    @GetMapping("/listings")
    public List<Listing> getAllListings() {
        return listingService.getAllListings();
    }
    @GetMapping("/listings/{ListingID}")
    public Optional<Listing> getListing(@PathVariable int ListingID){
        Optional<Listing> theListing = listingService.getListingById(ListingID);
        if (theListing.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Listing not found with id - " + ListingID);
        }
        return theListing;
    }
    @PostMapping("/listings")
    public Listing addListing(@Valid @RequestBody Listing theListing){
        theListing.setId(0);
        return listingService.saveListing(theListing);
    }

    @PutMapping("/listings/{theListing}")
    public Listing updateListing(@PathVariable int theListing, @Valid @RequestBody Listing theinput){
        Optional<Listing> existing = listingService.getListingById(theListing);
        if (existing.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Listing not found with id - " + theListing);
        }
        Listing newlisting = existing.get();
        newlisting.setHost_first_name(theinput.getHost_first_name());
        newlisting.setHost_last_name(theinput.getHost_last_name());
        newlisting.setHost_email(theinput.getHost_email());
        newlisting.setTitle(theinput.getTitle());
        newlisting.setDescription(theinput.getDescription());
        newlisting.setPrice(theinput.getPrice());
        newlisting.setLocation(theinput.getLocation());
        return listingService.saveListing(newlisting);
    }

    @DeleteMapping("/listings/{listingId}")
    public String deleteListing(@PathVariable int listingId){
        Optional<Listing> listingToDelete = listingService.getListingById(listingId);
        if (listingToDelete.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Listing not found with id - " + listingId);
        }
        listingService.deleteListing(listingId);
        return "Deleted listing with id " + listingId;
    }
}
