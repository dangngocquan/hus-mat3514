package hw6_21000699_dangngocquan.exercise006;

import hw6_21000699_dangngocquan.base.MinHeapPriorityQueue;
import hw6_21000699_dangngocquan.base.PriorityQueueInterface;
import hw6_21000699_dangngocquan.exercise006.components.ViewSharesExchange;
import hw6_21000699_dangngocquan.exercise006.components.ViewUserController;
import hw6_21000699_dangngocquan.exercise006.components.ViewUserExchangeHistory;
import hw6_21000699_dangngocquan.exercise006.models.SharesBuyOrder;
import hw6_21000699_dangngocquan.exercise006.models.SharesOrder;
import hw6_21000699_dangngocquan.exercise006.models.SharesSellOrder;

import javax.swing.*;
import java.util.*;
import java.util.Timer;

public class App extends JFrame {
    public static ViewUserController viewUserController;
    public static ViewSharesExchange viewSharesExchange;
    public static ViewUserExchangeHistory viewUserExchangeHistory;
    public static PriorityQueueInterface<SharesBuyOrder, SharesBuyOrder> globalBuyOrders;
    public static PriorityQueueInterface<SharesSellOrder, SharesSellOrder> globalSellOrders;
    public static List<SharesOrder> userExchangeHistory;

    public App() {
        super("Homework 6 - Exercise 6");
        setSize(Config.DEVICE_WIDTH, Config.DEVICE_HEIGHT);
        setResizable(false);
        setAlwaysOnTop(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        setBackground(Config.BACKGROUND_COLOR_APP);
        setFont(Config.ARIAL_BOLD_18);

        createData();
        addViewUserController();
        addViewUserExchangeHistory();
        addViewSharesExchange();
        new Timer().schedule(new AutoTask(), 10, 1000);

        setVisible(true);
    }

    public void createData() {
        globalBuyOrders = new MinHeapPriorityQueue<>();
        globalSellOrders = new MinHeapPriorityQueue<>();
        userExchangeHistory = new LinkedList<>();
    }

    public void addViewUserController() {
        viewUserController = new ViewUserController();
        add(viewUserController);
    }

    public void addViewUserExchangeHistory() {
        viewUserExchangeHistory = new ViewUserExchangeHistory();
        add(viewUserExchangeHistory);
    }

    public void addViewSharesExchange() {
        viewSharesExchange = new ViewSharesExchange();
        add(viewSharesExchange);
    }

    public static class AutoTask extends TimerTask {
        public static Random random = new Random();
        @Override
        public void run() {
            int x = random.nextInt(30);
            if (10 <= x && x < 20) return;
            int numberShares = random.nextInt(90) + 10;
            int pricePerShare = random.nextInt(95) + 5;
            if (x < 10) {
                SharesBuyOrder order = new SharesBuyOrder(numberShares, pricePerShare);
                globalBuyOrders.insert(order, order);
            } else {
                SharesSellOrder order = new SharesSellOrder(numberShares, pricePerShare);
                globalSellOrders.insert(order, order);
            }
            viewSharesExchange.addViews();
        }
    }
}