package hw2_21000699_dangngocquan.exercise003.models;

import hw2_21000699_dangngocquan.exercise003.Config;

import javax.swing.*;

public class Card implements Comparable<Card> {
    private int rank;
    private int suit;
    private String rankName;
    private String suitName;
    private ImageIcon image;

    public Card(int rank, int suit, String rankName, String suitName) {
        this.rank = rank;
        this.suit = suit;
        this.rankName = rankName;
        this.suitName = suitName;
        this.image = Config.CARDS[rank][suit];
    }

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    public int getSuit() {
        return suit;
    }

    public void setSuit(int suit) {
        this.suit = suit;
    }

    public String getRankName() {
        return rankName;
    }

    public void setRankName(String rankName) {
        this.rankName = rankName;
    }

    public String getSuitName() {
        return suitName;
    }

    public void setSuitName(String suitName) {
        this.suitName = suitName;
    }

    public ImageIcon getImage() {
        return image;
    }

    public void setImage(ImageIcon image) {
        this.image = image;
    }

    @Override
    public int compareTo(Card o) {
        return this.getRank() * 4 + this.getSuit() - o.getRank() * 4 - o.getSuit();
    }

    @Override
    public String toString() {
        return "Card{" +
                "rank=" + rank +
                ", suit=" + suit +
                ", rankName='" + rankName + '\'' +
                ", suitName='" + suitName + '\'' +
                '}';
    }
}
