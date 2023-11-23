package hw8_21000699_dangngocquan.base;

public interface EdgeInterface<E> {
    /*
    * Returns element of edge
    * */
    E getElement();

    VertexInterface<?>[] getEndVertices();
}