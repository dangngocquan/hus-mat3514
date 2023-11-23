package hw8_21000699_dangngocquan.exercise001;

public class Main {
    public static void main(String[] args) {
        new Test().run();

/*

UndirectedUnweightedGraph

Action                                              Return                          Adjacency matrix of graph
----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
insertVertex(x=1)                                   true                                                | 0(Vertex[x=1])      1(null)             2(null)             3(null)
                                                                                    -----------------------------------------------------------------------------------------------------
                                                                                    0(Vertex[x=1])      | 0                   0                   0                   0
                                                                                    1(null)             | 0                   0                   0                   0
                                                                                    2(null)             | 0                   0                   0                   0
                                                                                    3(null)             | 0                   0                   0                   0

insertVertex(x=5)                                   true                                                | 0(Vertex[x=1])      1(Vertex[x=5])      2(null)             3(null)
                                                                                    -----------------------------------------------------------------------------------------------------
                                                                                    0(Vertex[x=1])      | 0                   0                   0                   0
                                                                                    1(Vertex[x=5])      | 0                   0                   0                   0
                                                                                    2(null)             | 0                   0                   0                   0
                                                                                    3(null)             | 0                   0                   0                   0

insertEdge(u=Vertex[x=1],v=Vertex[x=5])             true                                                | 0(Vertex[x=1])      1(Vertex[x=5])      2(null)             3(null)
                                                                                    -----------------------------------------------------------------------------------------------------
                                                                                    0(Vertex[x=1])      | 0                   1                   0                   0
                                                                                    1(Vertex[x=5])      | 1                   0                   0                   0
                                                                                    2(null)             | 0                   0                   0                   0
                                                                                    3(null)             | 0                   0                   0                   0

insertVertex(x=7)                                   true                                                | 0(Vertex[x=1])      1(Vertex[x=5])      2(Vertex[x=7])      3(null)
                                                                                    -----------------------------------------------------------------------------------------------------
                                                                                    0(Vertex[x=1])      | 0                   1                   0                   0
                                                                                    1(Vertex[x=5])      | 1                   0                   0                   0
                                                                                    2(Vertex[x=7])      | 0                   0                   0                   0
                                                                                    3(null)             | 0                   0                   0                   0

insertVertex(x=2)                                   true                                                | 0(Vertex[x=1])      1(Vertex[x=5])      2(Vertex[x=7])      3(Vertex[x=2])
                                                                                    -----------------------------------------------------------------------------------------------------
                                                                                    0(Vertex[x=1])      | 0                   1                   0                   0
                                                                                    1(Vertex[x=5])      | 1                   0                   0                   0
                                                                                    2(Vertex[x=7])      | 0                   0                   0                   0
                                                                                    3(Vertex[x=2])      | 0                   0                   0                   0

insertEdge(u=Vertex[x=1],v=Vertex[x=7])             true                                                | 0(Vertex[x=1])      1(Vertex[x=5])      2(Vertex[x=7])      3(Vertex[x=2])
                                                                                    -----------------------------------------------------------------------------------------------------
                                                                                    0(Vertex[x=1])      | 0                   1                   1                   0
                                                                                    1(Vertex[x=5])      | 1                   0                   0                   0
                                                                                    2(Vertex[x=7])      | 1                   0                   0                   0
                                                                                    3(Vertex[x=2])      | 0                   0                   0                   0

insertEdge(u=Vertex[x=1],v=Vertex[x=2])             true                                                | 0(Vertex[x=1])      1(Vertex[x=5])      2(Vertex[x=7])      3(Vertex[x=2])
                                                                                    -----------------------------------------------------------------------------------------------------
                                                                                    0(Vertex[x=1])      | 0                   1                   1                   1
                                                                                    1(Vertex[x=5])      | 1                   0                   0                   0
                                                                                    2(Vertex[x=7])      | 1                   0                   0                   0
                                                                                    3(Vertex[x=2])      | 1                   0                   0                   0

insertEdge(u=Vertex[x=5],v=Vertex[x=7])             true                                                | 0(Vertex[x=1])      1(Vertex[x=5])      2(Vertex[x=7])      3(Vertex[x=2])
                                                                                    -----------------------------------------------------------------------------------------------------
                                                                                    0(Vertex[x=1])      | 0                   1                   1                   1
                                                                                    1(Vertex[x=5])      | 1                   0                   1                   0
                                                                                    2(Vertex[x=7])      | 1                   1                   0                   0
                                                                                    3(Vertex[x=2])      | 1                   0                   0                   0

removeVertex(v=Vertex[x=7])                         true                                                | 0(Vertex[x=1])      1(Vertex[x=5])      2(Vertex[x=2])      3(null)
                                                                                    -----------------------------------------------------------------------------------------------------
                                                                                    0(Vertex[x=1])      | 0                   1                   1                   0
                                                                                    1(Vertex[x=5])      | 1                   0                   0                   0
                                                                                    2(Vertex[x=2])      | 1                   0                   0                   0
                                                                                    3(null)             | 0                   0                   0                   0

removeEdge(e=Edge[x=null])                          true                                                | 0(Vertex[x=1])      1(Vertex[x=5])      2(Vertex[x=2])      3(null)
                                                                                    -----------------------------------------------------------------------------------------------------
                                                                                    0(Vertex[x=1])      | 0                   1                   0                   0
                                                                                    1(Vertex[x=5])      | 1                   0                   0                   0
                                                                                    2(Vertex[x=2])      | 0                   0                   0                   0
                                                                                    3(null)             | 0                   0                   0                   0

opposite(v=Vertex[x=5],e=Edge[x=null])              Vertex[x=1]                                         | 0(Vertex[x=1])      1(Vertex[x=5])      2(Vertex[x=2])      3(null)
                                                                                    -----------------------------------------------------------------------------------------------------
                                                                                    0(Vertex[x=1])      | 0                   1                   0                   0
                                                                                    1(Vertex[x=5])      | 1                   0                   0                   0
                                                                                    2(Vertex[x=2])      | 0                   0                   0                   0
                                                                                    3(null)             | 0                   0                   0                   0

*/

    }


}
