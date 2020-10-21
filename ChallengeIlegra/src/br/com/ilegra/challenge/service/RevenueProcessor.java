package br.com.ilegra.challenge.service;

import br.com.ilegra.challenge.model.Revenue;

import java.util.Collections;
import java.util.Comparator;
import java.util.Set;

public class RevenueProcessor<T> implements Revenue<T> {

    private T a;

    @Override
    public Long processAmount(Set<T> set) {
        return set.stream().count();
    }


    @Override
    public T evaluateObjectResult(Set<T> set, Enum anEnum) {
        return a;
    }
}
