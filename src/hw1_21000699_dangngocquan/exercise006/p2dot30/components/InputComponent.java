package hw1_21000699_dangngocquan.exercise006.p2dot30.components;

import hw1_21000699_dangngocquan.exercise006.p2dot30.App;
import hw1_21000699_dangngocquan.exercise006.p2dot30.Config;
import hw1_21000699_dangngocquan.exercise006.p2dot30.services.Service;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.filechooser.FileSystemView;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class InputComponent extends BasicPanel {
    private BasicTextArea textAreaInput = null;
    private BasicButton buttonImportData = null;
    private BasicButton buttonRenderBarChart = null;
    public InputComponent(int x, int y, int width, int height) {
        super(x, y, width, height);

        addTextAreaInput();
        addButtonImportData();
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Config.INPUT_COMPONENT_BACKGROUND_COLOR);
        g.fillRect(0, 0, this.getWidth(), this.getHeight());
    }

    public void addTextAreaInput() {
        this.textAreaInput = new TextAreaInput(
                20, (Config.INPUT_COMPONENT_HEIGHT - Config.TEXT_AREA_INPUT_HEIGHT) / 2,
                Config.TEXT_AREA_INPUT_WIDTH, Config.TEXT_AREA_INPUT_HEIGHT,
                1, 0, 0
        );
        this.textAreaInput.getDocument().addDocumentListener(new DocumentListener() {

            @Override
            public void removeUpdate(DocumentEvent e) {
                handleRenderBarChart();
            }

            @Override
            public void insertUpdate(DocumentEvent e) {
                handleRenderBarChart();
            }

            @Override
            public void changedUpdate(DocumentEvent arg0) {

            }
        });
        this.add(textAreaInput);
    }

    public void addButtonImportData() {
        this.buttonImportData = new BasicButton(
                textAreaInput.getX() + textAreaInput.getWidth() + 20,
                textAreaInput.getY(),
                (Config.WIDTH - textAreaInput.getWidth()) - 60,
                textAreaInput.getHeight(),
                "Import document"
        );
        this.buttonImportData.addActionListener(
                new HandlerButtonImportData()
        );

        this.add(buttonImportData);
    }

    public String getText() {
        if (textAreaInput != null) {
            return textAreaInput.getText();
        }
        return "";
    }

    public void handleRenderBarChart() {
        App app = (App) Service.getFrame(this);
        app.renderBarChart(this.getText());
    }

    private class HandlerButtonImportData implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            JFileChooser j = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
            int r = j.showSaveDialog(null);
            if (r == JFileChooser.APPROVE_OPTION) {
                String path = j.getSelectedFile().getAbsolutePath();
                String data = Service.getStringFromFile(path);
                textAreaInput.setText(data);
            }
        }
    }
}