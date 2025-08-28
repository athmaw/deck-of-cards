import java.util.*;


public class Deck {
    private ArrayList<Card> cards;


    public Deck() {
        cards = new ArrayList<>();
    }


    public void createDeck() {
        cards.clear();
        String[] suits = {"Clubs", "Diamonds", "Hearts", "Spades"};
        String[] ranks = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "Ace", "Jack", "Queen", "King"};


        for (String suit : suits) {
            for (String rank : ranks) {
                cards.add(new Card(suit, rank));
            }
        }
        System.out.println("Deck created with 52 cards.");
    }


    public void shuffleDeck() {
        if (cards.isEmpty()) {
            System.out.println("Deck is empty! Create a deck first.");
        } else {
            Collections.shuffle(cards);
            System.out.println("Deck shuffled.");
        }
    }


    public void dealCards(int number) {
        if (cards.isEmpty()) {
            System.out.println("Deck is empty! Create a deck first.");
            return;
        }


        if (number > cards.size()) {
            System.out.println("Not enough cards in the deck. Only " + cards.size() + " remaining.");
            return;
        }


        System.out.println("Dealt Cards:");
        for (int i = 0; i < number; i++) {
            System.out.println(cards.remove(0));
        }
    }


    public void displayDeck() {
        if (cards.isEmpty()) {
            System.out.println("Deck is empty.");
        } else {
            System.out.println("Cards in deck:");
            for (Card card : cards) {
                System.out.println(card);
            }
            System.out.println("Total cards remaining: " + cards.size());
        }
    }
}