package hw8_21000699_dangngocquan.exercise003;

public class Main {
    public static void main(String[] args) {
        new Test().run();

/*

DirectedWeightedGraph

Action                                              Return                          Adjacency matrix of graph
----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
insertVertex(x=A)                                   true                                                | 0(Vertex[x=A])      1(null)             2(null)             3(null)
                                                                                    -----------------------------------------------------------------------------------------------------
                                                                                    0(Vertex[x=A])      | null                null                null                null
                                                                                    1(null)             | null                null                null                null
                                                                                    2(null)             | null                null                null                null
                                                                                    3(null)             | null                null                null                null

insertVertex(x=B)                                   true                                                | 0(Vertex[x=A])      1(Vertex[x=B])      2(null)             3(null)
                                                                                    -----------------------------------------------------------------------------------------------------
                                                                                    0(Vertex[x=A])      | null                null                null                null
                                                                                    1(Vertex[x=B])      | null                null                null                null
                                                                                    2(null)             | null                null                null                null
                                                                                    3(null)             | null                null                null                null

insertVertex(x=C)                                   true                                                | 0(Vertex[x=A])      1(Vertex[x=B])      2(Vertex[x=C])      3(null)
                                                                                    -----------------------------------------------------------------------------------------------------
                                                                                    0(Vertex[x=A])      | null                null                null                null
                                                                                    1(Vertex[x=B])      | null                null                null                null
                                                                                    2(Vertex[x=C])      | null                null                null                null
                                                                                    3(null)             | null                null                null                null

insertVertex(x=D)                                   true                                                | 0(Vertex[x=A])      1(Vertex[x=B])      2(Vertex[x=C])      3(Vertex[x=D])
                                                                                    -----------------------------------------------------------------------------------------------------
                                                                                    0(Vertex[x=A])      | null                null                null                null
                                                                                    1(Vertex[x=B])      | null                null                null                null
                                                                                    2(Vertex[x=C])      | null                null                null                null
                                                                                    3(Vertex[x=D])      | null                null                null                null

insertEdge(u=Vertex[x=A],v=Vertex[x=B])             true                                                | 0(Vertex[x=A])      1(Vertex[x=B])      2(Vertex[x=C])      3(Vertex[x=D])
                                                                                    -----------------------------------------------------------------------------------------------------
                                                                                    0(Vertex[x=A])      | null                Edge[x=4]           null                null
                                                                                    1(Vertex[x=B])      | null                null                null                null
                                                                                    2(Vertex[x=C])      | null                null                null                null
                                                                                    3(Vertex[x=D])      | null                null                null                null

insertEdge(u=Vertex[x=A],v=Vertex[x=C])             true                                                | 0(Vertex[x=A])      1(Vertex[x=B])      2(Vertex[x=C])      3(Vertex[x=D])
                                                                                    -----------------------------------------------------------------------------------------------------
                                                                                    0(Vertex[x=A])      | null                Edge[x=4]           Edge[x=9]           null
                                                                                    1(Vertex[x=B])      | null                null                null                null
                                                                                    2(Vertex[x=C])      | null                null                null                null
                                                                                    3(Vertex[x=D])      | null                null                null                null

insertEdge(u=Vertex[x=A],v=Vertex[x=D])             true                                                | 0(Vertex[x=A])      1(Vertex[x=B])      2(Vertex[x=C])      3(Vertex[x=D])
                                                                                    -----------------------------------------------------------------------------------------------------
                                                                                    0(Vertex[x=A])      | null                Edge[x=4]           Edge[x=9]           Edge[x=12]
                                                                                    1(Vertex[x=B])      | null                null                null                null
                                                                                    2(Vertex[x=C])      | null                null                null                null
                                                                                    3(Vertex[x=D])      | null                null                null                null

insertEdge(u=Vertex[x=B],v=Vertex[x=D])             true                                                | 0(Vertex[x=A])      1(Vertex[x=B])      2(Vertex[x=C])      3(Vertex[x=D])
                                                                                    -----------------------------------------------------------------------------------------------------
                                                                                    0(Vertex[x=A])      | null                Edge[x=4]           Edge[x=9]           Edge[x=12]
                                                                                    1(Vertex[x=B])      | null                null                null                Edge[x=23]
                                                                                    2(Vertex[x=C])      | null                null                null                null
                                                                                    3(Vertex[x=D])      | null                null                null                null

insertEdge(u=Vertex[x=C],v=Vertex[x=D])             true                                                | 0(Vertex[x=A])      1(Vertex[x=B])      2(Vertex[x=C])      3(Vertex[x=D])
                                                                                    -----------------------------------------------------------------------------------------------------
                                                                                    0(Vertex[x=A])      | null                Edge[x=4]           Edge[x=9]           Edge[x=12]
                                                                                    1(Vertex[x=B])      | null                null                null                Edge[x=23]
                                                                                    2(Vertex[x=C])      | null                null                null                Edge[x=10]
                                                                                    3(Vertex[x=D])      | null                null                null                null

degree()                                            10                              ~
numberVertices()                                    4                               ~
numberEdges()                                       5                               ~
isExistEdge(Vertex[x=A],Vertex[x=C])                true                            ~
isExistEdge(Vertex[x=C],Vertex[x=A])                false                           ~
adjacencyVertices(Vertex[x=A])                      [Vertex[x=B], Vertex[x=C], Vertex[x=D]]  ~
adjacencyVertices(Vertex[x=A])                      [Edge[x=4], Edge[x=9], Edge[x=12]]  ~

*/
    }
}
