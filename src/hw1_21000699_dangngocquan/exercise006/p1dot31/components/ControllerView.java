package hw1_21000699_dangngocquan.exercise006.p1dot31.components;

import hw1_21000699_dangngocquan.exercise006.p1dot31.Config;

import java.awt.*;

public class ControllerView extends BasicPanel {
    // Setting
    private BasicPanelWithText ecosystemSizePanel = null;
    private BasicTextArea ecosystemSizeInput = null;
    private BasicPanelWithText initialNumberBearPanel = null;
    private BasicTextArea initialNumberBearInput = null;
    private BasicPanelWithText initialNumberFishPanel = null;
    private BasicTextArea initialNumberFishInput = null;
    private BasicPanelWithText millisecondPerStepPanel = null;
    private BasicTextArea millisecondPerStepInput = null;
    // Status
    private BasicPanelWithText numberBearExistingPanel = null;
    private BasicPanelWithText numberFishExistingPanel = null;
    private BasicPanelWithText numberBearDiedPanel = null;
    private BasicPanelWithText numberFishDiedPanel = null;
    // Control
    private BasicButton playButton = null;

    public ControllerView(int x, int y, int width, int height) {
        super(x, y, width, height);

        addInitialSetting();
        addEcosystemStatusPanels();
        addControllerButtons();
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Config.BACKGROUND_COLOR_CONTROLLER_VIEW);
        g.fillRect(0, 0, this.getWidth(), this.getHeight());
    }

    public void addInitialSetting() {
        ecosystemSizePanel =
                new BasicPanelWithText(
                        10, 20,
                        (this.getWidth() - 40) / 2, 30,
                        "Ecosystem Size [2 - 50]:"
                );
        initialNumberBearPanel =
                new BasicPanelWithText(
                        ecosystemSizePanel.getX(),
                        ecosystemSizePanel.getY() + ecosystemSizePanel.getHeight() + 10,
                        ecosystemSizePanel.getWidth(), 30,
                        "Initial Number Bears:");
        initialNumberFishPanel =
                new BasicPanelWithText(
                        ecosystemSizePanel.getX(),
                        initialNumberBearPanel.getY() + initialNumberBearPanel.getHeight() + 10,
                        initialNumberBearPanel.getWidth(), 30,
                        "Initial Number Fishes:");

        millisecondPerStepPanel =
                new BasicPanelWithText(
                        ecosystemSizePanel.getX(),
                        initialNumberFishPanel.getY() + initialNumberFishPanel.getHeight() + 10,
                        initialNumberFishPanel.getWidth(), 30,
                        "Millisecond Per Step:");

        ecosystemSizeInput = new BasicTextArea(
                ecosystemSizePanel.getX() + ecosystemSizePanel.getWidth() + 10,
                ecosystemSizePanel.getY(),
                ecosystemSizePanel.getWidth(),
                ecosystemSizePanel.getHeight(),
                1, 0, 0
        );

        initialNumberBearInput = new BasicTextArea(
                ecosystemSizeInput.getX(),
                initialNumberBearPanel.getY(),
                ecosystemSizeInput.getWidth(),
                ecosystemSizeInput.getHeight(),
                1, 0, 0
        );

        initialNumberFishInput = new BasicTextArea(
                ecosystemSizeInput.getX(),
                initialNumberFishPanel.getY(),
                ecosystemSizeInput.getWidth(),
                ecosystemSizeInput.getHeight(),
                1, 0, 0
        );

        millisecondPerStepInput = new BasicTextArea(
                ecosystemSizeInput.getX(),
                millisecondPerStepPanel.getY(),
                ecosystemSizeInput.getWidth(),
                ecosystemSizeInput.getHeight(),
                1, 0, 0
        );

        ecosystemSizeInput.setText("50");
        initialNumberBearInput.setText("14");
        initialNumberFishInput.setText("28");
        millisecondPerStepInput.setText("1000");

        this.add(ecosystemSizePanel);
        this.add(initialNumberBearPanel);
        this.add(initialNumberFishPanel);
        this.add(millisecondPerStepPanel);
        this.add(ecosystemSizeInput);
        this.add(initialNumberBearInput);
        this.add(initialNumberFishInput);
        this.add(millisecondPerStepInput);
    }

    public void addEcosystemStatusPanels() {
        numberBearExistingPanel =
                new BasicPanelWithText(
                        millisecondPerStepPanel.getX(),
                        millisecondPerStepPanel.getY() + millisecondPerStepPanel.getHeight() + 50,
                        this.getWidth() - 40, 30,
                        "Number Bears Existing: 0"
                );

        numberFishExistingPanel =
                new BasicPanelWithText(
                        numberBearExistingPanel.getX(),
                        numberBearExistingPanel.getY() + numberBearExistingPanel.getHeight() + 10,
                        numberBearExistingPanel.getWidth(), 30,
                        "Number Fish Existing: 0"
                );

        numberBearDiedPanel =
                new BasicPanelWithText(
                        numberFishExistingPanel.getX(),
                        numberFishExistingPanel.getY() + numberFishExistingPanel.getHeight() + 10,
                        numberFishExistingPanel.getWidth(), 30,
                        "Number Bear Died: 0"
                );

        numberFishDiedPanel =
            new BasicPanelWithText(
                    numberBearDiedPanel.getX(),
                    numberBearDiedPanel.getY() + numberBearDiedPanel.getHeight() + 10,
                    numberBearDiedPanel.getWidth(), 30,
                    "Number Fish Died: 0"
            );

        this.add(numberBearExistingPanel);
        this.add(numberFishExistingPanel);
        this.add(numberBearDiedPanel);
        this.add(numberFishDiedPanel);
    }

    public void addControllerButtons() {
        playButton = new BasicButton(
                numberFishDiedPanel.getX(),
                numberFishDiedPanel.getY() + numberFishDiedPanel.getHeight() + 50,
                getWidth() - 40,
                50,
                "Run"
        );

        this.add(playButton);
    }

    public int getEcosystemSize() {
        String data = ecosystemSizeInput.getText();
        if (data.matches("[0-9]{1,}")) {
            int size = Integer.parseInt(data);
            if (size < 2) {
                ecosystemSizeInput.setText("2");
                return 2;
            } else if (size > 50) {
                ecosystemSizeInput.setText("50");
                return 50;
            } else {
                return size;
            }
        } else {
            ecosystemSizeInput.setText("10");
            return 10;
        }
    }
}
