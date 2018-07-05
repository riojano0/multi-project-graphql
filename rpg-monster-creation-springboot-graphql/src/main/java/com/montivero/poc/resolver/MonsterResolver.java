package com.montivero.poc.resolver;

import com.coxautodev.graphql.tools.GraphQLResolver;
import com.montivero.poc.domain.Detail;
import com.montivero.poc.domain.Monster;

public class MonsterResolver implements GraphQLResolver<Monster> {

    public Detail getDetail(Monster monster) {
        return Detail.builder()
                .live(900)
                .debility("The PullRequest")
                .build();
    }

}
