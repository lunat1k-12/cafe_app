package com.cafetery.domain;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "ORDERS")
public class Order {

    @Id
    @GeneratedValue
    @Column(name = "ID")
    private Long id;

    @NotNull
    @Column(name = "USER_ID")
    private String userId;

    @Column(name = "GARCON_ID")
    private String garconId;

    @NotNull
    @Column(name = "MENU_ITEM")
    private Long menuItem;

    @NotNull
    @Column(name = "STATUS")
    private String status;

    @NotNull
    @Column(name = "SESSION_UUID")
    private String sessionUuid;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getGarconId() {
        return garconId;
    }

    public void setGarconId(String garconId) {
        this.garconId = garconId;
    }

    public Long getMenuItem() {
        return menuItem;
    }

    public void setMenuItem(Long menuItem) {
        this.menuItem = menuItem;
    }

    public String getSessionUuid() {
        return sessionUuid;
    }

    public void setSessionUuid(String sessionUuid) {
        this.sessionUuid = sessionUuid;
    }
}
