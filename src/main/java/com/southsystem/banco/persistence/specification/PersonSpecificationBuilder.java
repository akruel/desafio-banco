package com.southsystem.banco.persistence.specification;

import java.util.ArrayList;
import java.util.List;

import com.southsystem.banco.persistence.model.Person;

import org.springframework.data.jpa.domain.Specification;

public class PersonSpecificationBuilder<T extends Person> {
     
    private final List<SearchCriteria> params;
 
    public PersonSpecificationBuilder() {
        params = new ArrayList<SearchCriteria>();
    }
 
    public PersonSpecificationBuilder<T> with(String key, String operation, Object value) {
        params.add(new SearchCriteria(key, operation, value));
        return this;
    }
 
    public Specification<T> build() {
        if (params.size() == 0) {
            return null;
        }
 
        List<Specification<T>> specs = new ArrayList<Specification<T>>();
        for (SearchCriteria param : params) {
            specs.add(new PersonBaseSpecification<T>(param));
        }
         
        Specification<T> result = specs.get(0);
        for (int i = 1; i < specs.size(); i++) {
            result = Specification.where(result).and(specs.get(i));
        }
        return result;
    }
}