package br.com.ilegra.challenge.model;

public class Salesman extends Person {

    private String cpf;

    private Double salary;

    public Salesman(String cod, String name, String cpf, Double salary) {
        super(cod, name);
        this.cpf = cpf;
        this.salary = salary;
    }

    public Salesman(String cod, String name) {
        super(cod, name);
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }
}
