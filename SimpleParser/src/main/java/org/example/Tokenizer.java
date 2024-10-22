package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.*;

import org.apache.commons.lang3.StringUtils;

public class Tokenizer {

    public List<Token> tokenize(String input) {
        List<Token> tokens = new ArrayList<>();
        List<String> splittedInput = new ArrayList<>();
        // split +,-,*,/,(,) and alphanumeric block ( function call, keyword, string literal, or number literal )

        String rule = "(\\+|\\-|\\*|\\/|\\(|\\)|\\w+)";

        Pattern pattern = Pattern.compile(rule);

        /*
            ( + simplify ( + 2 5 ) )

         */
        Matcher matcher = pattern.matcher(input);


        while (matcher.find()) {
            splittedInput.add(matcher.group());
        }


        for (String tokenStrVal : splittedInput) {
            String value = tokenStrVal;
            TokenType type = null;
            if (StringUtils.isNumeric(tokenStrVal)) {
                type = TokenType.NUMBER;
            } else {
                switch (tokenStrVal) {
                    case Constants.ADD_SIGN:
                        type = TokenType.BIN_ADD;
                        break;
                    case Constants.SUB_SIGN:
                        type = TokenType.BIN_SUB;
                        break;
                    case Constants.MUL_SIGN:
                        type = TokenType.BIN_MUL;
                        break;
                    case Constants.DIV_SIGN:
                        type = TokenType.BIN_DIV;
                        break;
                    case Constants.OPEN_PAR:
                        type = TokenType.OPEN_PARENTHESIS;
                        break;
                    case Constants.CLOSE_PAR:
                        type = TokenType.CLOSE_PARENTHESIS;
                        break;
                    case Constants.SIMPLIFY_FUNCTION_CALL:
                        type = TokenType.FUNCTION_CALL;
                        break;

                }
            }

            tokens.add(Token.builder().value(value).tokenType(type).build());

        }


        return tokens;


    }

}
