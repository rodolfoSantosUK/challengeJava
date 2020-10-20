package br.com.ilegra.challenge.model;

import java.math.BigDecimal;

public class Item {

    private Integer idItem;
    private BigDecimal quantity;
    private Double price;
    private Salesman salesman;


    public Item(Integer idItem, BigDecimal quantity, Double price, Salesman salesman) {
        this.idItem = idItem;
        this.quantity = quantity;
        this.price = price;
        this.salesman = salesman;
    }

    public Integer getIdItem() {
        return idItem;
    }

    public void setIdItem(Integer idItem) {
        this.idItem = idItem;
    }

    public BigDecimal getQuantity() {
        return quantity;
    }

    public void setQuantity(BigDecimal quantity) {
        this.quantity = quantity;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Salesman getSalesman() {
        return salesman;
    }

    public void setSalesman(Salesman salesman) {
        this.salesman = salesman;
    }
}
