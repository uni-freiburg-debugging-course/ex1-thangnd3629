package org.example;

import java.io.IOException;
import java.util.List;

public class Main {


    public static void main(String[] args) throws IOException {

        Tokenizer tokenizer = new Tokenizer();
        Parser parser = new Parser();
        List<String> stmts = new FileReader().readFile("./seed.txt");

        stmts.forEach(stmt -> {
            List<Token> tokens = tokenizer.tokenize(stmt);
            ASTTree tree = parser.parse(tokens);
            System.out.println(tree.eval());
        });




    }
}