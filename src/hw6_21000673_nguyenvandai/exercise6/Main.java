package hw6_21000673_nguyenvandai.exercise6;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main extends JFrame {
    private StockTradingSystem tradingSystem;
    private DefaultListModel<String> orderListModel;
    private JList<String> orderList;

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            Main main = new Main();
            main.start();
        });
    }

    public void start() {
        tradingSystem = new StockTradingSystem();
        orderListModel = new DefaultListModel<>();
        orderList = new JList<>(orderListModel);

        JPanel root = new JPanel();
        root.setLayout(new BoxLayout(root, BoxLayout.Y_AXIS));
        root.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        JPanel buyBox = createOrderBox("Buy");
        JPanel sellBox = createOrderBox("Sell");

        root.add(buyBox);
        root.add(sellBox);
        root.add(new JScrollPane(orderList));

        setTitle("Stock Trading System");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 500);
        setLocationRelativeTo(null);
        setContentPane(root);
        setVisible(true);
    }

    private JPanel createOrderBox(String type) {
        JPanel box = new JPanel();
        box.setLayout(new FlowLayout(FlowLayout.LEFT, 40, 0));

        JTextField sharesField = new JTextField();
        sharesField.setPreferredSize(new Dimension(80, 25));
        sharesField.setToolTipText("Shares");

        JTextField priceField = new JTextField();
        priceField.setPreferredSize(new Dimension(80, 25));
        priceField.setToolTipText("Price");

        JButton addButton = new JButton("Add");
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int shares = Integer.parseInt(sharesField.getText());
                double price = Double.parseDouble(priceField.getText());
                tradingSystem.addOrder(type, shares, price);
                updateOrderList();
            }
        });

        box.add(new JLabel(type));
        box.add(sharesField);
        box.add(priceField);
        box.add(addButton);

        return box;
    }

    private void updateOrderList() {
        orderListModel.clear();
        for (String order : tradingSystem.getOrders()) {
            orderListModel.addElement(order);
        }
    }
}