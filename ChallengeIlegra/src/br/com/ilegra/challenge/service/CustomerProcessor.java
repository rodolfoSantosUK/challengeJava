package br.com.ilegra.challenge.service;

import br.com.ilegra.challenge.model.Customer;

import java.util.Set;

public class CustomerProcessor extends RevenueProcessor<Customer> {


    @Override
    public Long processAmount(Set<Customer> set) {
        return super.processAmount(set);
    }

    public CustomerProcessor() {

    }
}
