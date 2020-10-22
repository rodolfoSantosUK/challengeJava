package br.com.ilegra.challenge.model;

import java.math.BigDecimal;

public class Item {

    private Integer idItem;
    private BigDecimal quantity;
    private Double price;


    public Item(Integer idItem, BigDecimal quantity, Double price) {
        this.idItem = idItem;
        this.quantity = quantity;
        this.price = price;
    }

    @Override
    public String toString() {
        return "Item{" +
                "idItem=" + idItem +
                ", quantity=" + quantity +
                ", price=" + price +
                '}';
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

}
