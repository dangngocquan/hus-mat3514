package hw6_21000699_dangngocquan.exercise005.components;

import hw6_21000699_dangngocquan.base.AbstractPriorityQueue;
import hw6_21000699_dangngocquan.exercise005.App;
import hw6_21000699_dangngocquan.exercise005.Config;
import hw6_21000699_dangngocquan.exercise005.components.base.Button;
import hw6_21000699_dangngocquan.exercise005.components.base.Dialog;
import hw6_21000699_dangngocquan.exercise005.components.base.Panel;
import hw6_21000699_dangngocquan.exercise005.components.base.TextField;
import hw6_21000699_dangngocquan.exercise005.models.Event;

import java.awt.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.ResolverStyle;

public class ViewController extends Panel {
    private Button[] buttons;
    public static String flightName = "";
    public static Event eventLanding;
    public static Event eventTakeoff;
    public ViewController() {
        super(
                0, 0,
                Config.WIDTH / 5, Config.HEIGHT  - Config.HEIGHT / 5,
                new Color(100, 100, 100), null, ""
        );

        addButtons();
        addButtonListeners();
    }

    public void addButtons() {
        buttons = new Button[2];
        int buttonWidth = Config.WIDTH/8 + 20;
        int buttonHeight = 40;
        int gapY = 40;
        buttons[0] = new Button(
                (getWidth() - buttonWidth) / 2, gapY,
                buttonWidth, buttonHeight,
                "Add new event"
        );
        buttons[1] = new Button(
                buttons[0].getX(), buttons[0].getY() + buttons[0].getHeight() + gapY,
                buttonWidth, buttonHeight,
                "Process next event"
        );

        for (Button button : buttons) add(button);
    }

    public void addButtonListeners() {
        buttons[0].addActionListener(e -> addEvent());
        buttons[1].addActionListener(e -> processNextEvent());
    }

    public void addEvent() {
        new DialogGetEvent(
                Config.WIDTH/2 - Config.WIDTH/3, Config.HEIGHT/2 - Config.HEIGHT/4,
                Config.WIDTH/3*2, Config.HEIGHT/2,
                "Add new flight event"
        );
        if (eventLanding != null && eventTakeoff != null) {
            App.queueEvents.insert(new AbstractPriorityQueue.Entry<>(eventLanding, eventLanding));
            App.queueEvents.insert(new AbstractPriorityQueue.Entry<>(eventTakeoff, eventTakeoff));
            eventLanding = null;
            eventTakeoff = null;
            App.viewAirportEvents.addTableAirportEvents();
        }
    }

    public void processNextEvent() {
        if (App.queueEvents.size() > 0) {
            App.viewNextEventToProcess.setText(App.queueEvents.removeMin().getKey().toString());
            App.viewAirportEvents.addTableAirportEvents();
        } else {
            App.viewNextEventToProcess.setText("No event processing");
        }
    }

    public static class DialogMessage extends Dialog {
        public DialogMessage(String title) {
            super(Config.WIDTH/2 - Config.WIDTH/6, Config.HEIGHT/2 - Config.HEIGHT/6,
                    Config.WIDTH/6*2, Config.HEIGHT/6*2, title);
        }

        @Override
        public void addComponents() {
            Panel panel = new Panel(
                    20, 40,
                    getWidthDialog() - 40, 50,
                    dialog.getBackground(), null,
                    "Invalid input");
            Button button = new Button(
                    getWidthDialog()/2 - 50, panel.getY() + panel.getHeight() + 30,
                    100, 50, "OK");
            dialog.add(panel);
            dialog.add(button);

            button.addActionListener(e -> {
                dialog.dispose();
            });
        }
    }

    public static class DialogGetEvent extends Dialog {
        public DialogGetEvent(int x, int y, int width, int height, String title) {
            super(x, y, width, height, title);
        }

        @Override
        public void addComponents() {
            Panel panel0 = new Panel(
                    20, 40,
                    getWidthDialog() / 4 - 20, 50,
                    dialog.getBackground(), null,
                    "Enter the flight name");
            TextField textField0 = new TextField(
                    panel0.getWidth() + panel0.getX(), panel0.getY(),
                    getWidthDialog() - getWidthDialog()/4-20, panel0.getHeight(),
                    "", Config.BACKGROUND_COLOR_APP,
                    2, 0, 0
            );
            Panel panel1 = new Panel(
                    panel0.getX(), panel0.getY() + panel0.getHeight() + 30,
                    getWidthDialog() - getWidthDialog() / 4 - 20, 50,
                    dialog.getBackground(), null,
                    "Enter the date time when the flight landing (with format \"dd/MM/yyyy HH:mm\")");
            TextField textField1 = new TextField(
                    panel1.getWidth() + panel1.getX(), panel1.getY(),
                    getWidthDialog()/4 - 20, panel1.getHeight(),
                    "", Config.BACKGROUND_COLOR_APP,
                    2, 0, 0
            );
            Panel panel2 = new Panel(
                    panel1.getX(), panel1.getY() + panel1.getHeight() + 30,
                    panel1.getWidth(), panel1.getHeight(),
                    dialog.getBackground(), null,
                    "Enter the date time when the flight takeoff (with format \"dd/MM/yyyy HH:mm\")");
            TextField textField2 = new TextField(
                    panel2.getWidth() + panel2.getX(), panel2.getY(), getWidthDialog()/4 - 20, panel2.getHeight(),
                    "", Config.BACKGROUND_COLOR_APP, 2, 0, 0
            );

            Button button = new Button(
                    getWidthDialog()/2 - 50, panel2.getY() + panel2.getHeight() + 30,
                    100, 50, "Create");

            dialog.add(panel0);
            dialog.add(panel1);
            dialog.add(panel2);
            dialog.add(textField0);
            dialog.add(textField1);
            dialog.add(textField2);
            dialog.add(button);

            button.addActionListener(e -> {
                ViewController.flightName = textField0.getText();
                DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
                dateTimeFormatter = dateTimeFormatter.withResolverStyle(ResolverStyle.LENIENT);
                try {
                    LocalDateTime dateTimeLanding = LocalDateTime.parse(textField1.getText(), dateTimeFormatter);
                    LocalDateTime dateTimeTakeoff = LocalDateTime.parse(textField2.getText(), dateTimeFormatter);
                    eventLanding = new Event("[Event flight landing] " + flightName, dateTimeLanding);
                    eventTakeoff = new Event("[Event flight takeoff] " + flightName, dateTimeTakeoff);
                } catch (Exception error) {
                    eventTakeoff = null;
                    eventLanding = null;
                    new DialogMessage("Invalid input");
                }
                dialog.dispose();
            });
        }
    }
}

