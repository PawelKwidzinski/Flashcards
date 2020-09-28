package pl.kwidzinski.flashcards;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Flashcard flashcard = new Flashcard(scanner);

        flashcard.add();


    }
}