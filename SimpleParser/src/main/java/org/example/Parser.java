package org.example;

import java.util.List;

public class Parser {
    public ASTTree parse(List<Token> tokens) {
        if (tokens.isEmpty()) return null;
        Token curToken = tokens.remove(0);
        if (curToken.getTokenType().equals(TokenType.OPEN_PARENTHESIS)) {
            Token operator = tokens.remove(0);
            ASTTree leftSubtree = parse(tokens);
            ASTTree rightSubtree = parse(tokens);
            tokens.remove(0); // clean up close paren
            return ASTTree.builder()
                    .root(operator)
                    .left(leftSubtree)
                    .right(rightSubtree)
                    .build();


        }
        if (curToken.getTokenType().equals(TokenType.FUNCTION_CALL)){ // only support single argument functioncall =))
            return ASTTree.builder()
                    .root(curToken)
                    .left(parse(tokens))
                    .build();
        }
        else {
            return ASTTree.builder()
                    .root(curToken)
                    .build();
        }


    }





}
