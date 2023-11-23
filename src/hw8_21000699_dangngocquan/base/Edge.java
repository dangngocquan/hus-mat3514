package hw8_21000699_dangngocquan.base;

public class Edge<E> implements EdgeInterface<E> {
    public E element;
    public VertexInterface<?>[] endVertices;

    public Edge(VertexInterface<?> u, VertexInterface<?> v, E element) {
        this.element = element;
        this.endVertices = new VertexInterface<?>[] {u, v};
    }

    @Override
    public E getElement() {
        return null;
    }

    @Override
    public VertexInterface<?>[] getEndVertices() {
        return endVertices;
    }

    @Override
    public String toString() {
        return "Edge[x=" + element + "]";
    }
}
