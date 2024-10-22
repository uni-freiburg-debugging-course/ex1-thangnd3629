package org.example;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {


    public static void main(String[] args) throws IOException {

        Tokenizer tokenizer = new Tokenizer();
        Parser parser = new Parser();
        List<String> stmts = new FileReader().readFileFromResources("simp.smt2");

        stmts.forEach(stmt -> {
            List<Token> tokens = tokenizer.tokenize(stmt);
            ASTTree tree = parser.parse(tokens);
            System.out.println(tree.eval());
        });




    }
}