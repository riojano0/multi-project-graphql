package com.montivero.poc.datafetcher;

import com.montivero.poc.domain.Character;
import graphql.schema.DataFetcher;
import graphql.schema.DataFetchingEnvironment;

import java.util.ArrayList;
import java.util.List;

public class CharactersFetcher implements DataFetcher<List<Character>> {
    @Override
    public List<Character> get(DataFetchingEnvironment environment) {
        Character character0 = new Character(0L, "testName0", "testJob0");
        Character character1 = new Character(1L, "testName1", "testJob1");
        List<Character> characterList = new ArrayList<>();
        characterList.add(character0);
        characterList.add(character1);
        return characterList;
    }
}
