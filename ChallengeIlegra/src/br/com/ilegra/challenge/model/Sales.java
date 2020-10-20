package br.com.ilegra.challenge.model;

import java.util.Set;

public class Sales extends Identifyer {

    private String saleId;

    private Set<Item> itens;

    private Salesman salesman;

    public Sales(String cod, String saleId, Set<Item> itens, Salesman salesman) {
        super(cod);
        this.saleId = saleId;
        this.itens = itens;
        this.salesman = salesman;
    }

    public Salesman getSalesman() {
        return salesman;
    }

    public void setSalesman(Salesman salesman) {
        this.salesman = salesman;
    }

    public String getSaleId() {
        return saleId;
    }

    public void setSaleId(String saleId) {
        this.saleId = saleId;
    }

    public Set<Item> getItens() {
        return itens;
    }

    public void setItens(Set<Item> itens) {
        this.itens = itens;
    }
}
