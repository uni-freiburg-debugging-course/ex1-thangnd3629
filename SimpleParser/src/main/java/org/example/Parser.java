package org.example;

import java.util.List;

public class Parser {
    private static List<TokenType> supportedBinOps = List.of(TokenType.BIN_MUL, TokenType.BIN_DIV, TokenType.BIN_ADD, TokenType.BIN_SUB);

    public ASTTree parse(List<Token> tokens) {
        if (tokens.isEmpty()) return null;
        Token curToken = tokens.remove(0);
        if (curToken.getTokenType().equals(TokenType.OPEN_PARENTHESIS)) {
            Token operator = tokens.remove(0);

            if (operator.getTokenType().equals(TokenType.FUNCTION_CALL)) {
                return ASTTree.builder()
                        .root(operator)
                        .left(parse(tokens))
                        .build();
            } else if (
                    supportedBinOps.contains(operator.getTokenType())

            ) {
                ASTTree leftSubtree = parse(tokens);
                ASTTree rightSubtree = parse(tokens);
                tokens.remove(0); // clean up close paren
                return ASTTree.builder()
                        .root(operator)
                        .left(leftSubtree)
                        .right(rightSubtree)
                        .build();
            } else {
                throw new RuntimeException("Unknown operator / keyword / function call ");
            }
        } else {
            return ASTTree.builder()
                    .root(curToken)
                    .build();
        }


    }


}
