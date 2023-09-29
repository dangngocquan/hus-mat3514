package hw3_21000699_dangngocquan.exercise004.components.components;

import hw3_21000699_dangngocquan.exercise004.App;
import hw3_21000699_dangngocquan.exercise004.Config;
import hw3_21000699_dangngocquan.exercise004.components.base.Panel;
import hw3_21000699_dangngocquan.exercise004.components.base.Table;
import hw3_21000699_dangngocquan.exercise004.models.MyList;
import hw3_21000699_dangngocquan.exercise004.models.WordCount;
import hw3_21000699_dangngocquan.exercise004.services.Service;

import javax.swing.*;
import java.awt.*;

public class ViewCountWords extends Panel {
    private Table tableWordCount;
    public ViewCountWords(
            int x, int y, int width, int height,
            Color backgroundColor,
            ImageIcon backgroundImage,
            String text) {
        super(x, y, width, height, backgroundColor, backgroundImage, text);
        addTableWordCount("");
    }

    public void addTableWordCount(String document) {
        if (tableWordCount != null) {
            remove(tableWordCount);
        }
        MyList<WordCount> listWord = Service.getListWord(document);
        Service.sortList(listWord);
        Object[][] rowData = new Object[listWord.size()][2];
        for (int i = 0; i < listWord.size(); i++) {
            WordCount wordCount = listWord.get(i);
            rowData[i][0] = wordCount.getWord();
            rowData[i][1] = wordCount.getCount();
        }
        Object[] columnNames = new Object[] {"Word", "Count"};
        tableWordCount = new Table(
                20, 20, getWidth() - 40, getHeight() - 40,
                rowData, columnNames
        );
        tableWordCount.getTable().getColumnModel().getColumn(1).setMaxWidth(Config.WIDTH / 6);
        tableWordCount.getTable().getColumnModel().getColumn(1).setMinWidth(Config.WIDTH / 6);
        tableWordCount.getTable().setRowHeight(30);
        add(tableWordCount);
    }

    public App getApp() {
        return (App) (Service.getFrame(this));
    }
}
