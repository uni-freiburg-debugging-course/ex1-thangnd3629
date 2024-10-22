package org.example;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        Fuzzer simpleFuzzer = new Fuzzer();
        System.out.println("FUZZER ------- Start generating statements");
        simpleFuzzer.writeBatchSeed(1000);
        System.out.println("FUZZER ------- 1000 statements generated");
    }
}