package br.com.ilegra.challenge.model;

public class Person extends Identifyer {

    protected String name;

    public Person(String cod, String name) {
        super(cod);
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


}
