package com.airbnb.clone.airbnbclone;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

@Entity
@Table(name = "listings")
public class Listing {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @NotBlank(message = "Host first name is mandatory")
    @Column(name = "host_first_name")
    private String host_first_name;

    @NotBlank(message = "Host last name is mandatory")
    @Column(name = "host_last_name")
    private String host_last_name;

    @NotBlank(message = "Host email is mandatory")
    @Email(message = "Host email should be valid")
    @Column(name = "host_email", unique = true)
    private String host_email;

    @NotBlank(message = "Title is mandatory")
    @Size(max = 255, message = "Title should not exceed 255 characters")
    @Column(name = "title")
    private String title;

    @NotBlank(message = "Description is mandatory")
    @Size(max = 1000, message = "Description should not exceed 1000 characters")
    @Column(name = "description")
    private String description;

    @NotNull(message = "Price is mandatory")
    @Positive(message = "Price should be a positive value")
    @Column(name = "price")
    private Double price;

    @NotBlank(message = "Location is mandatory")
    @Column(name = "location")
    private String location;
    public Listing(){

    }

    public Listing(String host_first_name, String host_last_name, String host_email, String title, String description, Double price, String location) {
        this.host_first_name = host_first_name;
        this.host_last_name = host_last_name;
        this.host_email = host_email;
        this.title = title;
        this.description = description;
        this.price = price;
        this.location = location;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getHost_first_name() {
        return host_first_name;
    }

    public void setHost_first_name(String host_first_name) {
        this.host_first_name = host_first_name;
    }

    public String getHost_last_name() {
        return host_last_name;
    }

    public void setHost_last_name(String host_last_name) {
        this.host_last_name = host_last_name;
    }

    public String getHost_email() {
        return host_email;
    }

    public void setHost_email(String host_email) {
        this.host_email = host_email;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    @Override
    public String toString() {
        return "com.airbnb.clone.airbnbclone.Listing{" +
                "id=" + id +
                ", host_first_name='" + host_first_name + '\'' +
                ", host_last_name='" + host_last_name + '\'' +
                ", host_email='" + host_email + '\'' +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", price='" + price + '\'' +
                ", location='" + location + '\'' +
                '}';
    }
}
