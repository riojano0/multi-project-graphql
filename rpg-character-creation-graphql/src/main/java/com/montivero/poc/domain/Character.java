package com.montivero.poc.domain;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Character {

    private Long id;
    private Long experience;
    private int level;
    private String name;
    private Race race;
    private ClassType classType;
    private Alignment alignment;
    private int strength;
    private int agility;
    private int constitution;
    private int intelligence;
    private int charisma;

}
