package hw5_21000699_dangngocquan.exercise004;

import java.awt.*;

public class Config {
    // Size
    public static int DEVICE_WIDTH = (int) (GraphicsEnvironment.getLocalGraphicsEnvironment()
            .getMaximumWindowBounds().getWidth());
    public static int DEVICE_HEIGHT = (int) ((GraphicsEnvironment.getLocalGraphicsEnvironment()
            .getMaximumWindowBounds().getHeight()));
    public static int WIDTH = DEVICE_WIDTH - 14;
    public static int HEIGHT = DEVICE_HEIGHT - 36;
    public static int NODE_SIZE = 40;


    // Color
    public static Color BACKGROUND_COLOR_APP = new Color(255, 255, 255);

    // Font
    public static final Font MONOSPACE_BOLD_16 = new Font(Font.MONOSPACED, Font.BOLD, 16);
}
