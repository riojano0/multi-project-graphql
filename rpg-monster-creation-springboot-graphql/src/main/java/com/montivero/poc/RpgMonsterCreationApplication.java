package com.montivero.poc;

import com.montivero.poc.resolver.MonsterResolver;
import com.montivero.poc.resolver.Mutation;
import com.montivero.poc.resolver.Query;
import graphql.Scalars;
import graphql.schema.GraphQLObjectType;
import graphql.schema.GraphQLSchema;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class RpgMonsterCreationApplication {

    public static void main(String[] args) {
        SpringApplication.run(RpgMonsterCreationApplication.class, args);
    }

    @Bean
    public Query query() {
        return new Query();
    }

    @Bean
    public MonsterResolver monsterResolver() {
        return new MonsterResolver();
    }

    @Bean
    public Mutation mutation() {
        return new Mutation();
    }

}
