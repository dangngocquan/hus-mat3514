package hw8_21000699_dangngocquan.base;

import java.util.LinkedHashSet;
import java.util.Set;

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

    @Override
    public int degree() {
        int degree = 0;
        for (VertexInterface<V> vertex : vertices()) {
            degree += outDegree(vertex) + inDegree(vertex);
        }
        return degree;
    }

    @Override
    public boolean isExistEdge(VertexInterface<V> u, VertexInterface<V> v) {
        return getEdge(u, v) != null;
    }

    @Override
    public Iterable<EdgeInterface<E>> adjacencyEdges(VertexInterface<V> u) {
        Set<EdgeInterface<E>> set = new LinkedHashSet<>();
        for (EdgeInterface<E> edge : edges()) {
            if (edge.getEndVertices()[0] == u || edge.getEndVertices()[1] == u) set.add(edge);
        }
        return set;
    }

    @Override
    public Iterable<VertexInterface<V>> adjacencyVertices(VertexInterface<V> u) {
        Set<VertexInterface<V>> set = new LinkedHashSet<>();
        for (EdgeInterface<E> edge : adjacencyEdges(u)) set.add(opposite(u, edge));
        return set;
    }
}
