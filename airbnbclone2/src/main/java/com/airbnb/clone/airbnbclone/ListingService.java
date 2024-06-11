package com.airbnb.clone.airbnbclone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ListingService {
    @Autowired
    private ListingRepository listingRepository;

    public List<Listing> getAllListings() {
        return listingRepository.findAll();
    }
    public Optional<Listing> getListingById(int id) {
        return listingRepository.findById(id);
    }

    public Listing saveListing(Listing list){

        return listingRepository.save(list);
    }
    public void deleteListing(int id) {
        listingRepository.deleteById(id);
    }

}
