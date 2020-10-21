package br.com.ilegra.challenge.service;

import br.com.ilegra.challenge.model.OrderCriteria;
import br.com.ilegra.challenge.model.Sales;

import java.util.Comparator;
import java.util.Optional;
import java.util.Set;

public class SalesProcessor extends RevenueProcessor<Sales> {

    @Override
    public Sales evaluateObjectResult(Set<Sales> set, Enum anEnum) {

        Sales sales = null;
        if (anEnum == OrderCriteria.MAX) {

            Optional optional = set.stream().max(Comparator.comparing(Sales::getSalesAmount));
            if (optional.isPresent()) {
                sales = (Sales) optional.get();
            }

        } else if (anEnum == OrderCriteria.MIN) {

            Optional optional = set.stream().min(Comparator.comparing(Sales::getSalesAmount));
            if (optional.isPresent()) {
                sales = (Sales) optional.get();
            }
        }

        return sales;
    }


    public SalesProcessor() {

    }
}
