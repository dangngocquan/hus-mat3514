package hw8_21000699_dangngocquan.exercise001;

import hw8_21000699_dangngocquan.base.*;

public class Test {
    public void run() {
        UndirectedUnweightedGraph<Integer> graph = new UndirectedUnweightedGraph<>();
        printHeader(graph);
        testInsertVertex(graph, 1);
        testInsertVertex(graph, 5);
        testInsertEdge(graph, graph.getVertex(0), graph.getVertex(1));
        testInsertVertex(graph, 7);
        testInsertVertex(graph, 2);
        testInsertEdge(graph, graph.getVertex(0), graph.getVertex(2));
        testInsertEdge(graph, graph.getVertex(0), graph.getVertex(3));
        testInsertEdge(graph, graph.getVertex(1), graph.getVertex(2));
        testRemoveVertex(graph, graph.getVertex(2));
        testRemoveEdge(graph, graph.getEdge(graph.getVertex(0), graph.getVertex(2)));
        testOpposite(graph,
                graph.getVertex(1),
                graph.getEdge(graph.getVertex(1), graph.getVertex(0))
        );
    }

    public void printHeader(UndirectedUnweightedGraph<Integer> graph) {
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
            UndirectedUnweightedGraph<Integer> graph,
            Integer x) {
        System.out.printf(
                "%-50s  %-30s  %-60s\n",
                "insertVertex(x=" + x + ")",
                graph.insertVertex(x),
                graph.toString().replace("\n", "\n" + " ".repeat(84))
        );
    }

    private void testInsertEdge(
            UndirectedUnweightedGraph<Integer> graph,
            VertexInterface<Integer> u,
            VertexInterface<Integer> v) {
        System.out.printf(
                "%-50s  %-30s  %-60s\n",
                String.format("insertEdge(u=%s,v=%s)", u, v),
                graph.insertEdge(u, v),
                graph.toString().replace("\n", "\n" + " ".repeat(84))
        );
    }

    private void testRemoveVertex(
            UndirectedUnweightedGraph<Integer> graph,
            VertexInterface<Integer> v) {
        System.out.printf(
                "%-50s  %-30s  %-60s\n",
                String.format("removeVertex(v=%s)", v),
                graph.removeVertex(v),
                graph.toString().replace("\n", "\n" + " ".repeat(84))
        );
    }

    private void testRemoveEdge(
            UndirectedUnweightedGraph<Integer> graph,
            EdgeInterface<Void> e) {
        System.out.printf(
                "%-50s  %-30s  %-60s\n",
                String.format("removeEdge(e=%s)", e),
                graph.removeEdge(e),
                graph.toString().replace("\n", "\n" + " ".repeat(84))
        );
    }

    private void testOpposite(
            UndirectedUnweightedGraph<Integer> graph,
            VertexInterface<Integer> v,
            EdgeInterface<Void> e) {
        System.out.printf(
                "%-50s  %-30s  %-60s\n",
                String.format("opposite(v=%s,e=%s)", v, e),
                graph.opposite(v, e),
                graph.toString().replace("\n", "\n" + " ".repeat(84))
        );
    }
}
