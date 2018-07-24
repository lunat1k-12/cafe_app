package com.cafetery.domain;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

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

    @Column(name = "TABLE_ID")
    private Long tableId;

    @NotNull
    @Column(name = "STATUS")
    private String status;

    @Column(name = "ORDER_DATE")
    private Date orderDate;

    @Column(name = "CLOSE_DATE")
    private Date closeDate;

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public Date getCloseDate() {
        return closeDate;
    }

    public void setCloseDate(Date closeDate) {
        this.closeDate = closeDate;
    }

    public Long getTableId() {
        return tableId;
    }

    public void setTableId(Long tableId) {
        this.tableId = tableId;
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
