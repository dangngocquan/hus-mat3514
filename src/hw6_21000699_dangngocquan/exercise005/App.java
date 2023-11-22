package hw6_21000699_dangngocquan.exercise005;

import hw6_21000699_dangngocquan.base.PriorityQueueInterface;
import hw6_21000699_dangngocquan.base.SortedArrayPriorityQueue;
import hw6_21000699_dangngocquan.exercise005.components.ViewAirportEvents;
import hw6_21000699_dangngocquan.exercise005.components.ViewController;
import hw6_21000699_dangngocquan.exercise005.components.ViewNextEventToProcess;
import hw6_21000699_dangngocquan.exercise005.models.Event;

import javax.swing.*;

public class App extends JFrame {
    public static ViewController viewController;
    public static ViewAirportEvents viewAirportEvents;
    public static ViewNextEventToProcess viewNextEventToProcess;
    public static PriorityQueueInterface<Event, Event> queueEvents;

    public App() {
        super("Homework 6 - Exercise 5");
        setSize(Config.DEVICE_WIDTH, Config.DEVICE_HEIGHT);
        setResizable(false);
        setAlwaysOnTop(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        setBackground(Config.BACKGROUND_COLOR_APP);
        setFont(Config.ARIAL_BOLD_18);

        createEventsData();
        addViewController();
        addViewAirportEvents();
        addViewANextEventToProcess();

        setVisible(true);
    }

    public void createEventsData() {
        queueEvents = new SortedArrayPriorityQueue<>();
    }

    public void addViewController() {
        viewController = new ViewController();
        add(viewController);
    }

    public void addViewAirportEvents() {
        viewAirportEvents = new ViewAirportEvents();
        add(viewAirportEvents);
    }

    public void addViewANextEventToProcess() {
        viewNextEventToProcess = new ViewNextEventToProcess();
        add(viewNextEventToProcess);
    }
}