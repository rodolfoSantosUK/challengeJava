package br.com.ilegra.challenge.service;

import br.com.ilegra.challenge.model.Customer;
import br.com.ilegra.challenge.model.Item;
import br.com.ilegra.challenge.model.Sales;
import br.com.ilegra.challenge.model.Salesman;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class RecordParser {

    public static void mountSalesmanObject(String salesmanRecord, Set<Salesman> salesmanSet) {
        String[] splited = salesmanRecord.split("ç");
        Salesman salesman = new Salesman(splited[0], splited[1], splited[2], Double.valueOf(splited[3]));
        salesmanSet.add(salesman);
    }

    public static void mountCustomerObject(String customerRecord, Set<Customer> customerSet) {
        String[] splited = customerRecord.split("ç");
        Customer customer = new Customer(splited[0], splited[1], splited[2], splited[3]);
        customerSet.add(customer);
    }

    public static void mountSalesObject(String salesRecord, Set<Sales> salesSet) {

        String[] splited = salesRecord.split("ç");
        String[] itens = splited[2].replace("[", "")
                                   .replace("]", "")
                                   .trim().split(",");

        Set<Item> itemSet = new HashSet<Item>();

        Arrays.asList(itens).forEach(item -> {
            String[] finalSplit = item.split("-");
            itemSet.add(new Item(Integer.valueOf(finalSplit[0]), new BigDecimal(finalSplit[1]), new Double(finalSplit[1])));
        });

        Sales sales = new Sales(splited[0], splited[1], itemSet, new Salesman(null, splited[3]));
        salesSet.add(sales);
    }

}
