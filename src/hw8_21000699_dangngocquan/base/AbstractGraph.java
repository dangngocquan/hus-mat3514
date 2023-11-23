package hw8_21000699_dangngocquan.base;

public abstract class AbstractGraph<V, E> implements GraphInterface<V, E> {
    protected final boolean isDirectedGraph;
    protected final boolean isWeightedGraph;

    public AbstractGraph(boolean isDirectedGraph, boolean isWeightedGraph) {
        this.isDirectedGraph = isDirectedGraph;
        this.isWeightedGraph = isWeightedGraph;
    }

    @Override
    public boolean isDirectedGraph() {
        return isDirectedGraph;
    }

    @Override
    public boolean isWeightedGraph() {
        return isWeightedGraph;
    }
}
