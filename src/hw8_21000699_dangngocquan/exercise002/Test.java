package hw8_21000699_dangngocquan.exercise002;

import hw8_21000699_dangngocquan.base.DirectedWeightedGraph;
import hw8_21000699_dangngocquan.base.EdgeInterface;
import hw8_21000699_dangngocquan.base.VertexInterface;

public class Test {
    public void run() {
        DirectedWeightedGraph<String, Integer> graph = new DirectedWeightedGraph<>();
        printHeader(graph);
        testInsertVertex(graph, "A");
        testInsertVertex(graph, "B");
        testInsertEdge(graph, graph.getVertex(0), graph.getVertex(1), 4);
        testInsertVertex(graph, "C");
        testInsertVertex(graph, "D");
        testInsertEdge(graph, graph.getVertex(0), graph.getVertex(2), 2);
        testInsertEdge(graph, graph.getVertex(0), graph.getVertex(3), 5);
        testInsertEdge(graph, graph.getVertex(1), graph.getVertex(2), 3);
        testRemoveVertex(graph, graph.getVertex(2));
        testRemoveEdge(graph, graph.getEdge(graph.getVertex(0), graph.getVertex(2)));
        testOpposite(graph,
                graph.getVertex(1),
                graph.getEdge(graph.getVertex(1), graph.getVertex(0))
        );
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

    private void testRemoveVertex(
            DirectedWeightedGraph<String, Integer> graph,
            VertexInterface<String> v) {
        System.out.printf(
                "%-50s  %-30s  %-60s\n",
                String.format("removeVertex(v=%s)", v),
                graph.removeVertex(v),
                graph.toString().replace("\n", "\n" + " ".repeat(84))
        );
    }

    private void testRemoveEdge(
            DirectedWeightedGraph<String, Integer> graph,
            EdgeInterface<Integer> e) {
        System.out.printf(
                "%-50s  %-30s  %-60s\n",
                String.format("removeEdge(e=%s)", e),
                graph.removeEdge(e),
                graph.toString().replace("\n", "\n" + " ".repeat(84))
        );
    }

    private void testOpposite(
            DirectedWeightedGraph<String, Integer> graph,
            VertexInterface<String> v,
            EdgeInterface<Integer> e) {
        System.out.printf(
                "%-50s  %-30s  %-60s\n",
                String.format("opposite(v=%s,e=%s)", v, e),
                graph.opposite(v, e),
                graph.toString().replace("\n", "\n" + " ".repeat(84))
        );
    }
}