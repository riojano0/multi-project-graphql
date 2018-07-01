package com.montivero.poc.datafetcher;

import com.montivero.poc.domain.Alignment;
import com.montivero.poc.domain.Character;
import com.montivero.poc.domain.ClassType;
import com.montivero.poc.domain.Race;
import graphql.schema.DataFetcher;
import graphql.schema.DataFetchingEnvironment;
import org.apache.commons.lang3.EnumUtils;
import org.apache.commons.lang3.StringUtils;

public class CharacterMutationDataFetcher implements DataFetcher<Character> {
    @Override
    public Character get(DataFetchingEnvironment environment) {
        String name = environment.getArgument("name");
        ClassType classType = EnumUtils.getEnum(ClassType.class, StringUtils.upperCase(environment.getArgument("classType")));
        Race race = EnumUtils.getEnum(Race.class, StringUtils.upperCase(environment.getArgument("race")));
        Alignment alignment = EnumUtils.getEnum(Alignment.class, StringUtils.upperCase(environment.getArgument("alignment")));
        int strength = environment.getArgument("strength");
        int agility = environment.getArgument("agility");
        int constitution = environment.getArgument("constitution");
        int intelligence = environment.getArgument("intelligence");
        int charisma = environment.getArgument("charisma");

        return Character.builder()
                .experience(0L)
                .level(1)
                .name(name)
                .race(race)
                .classType(classType)
                .alignment(alignment)
                .strength(strength)
                .agility(agility)
                .constitution(constitution)
                .intelligence(intelligence)
                .charisma(charisma)
                .build();
    }
}
