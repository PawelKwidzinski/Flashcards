package pl.kwidzinski.flashcards;

import java.util.*;

public class Flashcard {
    private Map<String, String> flashcards;
    private Map<String, Integer> mistakes;
    static ArrayList<String> log = new ArrayList<>();
    Scanner scanner;

    public Flashcard(Scanner scanner) {
        this.flashcards = new HashMap<>();
        this.mistakes = new HashMap<>();
        this.scanner = scanner;
    }

    public void add() {
        System.out.println("The card:");
        Flashcard.log.add("The card:");
        String term = scanner.nextLine();
        Flashcard.log.add(term);
        if (flashcards.containsKey(term)){
            System.out.printf("The card \"%s\" already exists.\n", term);
            Flashcard.log.add("The card \"" + term + "\" already exists.");
            return;
        }

        System.out.println("The definition of the card:");
        Flashcard.log.add("The definition of the card:");
        String definition = scanner.nextLine();
        Flashcard.log.add(definition);
        if (flashcards.containsValue(definition)){
            System.out.printf("The definition \"%s\" already exists.\n", definition);
            Flashcard.log.add("The definition \"" + definition + "\" already exists.");
            return;
        }

        flashcards.put(term, definition);
        mistakes.put(term,0);
        System.out.printf("The pair (\"%s\":\"%s\") has been added.\n", term, definition);
        Flashcard.log.add("The pair (\"" + term + "\":\"" + definition + "\") has been added.\n");
    }
}
