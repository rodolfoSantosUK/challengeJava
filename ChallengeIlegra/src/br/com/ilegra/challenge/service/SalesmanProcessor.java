package br.com.ilegra.challenge.service;

import br.com.ilegra.challenge.model.Salesman;

import java.util.Set;

public class SalesmanProcessor  extends  RevenueProcessor<Salesman> {

    @Override
    public Long processAmount(Set<Salesman> set) {
        return super.processAmount(set);
    }


    public SalesmanProcessor() {
    }


}

