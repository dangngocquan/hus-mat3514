package hw8_21000699_dangngocquan.base;

public class UndirectedUnweightedGraph<V> extends GraphUsingAdjacencyMatrix<V, Void> {
    public UndirectedUnweightedGraph() {
        super(false, false);
    }

    public boolean insertEdge(VertexInterface<V> u, VertexInterface<V> v) {
        return insertEdge(u, v, null);
    }
}
