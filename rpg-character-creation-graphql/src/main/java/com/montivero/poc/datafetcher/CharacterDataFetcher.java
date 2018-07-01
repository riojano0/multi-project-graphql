package com.montivero.poc.datafetcher;

import com.montivero.poc.domain.Alignment;
import com.montivero.poc.domain.Character;
import com.montivero.poc.domain.ClassType;
import com.montivero.poc.domain.Race;
import graphql.schema.DataFetcher;
import graphql.schema.DataFetchingEnvironment;

import java.util.ArrayList;
import java.util.List;

public class CharacterDataFetcher implements DataFetcher<Character> {

    @Override
    public Character get(DataFetchingEnvironment environment) {
        Character character0 = Character.builder()
                .id(0L)
                .name("testName0")
                .race(Race.TROLL)
                .classType(ClassType.ROGUE)
                .alignment(Alignment.EVIL)
                .agility(20)
                .build();
        Character character1 = Character.builder()
                .id(1L)
                .name("testName0")
                .race(Race.HUMAN)
                .classType(ClassType.WARRIOR)
                .alignment(Alignment.GOOD)
                .strength(20)
                .build();
        List<Character> characterList = new ArrayList<>();
        characterList.add(character0);
        characterList.add(character1);
        int id = Integer.parseInt(environment.getArgument("id"));
        return characterList.get(id);
    }
}
