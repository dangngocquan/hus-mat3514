package hw2_22001273_nguyenhoangminh.excercise3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Random;

public class Deck {
    // Instance Variables
    Card[] deck = new Card[52];;
    final String[] SUIT_LIST = {"Bich", "Tep", "Ro", "Co"};
    final String[] RANK_LIST = {"At", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K"};

    // Constructor
    public Deck() {
        int Idx = 0; 
        for (String s : SUIT_LIST) {
            for (String r : RANK_LIST) {
                deck[Idx] = new Card(s, r);
                Idx++;
            }
        } 
    }

    // Get method
    public Card[] getDeck() { return deck; }

    // Print deck
    public void printDeck() {
        for (int  i=0; i<52; ++i) {
            System.out.print(deck[i].toString() + "; ");
        }
    }

    // Shuffle Deck
    public void shuffle() {
        Random rnd = new Random();
        for (int i = deck.length - 1; i > 0; i--){
            int index = rnd.nextInt(i + 1);
            // Simple swap
            Card a = deck[index];
            deck[index] = deck[i];
            deck[i] = a;
        }
    }

    // Sort deck using Comparator
    public void sortComparator() {
        // Create measurements mapping
        final List<String> RANK_MEASURE = new ArrayList<String>();
        for (String i : RANK_LIST) { RANK_MEASURE.add(i); }
        
        final List<String> SUIT_MEASURE = new ArrayList<String>();
        for (String i : SUIT_LIST) { SUIT_MEASURE.add(i); }

        Comparator<Card> comparecard = new Comparator<Card>() {
            @Override
            // Based on measurements mapping to compare
            public int compare(Card c1, Card c2) {
                if(SUIT_MEASURE.indexOf(c1.suit) != SUIT_MEASURE.indexOf(c2.suit)) {
                    return SUIT_MEASURE.indexOf(c1.suit) - SUIT_MEASURE.indexOf(c2.suit);
                } else {
                    return RANK_MEASURE.indexOf(c1.rank) - RANK_MEASURE.indexOf(c2.rank);
                }
            }
        };
        Arrays.sort(deck, comparecard);
    }

    // Swap vi tri hai la bai 
    public void swap(Card[] deck, int i,int j) {
        Card temp = deck[i];
        deck[i] = deck[j];
        deck[j] = temp;
    }
    // Sort deck using Comparable va thuat toan bubbleSort
    public void sortComparable() {
        for (int i=0; i<52; i++) {
            boolean is_sorted = true;
            for(int j=1; j<52-i; j++) {
                if (deck[j-1].compareTo(deck[j])>0) {
                    swap(deck, j, j-1);
                    is_sorted = false;
                } 
            }
            if(is_sorted) return;
        }
    }
    
}
