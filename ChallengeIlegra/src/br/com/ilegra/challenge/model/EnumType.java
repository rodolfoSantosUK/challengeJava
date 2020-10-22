package br.com.ilegra.challenge.model;

public enum EnumType {

    SALESMAN("001"), CUSTOMER("002"), SALES("003");

    private String cod;

    EnumType(String cod) {
        this.cod = cod;
    }

    public String getCod() {
        return cod;
    }

    public void setCod(String cod) {
        this.cod = cod;
    }
}
