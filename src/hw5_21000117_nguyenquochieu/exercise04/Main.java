package hw5_21000117_nguyenquochieu.exercise04;

public class Main {
    public static void main(String[] args) {
        GeneralTreeNode<Double> root = new GeneralTreeNode<>(0.0);
        for (int i = 1; i < 4; i++) root.addChild(new GeneralTreeNode<>((double) i));
        for (int i = 7; i < 10; i++) root.getChild().get(0).addChild(new GeneralTreeNode<>((double) i));
        for (int i = 5; i < 7; i++) root.getChild().get(1).addChild(new GeneralTreeNode<>((double) i));
        for (int i = 20; i < 24; i++)
            root.getChild().get(1).getChild().get(1).addChild(new GeneralTreeNode<>((double) i));
        GeneralTreeConverter<Double> converter = new GeneralTreeConverter();
        System.out.println("General tree before converting: ");
        converter.print(root);
        GeneralTreeNode<Double> newRoot = converter.convert(root, 20.0);
        System.out.println("General tree after converting: ");
        System.out.println("New root: " + newRoot);
        converter.print(newRoot);
    }
}
