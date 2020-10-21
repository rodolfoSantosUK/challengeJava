package br.com.ilegra.challenge.service;

import br.com.ilegra.challenge.model.Sales;

import java.util.Comparator;
import java.util.Optional;
import java.util.Set;

public class SalesProcessor extends RevenueProcessor<Sales> {

    @Override
    public Sales evaluateObjectResult(Set<Sales> set) {

        Sales sales = null;
        Optional maxSale = set.stream().max(Comparator.comparing(Sales::getSalesAmount));

        if (maxSale.isPresent()) {
            sales = (Sales) maxSale.get();
        }

        return sales;
    }


    public SalesProcessor() {

    }
}
