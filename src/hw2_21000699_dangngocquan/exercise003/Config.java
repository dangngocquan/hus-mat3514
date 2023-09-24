package hw2_21000699_dangngocquan.exercise003;

import javax.swing.*;
import java.awt.*;

public class Config {
    // Size
    public static int DEVICE_WIDTH = (int) (GraphicsEnvironment.getLocalGraphicsEnvironment()
            .getMaximumWindowBounds().getWidth());
    public static int DEVICE_HEIGHT = (int) ((GraphicsEnvironment.getLocalGraphicsEnvironment()
            .getMaximumWindowBounds().getHeight()));
    public static int WIDTH = DEVICE_WIDTH - 14;
    public static int HEIGHT = DEVICE_HEIGHT - 36;
    public static int HEIGHT_VIEW_CARDS = HEIGHT * 4 / 5;
    public static int CARD_SCALE = 3;
    public static int HEIGHT_OF_CARD = 725 / CARD_SCALE;
    public static int WIDTH_OF_CARD = 500 / CARD_SCALE / 4 * 4;

    // Initial location
    public static int INITIAL_Y_CARDS = 10;

    // Color
    public static Color COLOR_TEXT = new Color(20, 20, 20);
    public static Color BACKGROUND_COLOR_APP = new Color(255, 255, 255);
    public static Color BACKGROUND_COLOR_VIEW_CONTROLLER = new Color(176, 176, 176);
    public static Color BACKGROUND_AREA_SORTED_CARDS = new Color(172, 255, 162);

    // Font
    public static final Font ARIAL_BOLD_12 = new Font("Arial", Font.BOLD, 12);

    // Image
    public static ImageIcon[][] CARDS = null;
    public static String[] CARD_RANKS = new String[] {
        "2", "3", "4", "5", "6", "7", "8", "9", "10",
                "jack", "queen", "king", "ace"
    };

    public static String[] CARD_SUITS = new String[] {"spades", "clubs", "diamonds", "hearts"};

    // Speech
    public static int MILLISECONDS_PER_ACTION = 114;

    public Config() {
        try {
            CARDS = new ImageIcon[13][4];
            for (int i = 0; i < 13; i++) {
                for (int j = 0; j < 4; j++) {
                    String path = String.format("assets/images/%s_of_%s.png",
                            CARD_RANKS[i],
                            CARD_SUITS[j]);
                    CARDS[i][j] = new ImageIcon(this.getClass().getResource(path));
                }
            }
        } catch (Exception e) {
            System.out.println("Error when load images");
        }

    }
}