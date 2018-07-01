package com.montivero.poc;

import com.montivero.poc.domain.Character;
import com.montivero.poc.datafetcher.CharacterFetcher;
import com.montivero.poc.datafetcher.CharacterMutation;
import com.montivero.poc.datafetcher.CharactersFetcher;
import graphql.ExecutionResult;
import graphql.GraphQL;
import graphql.schema.DataFetcher;
import graphql.schema.GraphQLSchema;
import graphql.schema.idl.RuntimeWiring;
import graphql.schema.idl.SchemaGenerator;
import graphql.schema.idl.SchemaParser;
import graphql.schema.idl.TypeDefinitionRegistry;

import java.io.File;
import java.util.List;

import static graphql.schema.idl.RuntimeWiring.newRuntimeWiring;

public class RpgCharacterCreationGraphQL {

    public static void main(String[] args) {
        SchemaParser schemaParser = new SchemaParser();
        SchemaGenerator schemaGenerator = new SchemaGenerator();
        ClassLoader classLoader = ClassLoader.getSystemClassLoader();
        File schemaFile = new File(classLoader.getResource("schema/character.graphqls").getFile());
        TypeDefinitionRegistry typeRegistry = schemaParser.parse(schemaFile);
        DataFetcher<Character> characterDataFetcher = new CharacterFetcher();
        DataFetcher<List<Character>> charactersDataFetcher = new CharactersFetcher();
        DataFetcher<Character> mutationDataFecher = new CharacterMutation();

        RuntimeWiring wiring = newRuntimeWiring()
                .type("QueryType", builder ->
                        builder
                                .dataFetcher("characters", charactersDataFetcher)
                                .dataFetcher("character", characterDataFetcher)
                )
                .type("Mutation", builder ->
                        builder
                                .dataFetcher("createCharacter", mutationDataFecher)
                )
                .build();

        GraphQLSchema graphQLSchema = schemaGenerator.makeExecutableSchema(typeRegistry, wiring);

        GraphQL build = GraphQL.newGraphQL(graphQLSchema).build();
        ExecutionResult executionResult = build.execute("{characters { job}}");
        System.out.println(executionResult.getData().toString());
        executionResult = build.execute("{character(id: 1) {name, job}}");
        System.out.println(executionResult.getData().toString());
        executionResult = build.execute("mutation createCharacter{createCharacter(name: \"MutaName\", job: \"MutaJob\"){name, job}}");
        System.out.println(executionResult.getData().toString());
    }

}
