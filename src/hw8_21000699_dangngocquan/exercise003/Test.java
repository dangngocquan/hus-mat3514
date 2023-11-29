package hw8_21000699_dangngocquan.exercise003;

import hw8_21000699_dangngocquan.base.DirectedWeightedGraph;
import hw8_21000699_dangngocquan.base.VertexInterface;

public class Test {
    public void run() {
        DirectedWeightedGraph<String, Integer> graph = new DirectedWeightedGraph<>();
        printHeader(graph);
        testInsertVertex(graph, "A");
        testInsertVertex(graph, "B");
        testInsertVertex(graph, "C");
        testInsertVertex(graph, "D");
        testInsertEdge(graph, graph.getVertex(0), graph.getVertex(1), 4);
        testInsertEdge(graph, graph.getVertex(0), graph.getVertex(2), 9);
        testInsertEdge(graph, graph.getVertex(0), graph.getVertex(3), 12);
        testInsertEdge(graph, graph.getVertex(1), graph.getVertex(3), 23);
        testInsertEdge(graph, graph.getVertex(2), graph.getVertex(3), 10);
        testDegree(graph);
        testNumberVertices(graph);
        testNumberEdges(graph);
        testExistEdge(graph, graph.getVertex(0), graph.getVertex(2));
        testExistEdge(graph, graph.getVertex(2), graph.getVertex(0));
        testAdjacencyVertices(graph, graph.getVertex(0));
        testAdjacencyEdges(graph, graph.getVertex(0));
    }

    public void printHeader(DirectedWeightedGraph<String, Integer> graph) {
        System.out.println(graph.getClass().getSimpleName());
        System.out.println();
        System.out.printf(
                "%-50s  %-30s  %-100s\n",
                "Action",
                "Return",
                "Adjacency matrix of graph"
        );
        System.out.println("-".repeat(184));
    }

    private void testInsertVertex(
            DirectedWeightedGraph<String, Integer> graph,
            String x) {
        System.out.printf(
                "%-50s  %-30s  %-60s\n",
                "insertVertex(x=" + x + ")",
                graph.insertVertex(x),
                graph.toString().replace("\n", "\n" + " ".repeat(84))
        );
    }

    private void testInsertEdge(
            DirectedWeightedGraph<String, Integer> graph,
            VertexInterface<String> u,
            VertexInterface<String> v,
            Integer x) {
        System.out.printf(
                "%-50s  %-30s  %-60s\n",
                String.format("insertEdge(u=%s,v=%s)", u, v),
                graph.insertEdge(u, v, x),
                graph.toString().replace("\n", "\n" + " ".repeat(84))
        );
    }

    private void testNumberVertices(
            DirectedWeightedGraph<String, Integer> graph) {
        System.out.printf(
                "%-50s  %-30s  %-60s\n",
                "numberVertices()",
                graph.numberVertices(),
                "~"
        );
    }

    private void testNumberEdges(
            DirectedWeightedGraph<String, Integer> graph) {
        System.out.printf(
                "%-50s  %-30s  %-60s\n",
                "numberEdges()",
                graph.numberEdges(),
                "~"
        );
    }

    private void testDegree(
            DirectedWeightedGraph<String, Integer> graph) {
        System.out.printf(
                "%-50s  %-30s  %-60s\n",
                "degree()",
                graph.degree(),
                "~"
        );
    }

    private void testExistEdge(
            DirectedWeightedGraph<String, Integer> graph,
            VertexInterface<String> u,
            VertexInterface<String> v)  {
        System.out.printf(
                "%-50s  %-30s  %-60s\n",
                String.format("isExistEdge(%s,%s)", u, v),
                graph.isExistEdge(u, v),
                "~"
        );
    }

    private void testAdjacencyVertices(
            DirectedWeightedGraph<String, Integer> graph,
            VertexInterface<String> u) {
        System.out.printf(
                "%-50s  %-30s  %-60s\n",
                String.format("adjacencyVertices(%s)", u),
                graph.adjacencyVertices(u),
                "~"
        );
    }

    private void testAdjacencyEdges(
            DirectedWeightedGraph<String, Integer> graph,
            VertexInterface<String> u) {
        System.out.printf(
                "%-50s  %-30s  %-60s\n",
                String.format("adjacencyVertices(%s)", u),
                graph.adjacencyEdges(u),
                "~"
        );
    }


}
