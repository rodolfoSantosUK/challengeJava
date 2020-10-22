package br.com.ilegra.challenge.service;

import br.com.ilegra.challenge.model.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class FileReader {

    private static Set<Sales> salesSet;
    private static Set<Customer> customerSet;
    private static Set<Salesman> salesmanSet;
    private List<String> records;


    public static void main(String[] args) {
        FileReader fileReader = new FileReader();
        fileReader.mock();
        fileReader.leitura();
        System.out.println(fileReader.getSalesSet());
        System.out.println(fileReader.getSalesmanSet());
        System.out.println(fileReader.getCustomerSet());

        salesmanTestAmount();

        customerTestAmount();

        salesTestMostExpensive();

        testWorstSalesman();
    }


    public void mock() {

        records = new ArrayList<String>();
        records.add("001ç1234567891234çDiegoç50000");
        records.add("001ç3245678865434çRenatoç40000.99");
        records.add("002ç2345675434544345çJosedaSilvaçRural");
        records.add("002ç2345675433444345çEduardoPereiraçRural");
        records.add("003ç10ç[1-10-100,2-30-2.50,3-40-3.10]çDiego");
        records.add("003ç08ç[1-34-10,2-33-1.50,3-40-0.10]çRenato");

    }


    public void leitura() {

        salesmanSet = new HashSet<Salesman>();
        customerSet = new HashSet<Customer>();
        salesSet = new HashSet<Sales>();

        records.forEach(record -> {
            if (EnumType.SALESMAN.getCod().equals(record.substring(0, 3))) {
                RecordParser.mountSalesmanObject(record, salesmanSet);
            } else if (EnumType.CUSTOMER.getCod().equals(record.substring(0, 3))) {
                RecordParser.mountCustomerObject(record, customerSet);
            } else if (EnumType.SALES.getCod().equals(record.substring(0, 3))) {
                RecordParser.mountSalesObject(record, salesSet);
            }
        });
    }




    private static void testWorstSalesman() {
        Revenue<Sales> revenue = new SalesProcessor();
        System.out.println(revenue.evaluateObjectResult(getSalesSet(), OrderCriteria.MIN).getSalesman().getName());
    }

    private static void salesTestMostExpensive() {
        Revenue<Sales> revenue = new SalesProcessor();
        System.out.println(revenue.evaluateObjectResult(getSalesSet(), OrderCriteria.MAX).getSaleId());
    }

    private static void customerTestAmount() {
        Revenue<Customer> customer = new CustomerProcessor();
        System.out.println(customer.processAmount(getCustomerSet()));
    }

    private static void salesmanTestAmount() {
        Revenue<Salesman> revenue = new SalesmanProcessor();
        System.out.println(revenue.processAmount(getSalesmanSet()));;
    }

    public static Set<Sales> getSalesSet() {
        return salesSet;
    }

    public void setSalesSet(Set<Sales> salesSet) {
        this.salesSet = salesSet;
    }

    public static Set<Customer> getCustomerSet() {
        return customerSet;
    }

    public void setCustomerSet(Set<Customer> customerSet) {
        this.customerSet = customerSet;
    }

    public static Set<Salesman> getSalesmanSet() {
        return salesmanSet;
    }

    public void setSalesmanSet(Set<Salesman> salesmanSet) {
        this.salesmanSet = salesmanSet;
    }
}
