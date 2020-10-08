package pl.kwidzinski.flashcards;

import java.util.Scanner;

public class Main {
    //private static String path = "C:\\NewGitProjects\\Flashcards-app\\src\\main\\resources\\test1.txt";
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Flashcard flashcard = new Flashcard(scanner);

        flashcard.add();
        //flashcard.ask();
        //flashcard.remove();
        //flashcard.exportCards(path);




    }
}