package br.com.ilegra.challenge.model;

import java.util.Set;

public interface Revenue<T> {

     default Long processAmount(Set<T> set){ return Long.MIN_VALUE; }
     default T evaluateObjectResult(Set<T> set) {  return null ; }

}
