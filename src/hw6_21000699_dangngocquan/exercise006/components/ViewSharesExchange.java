package hw6_21000699_dangngocquan.exercise006.components;

import hw6_21000699_dangngocquan.base.EntryInterface;
import hw6_21000699_dangngocquan.base.MinHeapPriorityQueue;
import hw6_21000699_dangngocquan.base.PriorityQueueInterface;
import hw6_21000699_dangngocquan.exercise006.App;
import hw6_21000699_dangngocquan.exercise006.Config;
import hw6_21000699_dangngocquan.exercise006.components.base.Panel;
import hw6_21000699_dangngocquan.exercise006.components.base.Table;
import hw6_21000699_dangngocquan.exercise006.models.SharesBuyOrder;
import hw6_21000699_dangngocquan.exercise006.models.SharesSellOrder;

public class ViewSharesExchange extends Panel {
    public ViewSharesExchange() {
        super(0, 0,
                Config.WIDTH, Config.HEIGHT_VIEW_SHARES_EXCHANGE,
                Config.GRAY_1, null, "");
        addViews();
        repaint();
    }

    public void addPanels() {
        add(new Panel(
                0, 0, getWidth(), 50, getBackgroundColor(), null, "GLOBAL SHARES EXCHANGE"
        ));
        add(new Panel(
                0, 50, getWidth()/2, 50, getBackgroundColor(), null, "BUY ORDERS"
        ));
        add(new Panel(
                getWidth()/2, 50, getWidth()/2, 50, getBackgroundColor(), null, "SELL ORDERS"
        ));
    }

    public void addViews() {
        removeAll();
        addPanels();
        addTableBuyOrders();
        addTableSellOrders();
    }

    public void addTableBuyOrders() {
        PriorityQueueInterface<SharesBuyOrder, SharesBuyOrder> q = App.globalBuyOrders;
        PriorityQueueInterface<SharesBuyOrder, SharesBuyOrder> qBackup = new MinHeapPriorityQueue<>();
        Object[][] dataRows = new Object[q.size()][3];
        Object[] columnNames = new Object[] {"Order", "Number shares", "Price per share ($x)"};
        for (int i = 0; i < dataRows.length; i++) {
            dataRows[i][0] = i+1;
            EntryInterface<SharesBuyOrder, SharesBuyOrder> order = q.removeMin();
            dataRows[i][1] = order.getKey().numberShares;
            dataRows[i][2] = order.getKey().pricePerShare;
            qBackup.insert(order);
        }
        for (int i = 0; i < dataRows.length; i++) {
            q.insert(qBackup.removeMin());
        }
        Table table = new Table(
                20, 100, getWidth()/2 - 40, getHeight() - 140,
                dataRows, columnNames
        );
        table.getTable().getColumnModel().getColumn(0).setMaxWidth(100);
        table.getTable().getColumnModel().getColumn(0).setMinWidth(100);
        table.getTable().setRowHeight(30);
        add(table);
    }

    public void addTableSellOrders() {
        PriorityQueueInterface<SharesSellOrder, SharesSellOrder> q = App.globalSellOrders;
        PriorityQueueInterface<SharesSellOrder, SharesSellOrder> qBackup = new MinHeapPriorityQueue<>();
        Object[][] dataRows = new Object[q.size()][3];
        Object[] columnNames = new Object[] {"Order", "Number shares", "Price per share ($y)"};
        for (int i = 0; i < dataRows.length; i++) {
            dataRows[i][0] = i+1;
            EntryInterface<SharesSellOrder, SharesSellOrder> order = q.removeMin();
            dataRows[i][1] = order.getKey().numberShares;
            dataRows[i][2] = order.getKey().pricePerShare;
            qBackup.insert(order);
        }
        for (int i = 0; i < dataRows.length; i++) {
            q.insert(qBackup.removeMin());
        }
        Table table = new Table(
                getWidth()/2 + 20, 100, getWidth()/2 - 40, getHeight() - 140,
                dataRows, columnNames
        );
        table.getTable().getColumnModel().getColumn(0).setMaxWidth(100);
        table.getTable().getColumnModel().getColumn(0).setMinWidth(100);
        table.getTable().setRowHeight(30);
        add(table);
    }


}
