package com.montivero.poc.domain;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Monster {

    private Long id;
    private int level;
    private String name;
    private Race race;
    private int strength;
    private int agility;
    private int constitution;
    private int intelligence;
    private int charisma;
    private Detail detail;

}
