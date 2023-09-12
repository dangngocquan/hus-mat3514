package hw1_21000699_dangngocquan.exercise006.p1dot30;

import java.awt.*;

public class Config {
    // Size
    public static int DEVICE_WIDTH = (int) (GraphicsEnvironment.getLocalGraphicsEnvironment()
            .getMaximumWindowBounds().getWidth());
    public static int DEVICE_HEIGHT = (int) ((GraphicsEnvironment.getLocalGraphicsEnvironment()
            .getMaximumWindowBounds().getHeight()));
    public static int WIDTH = DEVICE_WIDTH - 14;
    public static int HEIGHT = DEVICE_HEIGHT - 36;
    public static int VIEW_COMPONENT_HEIGHT = HEIGHT / 16 * 13;
    public static int VIEW_COMPONENT_WIDTH = WIDTH;
    public static int INPUT_COMPONENT_HEIGHT = HEIGHT - VIEW_COMPONENT_HEIGHT;
    public static int INPUT_COMPONENT_WIDTH = WIDTH;
    public static int TEXT_AREA_INPUT_WIDTH = WIDTH / 4*3;
    public static int TEXT_AREA_INPUT_HEIGHT = INPUT_COMPONENT_HEIGHT / 3*2;
    public static int BAR_HEIGHT = VIEW_COMPONENT_HEIGHT - 100;
    public static int BAR_WIDTH = (VIEW_COMPONENT_WIDTH - 40) / 26;


    // Color
    public static Color VIEW_COMPONENT_BACKGROUND_COLOR = new Color(245, 239, 239);
    public static Color INPUT_COMPONENT_BACKGROUND_COLOR = new Color(208, 231, 231);
    public static Color BAR_BACKGROUND_COLOR = new Color(57, 100, 140);
}
