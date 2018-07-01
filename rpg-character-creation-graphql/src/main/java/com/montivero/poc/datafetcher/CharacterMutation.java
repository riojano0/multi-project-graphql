package com.montivero.poc.datafetcher;

import com.montivero.poc.domain.Character;
import graphql.schema.DataFetcher;
import graphql.schema.DataFetchingEnvironment;

public class CharacterMutation implements DataFetcher<Character> {
    @Override
    public Character get(DataFetchingEnvironment environment) {
        String name = environment.getArgument("name");
        String job = environment.getArgument("job");
        return new Character(99L, name, job);
    }
}
