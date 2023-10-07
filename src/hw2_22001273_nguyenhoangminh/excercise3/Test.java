package hw2_22001273_nguyenhoangminh.excercise3;

public class Test {
    
    public static void main(String[] args) {

        // Create new deck 
        Deck deck = new Deck();
        deck.printDeck();

        // Shuffle deck
        deck.shuffle();
        System.out.println("----------------------------");
        deck.printDeck();

        // Sort deck using Comparator
        deck.sortComparator();
        System.out.println("After sorted");
        deck.printDeck();

        // Shuffle deck again
        deck.shuffle();
        System.out.println("----------------------------");
        deck.printDeck();

        // Sort deck using Comparable interface
        deck.sortComparable();
        System.out.println("After sorted");
        deck.printDeck();
    }
}
