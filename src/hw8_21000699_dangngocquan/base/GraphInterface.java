package hw8_21000699_dangngocquan.base;

public interface GraphInterface<V, E> {
    boolean isDirectedGraph();

    boolean isWeightedGraph();

    int degree();


    /*
    * Returns the number of vertices of the graph.
    * */
    int numberVertices();

    /*
    * Returns an iteration of all the vertices of the graph.
    * */
    Iterable<VertexInterface<V>> vertices();

    VertexInterface<V> getVertex(int i);

    /*
    * Returns the number of edges of the graph.
    * */
    int numberEdges();

    /*
    * Returns an iteration of all the edges of the graph
    * */
    Iterable<EdgeInterface<E>> edges();

    Iterable<EdgeInterface<E>> adjacencyEdges(VertexInterface<V> u);

    Iterable<VertexInterface<V>> adjacencyVertices(VertexInterface<V> u);

    /*
    * Returns the edge from vertex u to vertex v, if one exists;
    * otherwise return null. For an undirected graph, there is no
    * difference between getEdge(u, v) and getEdge(v, u)
    * */
    EdgeInterface<E> getEdge(VertexInterface<V> u, VertexInterface<V> v);

    boolean isExistEdge(VertexInterface<V> u, VertexInterface<V> v);

    /*
    * Returns an array containing the two endpoint vertices of
    * edge e. If the graph is directed, the first vertex is the origin
    * and the second is the destination.
    * */
    VertexInterface<V>[] endVertices(EdgeInterface<E> e);

    /*
    * For edge e incident to vertex v, returns the other vertex of
    * the edge; an error occurs if e is not incident to v.
    * */
    VertexInterface<V> opposite(VertexInterface<V> v, EdgeInterface<E> e);

    /*
    * Returns the number of outgoing edges from vert
    * */
    int outDegree(VertexInterface<V> v);

    /*
    * Returns the number of incoming edges to vertex v. For
    * an undirected graph, this returns the same value as does
    * outDegree(v)
    * */
    int inDegree(VertexInterface<V> v);

    /*
    * Returns an iteration of all outgoing edges from vertex v.
    * */
    Iterable<EdgeInterface<E>> outgoingEdges(VertexInterface<V> v);

    /*
    * Returns an iteration of all incoming edges to vertex v. For
    * an undirected graph, this returns the same collection as
    * does outgoingEdges(v).
    * */
    Iterable<EdgeInterface<E>> incomingEdges(VertexInterface<V> v);

    /*
    * Creates and returns a new Vertex storing element x.
    * */
    boolean insertVertex(V x);

    /*
    * Creates and returns a new Edge from vertex u to vertex v,
    * storing element x; an error occurs if there already exists an
    * edge from u to v.
    * */
    boolean insertEdge(VertexInterface<V> u, VertexInterface<V> v, E x);

    /*
    * Removes vertex v and all its incident edges from the graph
    * */
    boolean removeVertex(VertexInterface<V> v);

    /*
    * Removes edge e from the graph.
    * */
    boolean removeEdge(EdgeInterface<E> e);

}
