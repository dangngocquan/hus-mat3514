package hw8_21000699_dangngocquan.base;

import java.util.*;

public class GraphUsingAdjacencyMatrix<V, E> extends AbstractGraph<V, E> {
    protected final int DEFAULT_SIZE = 4;
    public EdgeInterface<E>[][] adjacencyMatrix;
    public Map<VertexInterface<V>, Integer> vertices;

    public GraphUsingAdjacencyMatrix(boolean isDirectedGraph, boolean isWeightedGraph) {
        super(isDirectedGraph, isWeightedGraph);
        adjacencyMatrix = new EdgeInterface[DEFAULT_SIZE][DEFAULT_SIZE];
        vertices = new LinkedHashMap<>();
    }

    @Override
    public int numberVertices() {
        return vertices.size();
    }

    @Override
    public Iterable<VertexInterface<V>> vertices() {
        return vertices.keySet();
    }

    @Override
    public VertexInterface<V> getVertex(int i) {
        if (i >= numberVertices()) return null;
        Iterator<VertexInterface<V>> iterator = vertices().iterator();
        while (i-- > 0) iterator.next();
        return iterator.next();
    }

    @Override
    public int numberEdges() {
        int count = 0;
        for (EdgeInterface<E>[] edges : adjacencyMatrix) {
            for (EdgeInterface<E> edge : edges) {
                if (edge != null) count++;
            }
        }
        return isDirectedGraph? count : count / 2;
    }

    @Override
    public Iterable<EdgeInterface<E>> edges() {
        Set<EdgeInterface<E>> set = new HashSet<>();
        for (EdgeInterface<E>[] edges : adjacencyMatrix) {
            for (EdgeInterface<E> edge : edges) {
                if (edge != null) {
                    set.add(edge);
                }
            }
        }
        return set;
    }

    @Override
    public EdgeInterface<E> getEdge(VertexInterface<V> u, VertexInterface<V> v) {
        if (!vertices.containsKey(u) || !vertices.containsKey(v)) return null;
        return adjacencyMatrix[vertices.get(u)][vertices.get(v)];
    }

    @Override
    public VertexInterface<V>[] endVertices(EdgeInterface<E> e) {
        if (e == null) return null;
        for (EdgeInterface<E>[] edges : adjacencyMatrix) {
            for (EdgeInterface<E> edge : edges) {
                if (e == edge) {
                    return new VertexInterface[] {
                            edge.getEndVertices()[0],
                            edge.getEndVertices()[1],
                    };
                }
            }
        }
        return null;
    }

    @Override
    public VertexInterface<V> opposite(VertexInterface<V> v, EdgeInterface<E> e) {
       VertexInterface<V>[] endVertices = endVertices(e);
       if (endVertices == null) return null;
       if (v == endVertices[0]) return endVertices[1];
       if (v == endVertices[1]) return endVertices[0];
       return null;
    }

    @Override
    public int outDegree(VertexInterface<V> v) {
        if (v == null || !vertices.containsKey(v)) return 0;
        int count = 0;
        for (EdgeInterface<E> edge : adjacencyMatrix[vertices.get(v)]) {
            if (edge != null) count++;
        }
        return count;
    }

    @Override
    public int inDegree(VertexInterface<V> v) {
        if (v == null || !vertices.containsKey(v)) return 0;
        int count = 0;
        int j = vertices.get(v);
        for (int i = 0; i < vertices.size(); i++) {
            if (adjacencyMatrix[i][j] != null) count++;
        }
        return count;
    }

    @Override
    public Iterable<EdgeInterface<E>> outgoingEdges(VertexInterface<V> v) {
        if (v == null || !vertices.containsKey(v)) return null;
        Set<EdgeInterface<E>> edges = new HashSet<>();
        for (EdgeInterface<E> edge : adjacencyMatrix[vertices.get(v)]) {
            if (edge != null) edges.add(edge);
        }
        return edges;
    }

    @Override
    public Iterable<EdgeInterface<E>> incomingEdges(VertexInterface<V> v) {
        if (v == null || !vertices.containsKey(v)) return null;
        Set<EdgeInterface<E>> edges = new HashSet<>();
        int j = vertices.get(v);
        for (int i = 0; i < vertices.size(); i++) {
            if (adjacencyMatrix[i][j] != null) edges.add(adjacencyMatrix[i][j]);
        }
        return edges;
    }

