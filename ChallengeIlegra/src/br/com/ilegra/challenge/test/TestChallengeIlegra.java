package br.com.ilegra.challenge.test;


import br.com.ilegra.challenge.model.Customer;
import br.com.ilegra.challenge.model.Revenue;
import br.com.ilegra.challenge.model.Salesman;
import br.com.ilegra.challenge.service.CustomerProcessor;
import br.com.ilegra.challenge.service.SalesmanProcessor;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.assertEquals;

public class TestChallengeIlegra {


    @Test
    public void mustProcessSalesmanAmount() {

        Set<Salesman> salesmanSet = new HashSet<Salesman>();

        Salesman salesman = new Salesman( "001", "Rodolfo", "10677061781", 150.50);
        Salesman salesman2 = new Salesman("001", "Ronaldo", "10204587542", 120.50);

        salesmanSet.add(salesman);
        salesmanSet.add(salesman2);

        Revenue<Salesman> revenueProcess =  new SalesmanProcessor();
        revenueProcess.processAmount(salesmanSet);

        assertEquals(2, revenueProcess.processAmount(salesmanSet).longValue());
    }

    @Test
    public void mustProcessCustomerAmount() {

        Set<Customer> customerSet = new HashSet<Customer>();

        Customer customer = new Customer("002", "Alexandre Silva", "4565465465421", "Tech");
        Customer customer2 = new Customer("002", "Marcio Freitas", "54675465465421", "Market");
        Customer customer3 = new Customer("002", "Fonseca Silva", "8798465465421", "Sales");
        Customer customer4 = new Customer("002", "Tatiana Ribeiro", "9182465465421", "Manager");

        customerSet.add(customer);
        customerSet.add(customer2);
        customerSet.add(customer3);
        customerSet.add(customer4);

        Revenue<Customer> customerProcessor =  new CustomerProcessor();
        customerProcessor.processAmount(customerSet);

        assertEquals(4, customerProcessor.processAmount(customerSet).longValue());
    }


}
