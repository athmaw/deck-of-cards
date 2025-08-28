import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Deck deck = new Deck();
        int choice;


        do {
            System.out.println("\n--- Menu ---");
            System.out.println("1. Create Deck");
            System.out.println("2. Shuffle Deck");
            System.out.println("3. Deal Cards");
            System.out.println("4. Display Deck");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");


            while (!sc.hasNextInt()) {
                System.out.print("Invalid input! Enter a number from 1-5: ");
                sc.next();
            }
            choice = sc.nextInt();


            switch (choice) {
                case 1:
                    deck.createDeck();
                    break;
                case 2:
                    deck.shuffleDeck();
                    break;
                case 3:
                    System.out.print("How many cards to deal? ");
                    while (!sc.hasNextInt()) {
                        System.out.print("Invalid input! Enter a valid number: ");
                        sc.next();
                    }
                    int num = sc.nextInt();
                    deck.dealCards(num);
                    break;
                case 4:
                    deck.displayDeck();
                    break;
                case 5:
                    System.out.println("Exiting program. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        } while (choice != 5);


        sc.close();
    }
}