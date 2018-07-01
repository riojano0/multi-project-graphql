package com.montivero.poc;

import com.montivero.poc.datafetcher.CharacterDataFetcher;
import com.montivero.poc.datafetcher.CharacterMutationDataFetcher;
import com.montivero.poc.datafetcher.CharactersDataFetcher;
import com.montivero.poc.domain.Character;
import graphql.schema.DataFetcher;
import graphql.schema.GraphQLSchema;
import graphql.schema.idl.RuntimeWiring;
import graphql.schema.idl.SchemaGenerator;
import graphql.schema.idl.SchemaParser;
import graphql.schema.idl.TypeDefinitionRegistry;
import graphql.servlet.SimpleGraphQLServlet;

import java.io.File;
import java.util.List;
import java.util.Objects;
import java.util.logging.Logger;

import static graphql.schema.idl.RuntimeWiring.newRuntimeWiring;

public class RpgCharacterCreationGraphQLSchema {

    private static final String SCHEMA_CHARACTER_GRAPHQLS = "schema/character.graphqls";

    public SimpleGraphQLServlet.Builder getSchemaSimpleGraphQLServletBuilder() {
        return new SimpleGraphQLServlet.Builder(getSchema());
    }

    private GraphQLSchema getSchema() {
        SchemaParser schemaParser = new SchemaParser();
        SchemaGenerator schemaGenerator = new SchemaGenerator();
        ClassLoader classLoader = getClass().getClassLoader();
        File schemaFile = new File(Objects.requireNonNull(classLoader.getResource(SCHEMA_CHARACTER_GRAPHQLS)).getFile());

        TypeDefinitionRegistry typeRegistry = schemaParser.parse(schemaFile);
        DataFetcher<Character> characterDataFetcher = new CharacterDataFetcher();
        DataFetcher<List<Character>> charactersDataFetcher = new CharactersDataFetcher();
        DataFetcher<Character> characterMutationDataFetcher = new CharacterMutationDataFetcher();

        RuntimeWiring wiring = newRuntimeWiring()
                .type("QueryType", builder ->
                        builder
                                .dataFetcher("characters", charactersDataFetcher)
                                .dataFetcher("character", characterDataFetcher)
                )
                .type("MutationType", builder ->
                        builder
                                .dataFetcher("createCharacter", characterMutationDataFetcher)
                )
                .build();

        return schemaGenerator.makeExecutableSchema(typeRegistry, wiring);
    }

}
