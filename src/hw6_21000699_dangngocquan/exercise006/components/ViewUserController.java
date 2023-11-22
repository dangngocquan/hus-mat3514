package hw6_21000699_dangngocquan.exercise006.components;

import hw6_21000699_dangngocquan.exercise006.App;
import hw6_21000699_dangngocquan.exercise006.Config;
import hw6_21000699_dangngocquan.exercise006.components.base.Button;
import hw6_21000699_dangngocquan.exercise006.components.base.Dialog;
import hw6_21000699_dangngocquan.exercise006.components.base.Panel;
import hw6_21000699_dangngocquan.exercise006.models.SharesOrder;

public class ViewUserController extends Panel {
    public static int userShares = 1000;
    public static int userBalance = 5000;
    private Panel userSharesPanel;
    private Panel userBalancePanel;
    private Button buttonSell;
    private Button buttonBuy;

    public ViewUserController() {
        super(0, Config.HEIGHT_VIEW_SHARES_EXCHANGE,
                Config.WIDTH_VIEW_USER_CONTROLLER, Config.HEIGHT - Config.HEIGHT_VIEW_SHARES_EXCHANGE,
                Config.GRAY_3, null, "");
        addPanels();
        addButtons();
        addButtonListeners();

        repaint();
    }

    public void addPanels() {
        Panel title = new Panel(
                0, 10,
                getWidth() / 3, 40,
                getBackgroundColor(),
                null, "User Controller"
        );
        userSharesPanel = new Panel(
                20, title.getY() + title.getHeight() + 20,
                getWidth()/2 - 20, 40,
                getBackgroundColor(),
                null, String.format("%-15s %-15s", "User shares:", userShares)
        );
        userBalancePanel = new Panel(
                userSharesPanel.getX(), userSharesPanel.getY() + userSharesPanel.getHeight() + 20,
                userSharesPanel.getWidth(), userSharesPanel.getHeight(),
                getBackgroundColor(),
                null, String.format("%-15s %-15s", "User balance:", "$" + userBalance)
        );

        add(title);
        add(userSharesPanel);
        add(userBalancePanel);
    }

    public void addButtons() {
        buttonBuy = new Button(
                getWidth()/2+50, userSharesPanel.getY(),
                getWidth()/4, 50,
                "Buy"
        );
        buttonSell = new Button(
                buttonBuy.getX(), userBalancePanel.getY(),
                buttonBuy.getWidth(), buttonBuy.getHeight(),
                "Sell"
        );
        add(buttonBuy);
        add(buttonSell);
    }

    public boolean nextExchange() {
        if (App.globalBuyOrders.size() > 0 && App.globalSellOrders.size() > 0) {
            SharesOrder orderBuy = App.globalBuyOrders.min().getKey();
            SharesOrder orderSell = App.globalSellOrders.min().getKey();
            if (orderBuy.pricePerShare >= orderSell.pricePerShare) {
                if (userShares < orderBuy.numberShares
                        || userBalance < (orderSell.pricePerShare * orderSell.numberShares)) {
                    new DialogUserNotEnoughSharesOrBalance("Notification");
                    return false;
                } else {
                    userBalance += (orderBuy.pricePerShare * orderBuy.numberShares);
                    userBalance -= (orderSell.pricePerShare * orderSell.numberShares);
                    userShares -= orderBuy.numberShares;
                    userShares += orderSell.numberShares;
                    return true;
                }
            } else {
                new DialogNotHaveOrder("Notification");
                return false;
            }
        } else {
            new DialogNotHaveOrder("Notification");
            return false;
        }
    }

    public void addButtonListeners() {
        buttonBuy.addActionListener(e -> {
            if (nextExchange()) {
                App.userExchangeHistory.add(App.globalSellOrders.removeMin().getKey());
                App.userExchangeHistory.add(App.globalBuyOrders.removeMin().getKey());
                userSharesPanel.setText(String.format("%-15s %-15s", "User shares:", userShares));
                userBalancePanel.setText(String.format("%-15s %-15s", "User balance:", userBalance));
                App.viewSharesExchange.addViews();
                App.viewUserExchangeHistory.addViews();
                repaint();
            }
        });
        buttonSell.addActionListener(e -> {
            if (nextExchange()) {
                App.userExchangeHistory.add(App.globalBuyOrders.removeMin().getKey());
                App.userExchangeHistory.add(App.globalSellOrders.removeMin().getKey());
                userSharesPanel.setText(String.format("%-15s %-15s", "User shares:", userShares));
                userBalancePanel.setText(String.format("%-15s %-15s", "User balance:", userBalance));
                App.viewSharesExchange.addViews();
                App.viewUserExchangeHistory.addViews();
                repaint();
            }
        });
    }

    public static class DialogNotHaveOrder extends Dialog {
        public DialogNotHaveOrder(String title) {
            super(Config.WIDTH/2 - Config.WIDTH/3, Config.HEIGHT/2 - Config.HEIGHT/6,
                    Config.WIDTH/3*2, Config.HEIGHT/6*2, title);
        }

        @Override
        public void addComponents() {
            Panel panel = new Panel(
                    20, 40,
                    getWidthDialog() - 40, 50,
                    dialog.getBackground(), null,
                    "Can't process this action. Not exist buy order with ($x) >= sell order with ($y)");
            Button button = new Button(
                    getWidthDialog()/2 - 50, panel.getY() + panel.getHeight() + 30,
                    100, 50, "OK");
            dialog.add(panel);
            dialog.add(button);

            button.addActionListener(e -> dialog.dispose());
        }
    }

    public static class DialogUserNotEnoughSharesOrBalance extends Dialog {
        public DialogUserNotEnoughSharesOrBalance(String title) {
            super(Config.WIDTH/2 - Config.WIDTH/3, Config.HEIGHT/2 - Config.HEIGHT/6,
                    Config.WIDTH/3*2, Config.HEIGHT/6*2, title);
        }

        @Override
        public void addComponents() {
            Panel panel = new Panel(
                    20, 40,
                    getWidthDialog() - 40, 50,
                    dialog.getBackground(), null,
                    "Not enough shares or money ...");
            Button button = new Button(
                    getWidthDialog()/2 - 50, panel.getY() + panel.getHeight() + 30,
                    100, 50, "OK");
            dialog.add(panel);
            dialog.add(button);

            button.addActionListener(e -> dialog.dispose());
        }
    }
}
