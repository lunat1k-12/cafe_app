package com.cafetery.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "TABLES")
public class CafeTable {

    @Column(name = "PLACE_ID")
    private String placeId;

    @Id
    @Column(name = "ID")
    private Long id;

    @NotNull
    @Column(name = "GUESTS_COUNT")
    private int guestsCount;

    @Column(name = "STATE")
    private String state;

    public String getPlaceId() {
        return placeId;
    }

    public void setPlaceId(String placeId) {
        this.placeId = placeId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getGuestsCount() {
        return guestsCount;
    }

    public void setGuestsCount(int guestsCount) {
        this.guestsCount = guestsCount;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}
