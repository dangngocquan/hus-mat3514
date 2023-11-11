package hw6_21000699_dangngocquan.exercise006;

import java.awt.*;

public class Config {
    // Size
    public static int DEVICE_WIDTH = (int) (GraphicsEnvironment.getLocalGraphicsEnvironment()
            .getMaximumWindowBounds().getWidth());
    public static int DEVICE_HEIGHT = (int) ((GraphicsEnvironment.getLocalGraphicsEnvironment()
            .getMaximumWindowBounds().getHeight()));
    public static int WIDTH = DEVICE_WIDTH - 14;
    public static int HEIGHT = DEVICE_HEIGHT - 36;
    public static int HEIGHT_VIEW_SHARES_EXCHANGE = HEIGHT/4*3;
    public static int WIDTH_VIEW_USER_CONTROLLER = WIDTH/3;



    // Color
    public static Color COLOR_TEXT = new Color(20, 20, 20);
    public static Color BACKGROUND_COLOR_APP = new Color(255, 255, 255);
    public static Color GRAY_1 = new Color(170, 170, 170);
    public static Color GRAY_2 = new Color(190, 190, 190);
    public static Color GRAY_3 = new Color(210, 210, 210);

    // Font
    public static final Font ARIAL_BOLD_18 = new Font("Arial", Font.BOLD, 18);
    public static final Font ARIAL_BOLD_16 = new Font("Arial", Font.BOLD, 16);
    public static final Font ARIAL_BOLD_12 = new Font("Arial", Font.BOLD, 12);
    public static final Font ARIAL_PLAIN_18 = new Font("Arial", Font.PLAIN, 18);
}
