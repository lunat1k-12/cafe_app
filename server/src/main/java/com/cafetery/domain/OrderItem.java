package com.cafetery.domain;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Entity
@Table(name = "ORDER_ITEMS")
public class OrderItem {

    @Id
    @GeneratedValue
    @Column(name = "ID")
    private Long id;

    @NotNull
    @Column(name = "ORDER_ID")
    private Long orderId;

    @NotNull
    @Column(name = "MENU_ITEM_ID")
    private Long menuItemId;

    @NotNull
    @Column(name = "COUNT")
    private int count;

    @NotNull
    @Column(name = "TOTAL_COST")
    private BigDecimal totalCost;

    @Column(name = "STATUS")
    private String status;

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

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public Long getMenuItemId() {
        return menuItemId;
    }

    public void setMenuItemId(Long menuItemId) {
        this.menuItemId = menuItemId;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public BigDecimal getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(BigDecimal totalCost) {
        this.totalCost = totalCost;
    }
}
