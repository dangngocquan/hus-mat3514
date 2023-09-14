package hw1_21000699_dangngocquan.exercise006.p1dot31.components;

import hw1_21000699_dangngocquan.exercise006.p1dot31.App;
import hw1_21000699_dangngocquan.exercise006.p1dot31.Config;
import hw1_21000699_dangngocquan.exercise006.p1dot31.services.Service;

import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
    // Status Panels
    private BasicPanelWithText numberBearExistingPanel = null;
    private BasicPanelWithText numberFishExistingPanel = null;
    // Control
    private BasicButton playButton = null;

    public ControllerView(int x, int y, int width, int height) {
        super(x, y, width, height);

        addInitialSetting();
        addEcosystemStatusPanels(0, 0);
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

        ecosystemSizeInput.setText("10");
        initialNumberBearInput.setText("14");
        initialNumberFishInput.setText("28");
        millisecondPerStepInput.setText("1000");

        ecosystemSizeInput.getDocument().addDocumentListener(new HandlerInputDataModify());
        initialNumberBearInput.getDocument().addDocumentListener(new HandlerInputDataModify());
        initialNumberFishInput.getDocument().addDocumentListener(new HandlerInputDataModify());
        millisecondPerStepInput.getDocument().addDocumentListener(new HandlerInputDataModify());

        this.add(ecosystemSizePanel);
        this.add(initialNumberBearPanel);
        this.add(initialNumberFishPanel);
        this.add(millisecondPerStepPanel);
        this.add(ecosystemSizeInput);
        this.add(initialNumberBearInput);
        this.add(initialNumberFishInput);
        this.add(millisecondPerStepInput);
    }

    public void addEcosystemStatusPanels(
            int numberBearExisting, int numberFishExisting) {
        numberBearExistingPanel =
                new BasicPanelWithText(
                        millisecondPerStepPanel.getX(),
                        millisecondPerStepPanel.getY() + millisecondPerStepPanel.getHeight() + 50,
                        this.getWidth() - 40, 30,
                        "Number Bears Existing: " + numberBearExisting
                );

        numberFishExistingPanel =
                new BasicPanelWithText(
                        numberBearExistingPanel.getX(),
                        numberBearExistingPanel.getY() + numberBearExistingPanel.getHeight() + 10,
                        numberBearExistingPanel.getWidth(), 30,
                        "Number Fish Existing: " + numberFishExisting
                );

        this.add(numberBearExistingPanel);
        this.add(numberFishExistingPanel);
    }

    public void addControllerButtons() {
        playButton = new BasicButton(
                numberFishExistingPanel.getX(),
                numberFishExistingPanel.getY() + numberFishExistingPanel.getHeight() + 50,
                getWidth() - 40,
                50,
                "Run"
        );
        playButton.addActionListener(new HandlerPlayButton());
        this.add(playButton);
    }

    public void removeEcosystemStatusPanels() {
        this.remove(numberBearExistingPanel);
        this.remove(numberFishExistingPanel);
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

    public int getInitialNumberBear() {
        int ecosystemSize = getEcosystemSize();
        int numberCells = ecosystemSize * ecosystemSize;
        String data = initialNumberBearInput.getText();
        if (data.matches("[0-9]{1,}")) {
            int size = Integer.parseInt(data);
            if (size < 0) {
                initialNumberBearInput.setText("0");
                return 0;
            } else if (size > numberCells) {
                initialNumberBearInput.setText(numberCells + "");
                return numberCells;
            } else {
                return size;
            }
        } else {
            initialNumberBearInput.setText("0");
            return 0;
        }
    }

    public int getInitialNumberFish() {
        int ecosystemSize = getEcosystemSize();
        int numberCells = ecosystemSize * ecosystemSize;
        int initialNumberBear = getInitialNumberBear();
        String data = initialNumberFishInput.getText();
        if (data.matches("[0-9]{1,}")) {
            int size = Integer.parseInt(data);
            if (size < 0) {
                initialNumberFishInput.setText("0");
                return 0;
            } else if (size > numberCells - initialNumberBear) {
                initialNumberFishInput.setText((numberCells - initialNumberBear) + "");
                return numberCells - initialNumberBear;
            } else {
                return size;
            }
        } else {
            initialNumberFishInput.setText("0");
            return 0;
        }
    }

    public int getMillisecondPerStep() {
        String data = millisecondPerStepInput.getText();
        if (data.matches("[0-9]{1,}")) {
            int size = Integer.parseInt(data);
            if (size < 100) {
                millisecondPerStepInput.setText("100");
                return 100;
            } else if (size > 10000) {
                millisecondPerStepInput.setText("10000");
                return 10000;
            } else {
                return size;
            }
        } else {
            millisecondPerStepInput.setText("1000");
            return 1000;
        }
    }

    public void updateStatusPanels(
            int numberBearExisting, int numberFishExisting) {
        removeEcosystemStatusPanels();
        addEcosystemStatusPanels(
                numberBearExisting, numberFishExisting);
        repaint();
    }

    public App getApp() {
        return (App) Service.getFrame(this);
    }

    private class HandlerInputDataModify implements DocumentListener {

        @Override
        public void removeUpdate(DocumentEvent e) {
            getApp().setInputChanged(true);
        }

        @Override
        public void insertUpdate(DocumentEvent e) {
            getApp().setInputChanged(true);
        }

        @Override
        public void changedUpdate(DocumentEvent arg0) {

        }
    }

    private class HandlerPlayButton implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            App app = getApp();
            if (app.isEcosystemRunning()) {
                app.setEcosystemRunning(false);
                playButton.setText("Run");
                ecosystemSizeInput.setEditable(true);
                initialNumberBearInput.setEditable(true);
                initialNumberFishInput.setEditable(true);
                millisecondPerStepInput.setEditable(true);
                ecosystemSizeInput.setEnabled(true);
                initialNumberBearInput.setEnabled(true);
                initialNumberFishInput.setEnabled(true);
                millisecondPerStepInput.setEnabled(true);
                app.stopEcosystem();
                // Do something later
            } else {
                app.setEcosystemRunning(true);
                playButton.setText("Stop");
                ecosystemSizeInput.setEditable(false);
                initialNumberBearInput.setEditable(false);
                initialNumberFishInput.setEditable(false);
                millisecondPerStepInput.setEditable(false);
                ecosystemSizeInput.setEnabled(false);
                initialNumberBearInput.setEnabled(false);
                initialNumberFishInput.setEnabled(false);
                millisecondPerStepInput.setEnabled(false);
                if (app.isInputChanged()) {
                    app.rerenderEcosystemViewWithInitialDataInput(
                            getEcosystemSize(),
                            getInitialNumberBear(),
                            getInitialNumberFish()
                    );
                    app.setInputChanged(false);
                }
                app.runEcosystem();
            }
        }
    }
}
