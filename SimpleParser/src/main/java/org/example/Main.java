package org.example;

import java.util.List;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {


    public static void main(String[] args) {

        // Create a Scanner object to get input from stdin
        Scanner scanner = new Scanner(System.in);

        // Prompt user for input
        System.out.println("Enter the string to tokenize:");
        String input = scanner.nextLine();


        Tokenizer tokenizer = new Tokenizer();
        List<Token> tokens = tokenizer.tokenize(input);

        System.out.println(tokens);
        ASTTree tree = new Parser().parse(tokens);

        System.out.println(tree.eval());

    }
}