package hw2_22001273_nguyenhoangminh.excercise3.visual;

import hw2_22001273_nguyenhoangminh.excercise3.Deck;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main extends Deck implements ActionListener{
    // Variables
    JFrame f;
    JPanel deckDisp;
    JPanel buttonDisp;
    JButton shuffle, sort;
    Deck deck;
    public Main() {
        
        f = new JFrame("Card Sorting Simulator");

        deckDisp = new JPanel(new GridLayout(4, 13,10,10));

        buttonDisp = new JPanel(new GridLayout(1,2));

        shuffle = new JButton("Shuffle");
        shuffle.addActionListener(this);
        buttonDisp.add(shuffle);

        sort = new JButton("Sort");
        sort.addActionListener(this);
        buttonDisp.add(sort);

        deck = new Deck();

        for (int i=0; i<deck.getDeck().length; ++i) {
            deckDisp.add(new JLabel(deck.getDeck()[i].img));
        }

        f.add(buttonDisp,BorderLayout.CENTER);
        f.add(deckDisp, BorderLayout.NORTH);
        f.setSize(1378,768);
        f.setVisible(true);
    } 
    
    
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==shuffle) {
            deckDisp.removeAll();
            deck.shuffle();
            for (int i=0; i<deck.getDeck().length; ++i) {
                deckDisp.add(new JLabel(deck.getDeck()[i].img));
            }
            deckDisp.revalidate();
            deckDisp.repaint();
        }else if (e.getSource()==sort) {
            deckDisp.removeAll();
            deck.sortComparable();
            for (int i=0; i<deck.getDeck().length;++i) {
                deckDisp.add(new JLabel(deck.getDeck()[i].img));
            }
            deckDisp.revalidate();
            deckDisp.repaint();
        }
    }
}
