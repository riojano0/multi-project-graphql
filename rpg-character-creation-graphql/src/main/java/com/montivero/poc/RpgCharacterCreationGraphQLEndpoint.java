package com.montivero.poc;

import graphql.servlet.SimpleGraphQLServlet;

import javax.servlet.annotation.WebServlet;

@WebServlet(urlPatterns = "/")
public class RpgCharacterCreationGraphQLEndpoint extends SimpleGraphQLServlet {

    public RpgCharacterCreationGraphQLEndpoint() {
        super(new RpgCharacterCreationGraphQLSchema().getSchemaSimpleGraphQLServletBuilder());
    }

}
