package com.montivero.poc.datafetcher;

import com.montivero.poc.domain.Character;
import graphql.schema.DataFetcher;
import graphql.schema.DataFetchingEnvironment;

import java.util.ArrayList;
import java.util.List;

public class CharacterFetcher implements DataFetcher<Character> {

    @Override
    public Character get(DataFetchingEnvironment environment) {
        Character character0 = new Character(0L, "testName0", "testJob0");
        Character character1 = new Character(1L, "testName1", "testJob1");
        List<Character> characterList = new ArrayList<>();
        characterList.add(character0);
        characterList.add(character1);
        int id = Integer.parseInt(environment.getArgument("id"));
        return characterList.get(id);
    }
}
