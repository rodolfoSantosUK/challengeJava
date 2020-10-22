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

    private Set<Sales> salesSet;
    private Set<Customer> customerSet;
    private Set<Salesman> salesmanSet;
    private List<String> records;

    private static final String FILE_PATH = "data/out/sales.done.dat";

    public void readIn() {
        records = new ArrayList<String>();
        try {

            String environment = System.getenv("HOME_PATH");

            String pathFile = String.format("%s%s", environment, FILE_PATH);

            System.out.println(pathFile);
            FileReader file = new FileReader(pathFile);
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

    public void parseRecordsToObject() {

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

    public FileReaderIlegra(Set<Sales> salesSet, Set<Customer> customerSet, Set<Salesman> salesmanSet) {
        this.salesSet = salesSet;
        this.customerSet = customerSet;
        this.salesmanSet = salesmanSet;
    }

    private void testWorstSalesman() {
        Revenue<Sales> revenue = new SalesProcessor();
        System.out.println(revenue.evaluateObjectResult(getSalesSet(), OrderCriteria.MIN).getSalesman().getName());
    }

    public Set<Sales> getSalesSet() {
        return salesSet;
    }

    public void setSalesSet(Set<Sales> salesSet) {
        this.salesSet = salesSet;
    }

    public Set<Customer> getCustomerSet() {
        return customerSet;
    }

    public void setCustomerSet(Set<Customer> customerSet) {
        this.customerSet = customerSet;
    }

    public Set<Salesman> getSalesmanSet() {
        return salesmanSet;
    }

    public void setSalesmanSet(Set<Salesman> salesmanSet) {
        this.salesmanSet = salesmanSet;
    }
}
