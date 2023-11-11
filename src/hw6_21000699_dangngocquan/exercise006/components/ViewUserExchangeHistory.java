package hw6_21000699_dangngocquan.exercise006.components;

import hw6_21000699_dangngocquan.exercise005.components.base.Table;
import hw6_21000699_dangngocquan.exercise006.App;
import hw6_21000699_dangngocquan.exercise006.Config;
import hw6_21000699_dangngocquan.exercise006.components.base.Panel;
import hw6_21000699_dangngocquan.exercise006.models.SharesBuyOrder;
import hw6_21000699_dangngocquan.exercise006.models.SharesOrder;

import java.util.List;

public class ViewUserExchangeHistory extends Panel {
    public ViewUserExchangeHistory() {
        super(
                Config.WIDTH_VIEW_USER_CONTROLLER,
                Config.HEIGHT_VIEW_SHARES_EXCHANGE,
                Config.WIDTH - Config.WIDTH_VIEW_USER_CONTROLLER,
                Config.HEIGHT - Config.HEIGHT_VIEW_SHARES_EXCHANGE,
                Config.GRAY_2, null, ""
        );
        addViews();
    }

    public void addPanels() {
        add(new Panel(
                0, 0, 200, 40, getBackgroundColor(), null, "Exchange History"
        ));
    }

    public void addViews() {
        removeAll();
        addPanels();
        List<SharesOrder> history = App.userExchangeHistory;
        Object[][] dataRows = new Object[history.size()][2];
        Object[] columnNames = new Object[] {"Order", "Content"};
        for (int i = 0; i < history.size(); i++) {
            int j = history.size() - 1 - i;
            dataRows[j][0] = j + 1;
            dataRows[j][1] = ((j % 2 == 0)? "[AUTO] " : "[USER] ")
                    + ((history.get(i) instanceof SharesBuyOrder)? "Selt " : "Bought ")
                    + history.get(i);
        }
        Table tableExchangeHistory = new Table(
                20, 40, getWidth() - 40, getHeight() - 60,
                dataRows, columnNames
        );
        tableExchangeHistory.getTable().getColumnModel().getColumn(0).setMaxWidth(100);
        tableExchangeHistory.getTable().getColumnModel().getColumn(0).setMinWidth(100);
        tableExchangeHistory.getTable().setRowHeight(30);
        add(tableExchangeHistory);
    }
}
