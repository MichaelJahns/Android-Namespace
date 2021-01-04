package com.michaeljahns.namespace.grammy;

import com.almasb.grammy.Grammar;
import com.almasb.grammy.Grammy;

public class Tracery {

    public static String flattenJSON(String Json) {
        Grammar grammar = Grammy.createGrammar(Json);
        String output = grammar.flatten("origin");
        return output;
    }

}
