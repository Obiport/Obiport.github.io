package com.airbnb.clone.airbnbclone;

import jakarta.persistence.*;

@Entity
@Table(name = "listings")
public class Listing {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "host_first_name")
    private String host_first_name;
    @Column(name = "host_last_name")
    private String host_last_name;
    @Column(name = "host_email")
    private String host_email;
    @Column(name = "title")
    private String title;
    @Column(name = "description")
    private String description;
    @Column(name = "price")
    private String price;
    @Column(name = "location")
    private String location;

    public Listing(){

    }

    public Listing(String host_first_name, String host_last_name, String host_email, String title, String description, String price, String location) {
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

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
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
