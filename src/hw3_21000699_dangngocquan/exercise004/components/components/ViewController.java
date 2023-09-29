package hw3_21000699_dangngocquan.exercise004.components.components;

import hw3_21000699_dangngocquan.exercise004.App;
import hw3_21000699_dangngocquan.exercise004.components.base.Button;
import hw3_21000699_dangngocquan.exercise004.components.base.Panel;
import hw3_21000699_dangngocquan.exercise004.components.base.TextArea;
import hw3_21000699_dangngocquan.exercise004.services.Service;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.*;


public class ViewController extends Panel {
    private TextArea inputText;
    private JScrollPane scrollPane;
    private Button buttonImport;

    public ViewController(
            int x, int y, int width, int height,
            Color backgroundColor,
            ImageIcon backgroundImage,
            String text) {
        super(x, y, width, height, backgroundColor, backgroundImage, text);
        addInputTextArea();
        addFocusListenerForInputTextArea();
        addButtons();
    }

    public void addInputTextArea() {
        inputText = new TextArea(
                2, 2, getWidth() - 36, getHeight() / 6 * 5 - 36,
                0, 0 , 0
        );
        scrollPane = new JScrollPane(inputText);
        scrollPane.setBounds(20, 20, getWidth()-40, getHeight() / 6 * 5 - 40);
        add(scrollPane);
    }

    public void addButtons() {
        buttonImport = new Button(
                20, inputText.getY() + inputText.getHeight() + 40,
                getWidth() - 40, getHeight() / 6 - 40, "Import document"
        );
        add(buttonImport);
    }

    public void addFocusListenerForInputTextArea() {
        inputText.getDocument().addDocumentListener(new HandlerInputDataModify());
    }

    public String getInputText() {
        return inputText.getText();
    }

    private class HandlerInputDataModify implements DocumentListener {

        @Override
        public void removeUpdate(DocumentEvent e) {
            ((ViewCountWords) getApp().getViewCountWords()).addTableWordCount(getInputText());
        }

        @Override
        public void insertUpdate(DocumentEvent e) {
            ((ViewCountWords) getApp().getViewCountWords()).addTableWordCount(getInputText());
        }

        @Override
        public void changedUpdate(DocumentEvent arg0) {

        }
    }

    public App getApp() {
        return (App) (Service.getFrame(this));
    }
}
