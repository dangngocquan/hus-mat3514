package hw1_21000699_dangngocquan.exercise006.p2dot32;

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
    public static int HEIGHT_CONTROLLER_VIEW_COMPONENT = HEIGHT;
    public static int WIDTH_CONTROLLER_VIEW_COMPONENT = WIDTH / 4;
    public static int HEIGHT_ECOSYSTEM_VIEW_COMPONENT = HEIGHT_CONTROLLER_VIEW_COMPONENT;
    public static int WIDTH_ECOSYSTEM_VIEW_COMPONENT = WIDTH - WIDTH_CONTROLLER_VIEW_COMPONENT;
    public static int HEIGHT_ECOSYSTEM_TABLE = HEIGHT_ECOSYSTEM_VIEW_COMPONENT - 20;
    public static int WIDTH_ECOSYSTEM_TABLE = HEIGHT_ECOSYSTEM_TABLE;


    // Color
    public static Color COLOR_TEXT = new Color(20, 20, 20);
    public static Color BACKGROUND_COLOR_APP = new Color(255, 255, 255);
    public static Color BACKGROUND_COLOR_CONTROLLER_VIEW = new Color(244, 229, 255);
    public static Color BACKGROUND_COLOR_ECOSYSTEM_VIEW = new Color(255, 255, 255);
    public static Color BACKGROUND_COLOR_ECOSYSTEM_TABLE = new Color(255, 255, 255);
    public static Color BACKGROUND_COLOR_ECOSYSTEM_CELL = new Color(255, 255, 255);
    public static Color BORDER_COLOR_ECOSYSTEM_CELL = new Color(148, 147, 147);

    // Font
    public static final Font ARIAL_BOLD_12 = new Font("Arial", Font.BOLD, 12);
    public static final Font ARIAL_BOLD_2 = new Font("Arial", Font.PLAIN, 2);

    // Image
    public static ImageIcon BEAR_IMAGE_0 = null;
    public static ImageIcon BEAR_IMAGE_1 = null;
    public static ImageIcon FISH_IMAGE_0 = null;
    public static ImageIcon FISH_IMAGE_1 = null;

    public Config() {
        try {
            BEAR_IMAGE_0 = new ImageIcon(this.getClass().getResource("assets/image/bear0.png"));
            BEAR_IMAGE_1 = new ImageIcon(this.getClass().getResource("assets/image/bear1.png"));
            FISH_IMAGE_0 = new ImageIcon(this.getClass().getResource("assets/image/fish0.png"));
            FISH_IMAGE_1 = new ImageIcon(this.getClass().getResource("assets/image/fish1.png"));
        } catch (Exception e) {
            System.out.println("Error when load images");
        }

    }
}
