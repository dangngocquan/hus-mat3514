package hw6_21000699_dangngocquan.exercise005;

import java.awt.*;

public class Config {
    // Size
    public static int DEVICE_WIDTH = (int) (GraphicsEnvironment.getLocalGraphicsEnvironment()
            .getMaximumWindowBounds().getWidth());
    public static int DEVICE_HEIGHT = (int) ((GraphicsEnvironment.getLocalGraphicsEnvironment()
            .getMaximumWindowBounds().getHeight()));
    public static int WIDTH = DEVICE_WIDTH - 14;
    public static int HEIGHT = DEVICE_HEIGHT - 36;



    // Color
    public static Color COLOR_TEXT = new Color(20, 20, 20);
    public static Color BACKGROUND_COLOR_APP = new Color(255, 255, 255);

    // Font
    public static final Font ARIAL_BOLD_18 = new Font("Arial", Font.BOLD, 18);
}
