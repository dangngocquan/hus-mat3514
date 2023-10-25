package hw5_21000699_dangngocquan.exercise004.components;

import hw5_21000699_dangngocquan.exercise004.Config;
import hw5_21000699_dangngocquan.exercise004.components.base.Button;
import hw5_21000699_dangngocquan.exercise004.models.LinkedGeneralTree;

public class PanelTreeNode extends Button {
    public String data;
    public LinkedGeneralTree.Node<PanelTreeNode> node;

    public PanelTreeNode(int row, int column, String data) {
        super(
                TreeView.GAP_X + column * (TreeView.GAP_X + Config.NODE_SIZE),
                TreeView.GAP_Y + row * (TreeView.GAP_Y + Config.NODE_SIZE),
                Config.NODE_SIZE, Config.NODE_SIZE,
                data
        );
        setFont(Config.MONOSPACE_BOLD_16);
        this.data = data;
    }

    public void setRowAndColumn(int row, int column) {
        setBounds(
                TreeView.GAP_X + column * (TreeView.GAP_X + Config.NODE_SIZE),
                TreeView.GAP_Y + row * (TreeView.GAP_Y + Config.NODE_SIZE),
                getWidth(),
                getHeight()
        );
    }
}
