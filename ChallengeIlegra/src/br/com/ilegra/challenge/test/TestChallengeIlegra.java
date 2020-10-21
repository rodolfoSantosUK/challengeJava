package br.com.ilegra.challenge.test;


import br.com.ilegra.challenge.model.Revenue;
import br.com.ilegra.challenge.model.Salesman;
import br.com.ilegra.challenge.service.SalesmanProcessor;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.assertEquals;

public class TestChallengeIlegra {


    @Test
    public void mustProcessSalesmanAmount() {

        Set<Salesman> salesmanSet = new HashSet<Salesman>();

        Salesman salesman = new Salesman("001", "Rodolfo", "10677061781", 150.50);
        Salesman salesman2 = new Salesman("001", "Ronaldo", "10204587542", 120.50);

        salesmanSet.add(salesman);
        salesmanSet.add(salesman2);

        Revenue<Salesman> revenueProcess =  new SalesmanProcessor();
        revenueProcess.processAmount(salesmanSet);

        assertEquals(2, revenueProcess.processAmount(salesmanSet).longValue());
    }


}
