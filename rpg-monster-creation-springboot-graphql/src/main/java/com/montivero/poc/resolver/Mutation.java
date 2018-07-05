package com.montivero.poc.resolver;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.montivero.poc.domain.Monster;

public class Mutation implements GraphQLMutationResolver {

    public Monster createNewMonster(String name){
        return Monster.builder().name(name).build();
    }

}
