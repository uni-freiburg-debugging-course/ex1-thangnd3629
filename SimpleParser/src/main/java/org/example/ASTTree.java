package org.example;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
class ASTTree {
    Token root;
    ASTTree left;
    ASTTree right;


    public Integer eval() {
        if (this.root.getTokenType().equals(TokenType.NUMBER)) {
            return Integer.parseInt(this.getRoot().getValue());
        }
        switch (root.getTokenType()) {
            case BIN_ADD -> {
                return left.eval() + right.eval();
            }
            case BIN_SUB -> {
                return left.eval() - right.eval();
            }
            case BIN_DIV -> {
                return left.eval() / right.eval();
            }
            case BIN_MUL -> {
                return left.eval() * right.eval();
            }
            case FUNCTION_CALL -> {
                System.out.println(String.format("Function called with argument %s", left.eval()));
                // assuming that this is a no-op function
                return left.eval();

            }

        }
        return 0;


    }


}