    @Override
    public boolean insertVertex(V x) {
        try {
            if (adjacencyMatrix.length == vertices.size()) enlarge();
            vertices.put(new Vertex<>(x), vertices.size());
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public boolean removeVertex(VertexInterface<V> v) {
        if (v == null || !vertices.containsKey(v)) return false;
        int index = vertices.get(v);

        // Update row of matrix
        for (int i = index; i < vertices.size() - 1; i++) {
            adjacencyMatrix[i] = adjacencyMatrix[i+1];
        }
        adjacencyMatrix[adjacencyMatrix.length - 1] = new EdgeInterface[adjacencyMatrix.length];

        // Update column of matrix
        for (int i = 0; i < adjacencyMatrix.length; i++) {
            for (int j = index; j < adjacencyMatrix.length - 1; j++) {
                adjacencyMatrix[i][j] = adjacencyMatrix[i][j+1];
            }
            adjacencyMatrix[i][adjacencyMatrix.length - 1] = null;
        }

        // Update map vertices
        vertices.remove(v);
        Iterator<VertexInterface<V>> iterator = vertices.keySet().iterator();
        int i = 0;
        while (iterator.hasNext()) vertices.put(iterator.next(), i++);
        return true;
    }

    @Override
    public boolean insertEdge(VertexInterface<V> u, VertexInterface<V> v, E x) {
        if (u == null || v == null) return false;
        if (!vertices.containsKey(u) || !vertices.containsKey(v)) return false;
        adjacencyMatrix[vertices.get(u)][vertices.get(v)] = new Edge<>(u, v, x);
        if (!isDirectedGraph)
            adjacencyMatrix[vertices.get(v)][vertices.get(u)]
                    = adjacencyMatrix[vertices.get(u)][vertices.get(v)];
        return true;
    }


    @Override
    public boolean removeEdge(EdgeInterface<E> e) {
        if (e == null) return false;
        boolean result = false;
        for (int i = 0; i < adjacencyMatrix.length; i++) {
            for (int j = 0; j < adjacencyMatrix.length; j++) {
                if (adjacencyMatrix[i][j] == e) {
                    adjacencyMatrix[i][j] = null;
                    result = true;
                }
            }
        }
        return result;
    }

    protected void enlarge() {
        adjacencyMatrix = Arrays.copyOf(adjacencyMatrix, adjacencyMatrix.length * 2);
        for (int i = 0; i < adjacencyMatrix.length; i++) {
            if (adjacencyMatrix[i] == null) {
                adjacencyMatrix[i] = new EdgeInterface[adjacencyMatrix.length];
            }
            adjacencyMatrix[i] = Arrays.copyOf(adjacencyMatrix[i], adjacencyMatrix.length);
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        int sizePerColumn = 20;
        sb.append(" ".repeat(sizePerColumn)).append("| ");
        Iterator<VertexInterface<V>> iterator = vertices().iterator();
        for (int i = 0; i < adjacencyMatrix.length; i++)
            sb.append(String.format(
                   String.format("%%-%ss", sizePerColumn),
                   String.format("%d(%s)", i, iterator.hasNext()? iterator.next() : null)
            ));
        sb.append("\n");
        sb.append("-".repeat(sizePerColumn * (adjacencyMatrix.length + 1) + 1)).append("\n");

        iterator = vertices().iterator();
        for (int i = 0; i < adjacencyMatrix.length; i++) {
            sb.append(String.format(
                    String.format("%%-%ds", sizePerColumn) + "| ",
                    String.format("%d(%s)", i, iterator.hasNext()? iterator.next() : null)
            ));
            for (int j = 0; j < adjacencyMatrix.length; j++) {
               sb.append(String.format(
                       String.format("%%-%ds", sizePerColumn),
                       isWeightedGraph? adjacencyMatrix[i][j] : adjacencyMatrix[i][j] == null? 0 : 1
                       ));
            }
            sb.append("\n");
        }
        return sb.toString();
    }
}
