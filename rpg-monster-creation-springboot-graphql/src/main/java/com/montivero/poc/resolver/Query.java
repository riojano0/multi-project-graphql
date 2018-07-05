package com.montivero.poc.resolver;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.montivero.poc.domain.Monster;

import java.util.ArrayList;
import java.util.List;

public class Query implements GraphQLQueryResolver {

    public List<Monster> monsters(){
        List<Monster> monsters = new ArrayList<>();
        monsters.add(Monster.builder().name("mon01").build());
        monsters.add(Monster.builder().name("mon02").build());
        return monsters;
    }

}
