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
        if (flashcards.containsKey(term)) {
            System.out.printf("The card \"%s\" already exists.\n", term);
            Flashcard.log.add("The card \"" + term + "\" already exists.");
            return;
        }

        System.out.println("The definition of the card:");
        Flashcard.log.add("The definition of the card:");
        String definition = scanner.nextLine();
        Flashcard.log.add(definition);
        if (flashcards.containsValue(definition)) {
            System.out.printf("The definition \"%s\" already exists.\n", definition);
            Flashcard.log.add("The definition \"" + definition + "\" already exists.");
            return;
        }

        flashcards.put(term, definition);
        mistakes.put(term, 0);
        System.out.printf("The pair (\"%s\":\"%s\") has been added.\n", term, definition);
        Flashcard.log.add("The pair (\"" + term + "\":\"" + definition + "\") has been added.\n");
    }

    public void ask() {
        System.out.println("How many times to ask?");
        Flashcard.log.add("How many times to ask?");
        int n = Integer.parseInt(scanner.nextLine());
        Flashcard.log.add(String.valueOf(n));
        String[] terms = new String[flashcards.keySet().size()];
        flashcards.keySet().toArray(terms);
        Random random = new Random();
        for (int i = 0; i < n; i++) {
            String term = terms[random.nextInt(terms.length)];

            System.out.printf("Print the definition of \"%s\":\n", term);
            Flashcard.log.add("Print the definition of \"" + term + "\":");
            String input = scanner.nextLine();
            Flashcard.log.add(input);

            if (input.equals(flashcards.get(term))) {
                System.out.println("Correct answer.");
                Flashcard.log.add("Correct answer.");
            } else if (flashcards.containsValue(input)) {
                String otherTerm = "";
                for (String s : flashcards.keySet()) {
                    if (flashcards.get(s).equals(input)) {
                        otherTerm = s;
                    }
                }
                System.out.printf("Wrong answer. The correct one is \"%s\",", flashcards.get(term));
                System.out.printf("you've just written the definition of \"%s\".\n", otherTerm);
                Flashcard.log.add("Wrong answer. The correct one is \"" + flashcards.get(term) +
                        "\",you've just written the definition of \"" + otherTerm + "\".");
                mistakes.replace(term, mistakes.get(term) + 1);
            } else {
                System.out.printf("Wrong answer. The correct one is \"%s\".\n", flashcards.get(term));
                Flashcard.log.add("Wrong answer. The correct one is \"" + flashcards.get(term) + "\".");
                mistakes.replace(term, mistakes.get(term) + 1);
            }
        }
    }

    public void remove() {
        System.out.println("The card:");
        Flashcard.log.add("The card:");
        String term = scanner.nextLine();
        if (flashcards.containsKey(term)) {
            flashcards.remove(term);
            mistakes.remove(term);
            System.out.println("The card has been removed.");
            Flashcard.log.add("The card has been removed.");
        } else {
            System.out.printf("Can't remove \"%s\": there is no such card.", term);
            Flashcard.log.add("Can't remove \"" + term + "\": there is no such card.");
        }
    }
}
