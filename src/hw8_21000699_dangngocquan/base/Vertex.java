package hw8_21000699_dangngocquan.base;

public class Vertex<V> implements VertexInterface<V> {
    public V element;

    public Vertex(V element) {
        this.element = element;
    }

    @Override
    public V getElement() {
        return null;
    }

    @Override
    public String toString() {
        return "Vertex[x=" + element + "]";
    }
}
