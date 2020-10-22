package br.com.ilegra.challenge.main;

import br.com.ilegra.challenge.model.*;
import br.com.ilegra.challenge.service.CustomerProcessor;
import br.com.ilegra.challenge.service.FileReaderIlegra;
import br.com.ilegra.challenge.service.SalesProcessor;
import br.com.ilegra.challenge.service.SalesmanProcessor;

import java.util.HashSet;
import java.util.Set;

public class Challenge {


    public static void main(String[] args) {

        Set<Sales> salesSet =  new HashSet<Sales>();
        Set<Salesman> salesmanSet =  new HashSet<Salesman>();
        Set<Customer> customerSet =  new HashSet<Customer>();

        FileReaderIlegra fileReaderIlegra = new FileReaderIlegra(salesSet,  customerSet, salesmanSet);
        fileReaderIlegra.readIn();
        fileReaderIlegra.parseRecordsToObject();


        Revenue<Salesman> salesmanProcessor = new SalesmanProcessor();
        System.out.println(salesmanProcessor.processAmount(salesmanSet));        ;

        Revenue<Customer> customerProcessor = new CustomerProcessor();
        System.out.println(customerProcessor.processAmount(customerSet));

        Revenue<Sales> salesMostProcesor = new SalesProcessor();
        System.out.println(salesMostProcesor.evaluateObjectResult(salesSet, OrderCriteria.MAX).getSaleId());

        Revenue<Sales> salesProcessor = new SalesProcessor();
        System.out.println(salesProcessor.evaluateObjectResult(salesSet, OrderCriteria.MIN).getSalesman().getName());


    }


}
