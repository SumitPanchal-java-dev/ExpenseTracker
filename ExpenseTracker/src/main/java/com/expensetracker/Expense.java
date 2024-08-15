package com.expensetracker;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Date;

public class Expense implements Serializable {
    private int id;
    private Date date;
    private String category;
    private BigDecimal amount;
    private String description;

    // Constructors, Getters, and Setters
    public Expense() {}

    public Expense(int id, Date date, String category, BigDecimal amount, String description) {
        this.id = id;
        this.date = date;
        this.category = category;
        this.amount = amount;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
