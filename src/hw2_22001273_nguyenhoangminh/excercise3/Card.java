package hw2_22001273_nguyenhoangminh.excercise3;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class Card implements Comparable<Card> {
    // Instance Variables
    final String[] RANK_LIST = {"At", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K"};
    final String[] SUIT_LIST = {"Bich", "Tep", "Ro", "Co"};
    String suit;
    String rank;
    public ImageIcon img;

    // Constructor
    public Card(String suit, String rank) {
        this.suit = suit;
        this.rank = rank;
        img = new ImageIcon("excercise3/images/"+suit+" "+rank+".png");
    }

    public String toString() {
        return "(" + rank + " " + suit + ")";
    }

    // Get methods
    public String getRank() { return rank; }
    public String getSuit() { return suit; }

    @Override
    public int compareTo(Card card) {
        // Create measurements mapping
        List<String> RANK_MEASURE = new ArrayList<String>();
        for (String i : RANK_LIST) { RANK_MEASURE.add(i); }
            
        List<String> SUIT_MEASURE = new ArrayList<String>();
        for (String i : SUIT_LIST) { SUIT_MEASURE.add(i); }
        
        if(SUIT_MEASURE.indexOf(this.suit) != SUIT_MEASURE.indexOf(card.suit)) {
            return SUIT_MEASURE.indexOf(this.suit) - SUIT_MEASURE.indexOf(card.suit);
        } else {
            return RANK_MEASURE.indexOf(this.rank) - RANK_MEASURE.indexOf(card.rank);
        }
    }
}
