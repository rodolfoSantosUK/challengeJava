package br.com.ilegra.challenge.model;

public class Customer extends Person  {

    private String cnpj;

    private String businessArea;

    public Customer(String cod, String name, String cnpj, String businessArea) {
        super(cod, name);
        this.cnpj = cnpj;
        this.businessArea = businessArea;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getBusinessArea() {
        return businessArea;
    }

    public void setBusinessArea(String businessArea) {
        this.businessArea = businessArea;
    }
}
