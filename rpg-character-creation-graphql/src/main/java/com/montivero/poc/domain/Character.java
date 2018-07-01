package com.montivero.poc.domain;

public class Character {

    private Long id ;
    private String name;
    private String job;

    public Character(Long id, String name, String job) {
        this.id = id;
        this.name = name;
        this.job = job;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getJob() {
        return job;
    }
}
