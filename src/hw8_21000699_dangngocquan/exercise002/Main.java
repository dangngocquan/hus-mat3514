package hw8_21000699_dangngocquan.exercise002;

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

insertEdge(u=Vertex[x=A],v=Vertex[x=B])             true                                                | 0(Vertex[x=A])      1(Vertex[x=B])      2(null)             3(null)
                                                                                    -----------------------------------------------------------------------------------------------------
                                                                                    0(Vertex[x=A])      | null                Edge[x=4]           null                null
                                                                                    1(Vertex[x=B])      | null                null                null                null
                                                                                    2(null)             | null                null                null                null
                                                                                    3(null)             | null                null                null                null

insertVertex(x=C)                                   true                                                | 0(Vertex[x=A])      1(Vertex[x=B])      2(Vertex[x=C])      3(null)
                                                                                    -----------------------------------------------------------------------------------------------------
                                                                                    0(Vertex[x=A])      | null                Edge[x=4]           null                null
                                                                                    1(Vertex[x=B])      | null                null                null                null
                                                                                    2(Vertex[x=C])      | null                null                null                null
                                                                                    3(null)             | null                null                null                null

insertVertex(x=D)                                   true                                                | 0(Vertex[x=A])      1(Vertex[x=B])      2(Vertex[x=C])      3(Vertex[x=D])
                                                                                    -----------------------------------------------------------------------------------------------------
                                                                                    0(Vertex[x=A])      | null                Edge[x=4]           null                null
                                                                                    1(Vertex[x=B])      | null                null                null                null
                                                                                    2(Vertex[x=C])      | null                null                null                null
                                                                                    3(Vertex[x=D])      | null                null                null                null

insertEdge(u=Vertex[x=A],v=Vertex[x=C])             true                                                | 0(Vertex[x=A])      1(Vertex[x=B])      2(Vertex[x=C])      3(Vertex[x=D])
                                                                                    -----------------------------------------------------------------------------------------------------
                                                                                    0(Vertex[x=A])      | null                Edge[x=4]           Edge[x=2]           null
                                                                                    1(Vertex[x=B])      | null                null                null                null
                                                                                    2(Vertex[x=C])      | null                null                null                null
                                                                                    3(Vertex[x=D])      | null                null                null                null

insertEdge(u=Vertex[x=A],v=Vertex[x=D])             true                                                | 0(Vertex[x=A])      1(Vertex[x=B])      2(Vertex[x=C])      3(Vertex[x=D])
                                                                                    -----------------------------------------------------------------------------------------------------
                                                                                    0(Vertex[x=A])      | null                Edge[x=4]           Edge[x=2]           Edge[x=5]
                                                                                    1(Vertex[x=B])      | null                null                null                null
                                                                                    2(Vertex[x=C])      | null                null                null                null
                                                                                    3(Vertex[x=D])      | null                null                null                null

insertEdge(u=Vertex[x=B],v=Vertex[x=C])             true                                                | 0(Vertex[x=A])      1(Vertex[x=B])      2(Vertex[x=C])      3(Vertex[x=D])
                                                                                    -----------------------------------------------------------------------------------------------------
                                                                                    0(Vertex[x=A])      | null                Edge[x=4]           Edge[x=2]           Edge[x=5]
                                                                                    1(Vertex[x=B])      | null                null                Edge[x=3]           null
                                                                                    2(Vertex[x=C])      | null                null                null                null
                                                                                    3(Vertex[x=D])      | null                null                null                null

removeVertex(v=Vertex[x=C])                         true                                                | 0(Vertex[x=A])      1(Vertex[x=B])      2(Vertex[x=D])      3(null)
                                                                                    -----------------------------------------------------------------------------------------------------
                                                                                    0(Vertex[x=A])      | null                Edge[x=4]           Edge[x=5]           null
                                                                                    1(Vertex[x=B])      | null                null                null                null
                                                                                    2(Vertex[x=D])      | null                null                null                null
                                                                                    3(null)             | null                null                null                null

removeEdge(e=Edge[x=5])                             true                                                | 0(Vertex[x=A])      1(Vertex[x=B])      2(Vertex[x=D])      3(null)
                                                                                    -----------------------------------------------------------------------------------------------------
                                                                                    0(Vertex[x=A])      | null                Edge[x=4]           null                null
                                                                                    1(Vertex[x=B])      | null                null                null                null
                                                                                    2(Vertex[x=D])      | null                null                null                null
                                                                                    3(null)             | null                null                null                null

opposite(v=Vertex[x=B],e=null)                      null                                                | 0(Vertex[x=A])      1(Vertex[x=B])      2(Vertex[x=D])      3(null)
                                                                                    -----------------------------------------------------------------------------------------------------
                                                                                    0(Vertex[x=A])      | null                Edge[x=4]           null                null
                                                                                    1(Vertex[x=B])      | null                null                null                null
                                                                                    2(Vertex[x=D])      | null                null                null                null
                                                                                    3(null)             | null                null                null                null

*/
    }
}
