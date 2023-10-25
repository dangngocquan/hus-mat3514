package hw5_21000699_dangngocquan.exercise004.models;

public interface GeneralTreeInterface<T> {
    T root();
    int size();
    int size(T p);
    boolean isEmpty();
    T parent(T p);
}
