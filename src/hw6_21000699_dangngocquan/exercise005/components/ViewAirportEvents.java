package hw6_21000699_dangngocquan.exercise005.components;

import hw3_21000699_dangngocquan.exercise004.Config;
import hw6_21000699_dangngocquan.base.EntryInterface;
import hw6_21000699_dangngocquan.base.PriorityQueueInterface;
import hw6_21000699_dangngocquan.base.SortedArrayPriorityQueue;
import hw6_21000699_dangngocquan.exercise005.App;
import hw6_21000699_dangngocquan.exercise005.components.base.Panel;
import hw6_21000699_dangngocquan.exercise005.components.base.Table;
import hw6_21000699_dangngocquan.exercise005.models.Event;

import java.awt.*;

public class ViewAirportEvents extends Panel {

    public ViewAirportEvents() {
        super(
                Config.WIDTH / 5, 0,
                Config.WIDTH - Config.WIDTH/5, Config.HEIGHT - Config.HEIGHT / 5,
                new Color(200, 200, 200), null, "");
        addTableAirportEvents();
    }

    public void addTableAirportEvents() {
        removeAll();
        PriorityQueueInterface<Event,Event> q = App.queueEvents;
        PriorityQueueInterface<Event,Event> qBackup = new SortedArrayPriorityQueue<>();
        Object[][] dataRows = new Object[q.size()][3];
        Object[] columnNames = new Object[] {"Order", "Event name", "Time occur"};
        for (int i = 0; i < dataRows.length; i++) {
            dataRows[i][0] = i+1;
            EntryInterface<Event, Event> event = q.removeMin();
            dataRows[i][1] = event.getKey().name;
            dataRows[i][2] = event.getKey().stringTimeOccur();
            qBackup.insert(event);
        }
        for (int i = 0; i < dataRows.length; i++) {
            q.insert(qBackup.removeMin());
        }
        Table tableAirportEvents = new Table(
                20, 20, getWidth() - 40, getHeight() - 40,
                dataRows, columnNames
        );
        tableAirportEvents.getTable().getColumnModel().getColumn(0).setMaxWidth(100);
        tableAirportEvents.getTable().getColumnModel().getColumn(0).setMinWidth(100);
        tableAirportEvents.getTable().setRowHeight(30);
        add(tableAirportEvents);
    }
}
