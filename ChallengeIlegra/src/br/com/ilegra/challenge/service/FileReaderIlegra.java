package br.com.ilegra.challenge.service;

import br.com.ilegra.challenge.model.*;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class FileReaderIlegra {

    private static Set<Sales> salesSet;
    private static Set<Customer> customerSet;
    private static Set<Salesman> salesmanSet;
    private List<String> records;

    public void readIn() {
        records = new ArrayList<String>();
        try {
            FileReader file = new FileReader("/home/ubuntu20/dev/workspace/challengeJava/ChallengeIlegra/sales.done.dat");
            BufferedReader fileStream = new BufferedReader(file);

            String temp = fileStream.readLine();
            while (temp != null) {
                temp = fileStream.readLine();
                if (temp != null) {
                    records.add(temp);
                }
            }

            fileStream.close();
        } catch (FileNotFoundException e) {
            System.out.println("No file was read");
        } catch (IOException e) {
            System.out.println("There was a problem reading the file");
        }
    }


    public static void main(String[] args) {
        FileReaderIlegra fileReaderIlegra = new FileReaderIlegra();
        fileReaderIlegra.readIn();
        fileReaderIlegra.leitura();
        System.out.println(fileReaderIlegra.getSalesSet());
        System.out.println(fileReaderIlegra.getSalesmanSet());
        System.out.println(fileReaderIlegra.getCustomerSet());

        salesmanTestAmount();

        customerTestAmount();

        salesTestMostExpensive();

        testWorstSalesman();
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
        System.out.println(revenue.processAmount(getSalesmanSet()));
        ;
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
