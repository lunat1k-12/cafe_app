package com.cafetery.domain;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "MENU_ITEMS")
public class MenuItem {

    @Id
    @GeneratedValue
    @Column(name = "ID")
    private Long id;

    @NotNull
    @Column(name = "TITLE")
    private String title;

    @Lob
    @Column(name = "IMAGE")
    private byte[] image;

    @Column(name = "DESCRIPTION")
    private String description;

    @NotNull
    @Column(name = "PRICE")
    private Double price;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
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
}
