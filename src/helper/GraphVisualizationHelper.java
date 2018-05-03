package helper;

import edge.Edge;
import edu.uci.ics.jung.algorithms.layout.CircleLayout;
import edu.uci.ics.jung.algorithms.layout.Layout;
import edu.uci.ics.jung.graph.DirectedSparseMultigraph;
import edu.uci.ics.jung.graph.AbstractGraph;
import edu.uci.ics.jung.graph.UndirectedOrderedSparseMultigraph;
import edu.uci.ics.jung.visualization.BasicVisualizationServer;
import factory.graph.GraphFactory;
import graph.Graph;
import graph.GraphPoet;
import graph.SocialNetwork;
import vertex.Vertex;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.util.Iterator;

public class GraphVisualizationHelper {
    public static void visualize(Graph g) {
        Layout<Vertex, Edge> layout = new CircleLayout(transferGraph(g));
        layout.setSize(new Dimension(300, 300)); // sets the initial size of the space     // The BasicVisualizationServer<V,E> is parameterized by the edge types
        BasicVisualizationServer<Vertex, Edge> vv = new BasicVisualizationServer<Vertex, Edge>(layout);
        vv.setPreferredSize(new Dimension(350, 350)); //Sets the viewing area size
        JFrame frame = new JFrame("Simple Graph View");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(vv);
        frame.pack();
        frame.setVisible(true);
    }

    public static void main(String[] args) throws IOException {
        Graph poet, socialNetwork, topologyNetwork, movie;
        poet = GraphFactory.createGraph("./test/graph/data/GraphPoet.txt");
        socialNetwork = GraphFactory.createGraph("./test/graph/data/GraphSocial.txt");
        topologyNetwork = GraphFactory.createGraph("./test/graph/data/GraphTopology.txt");
        movie = GraphFactory.createGraph("./test/graph/data/GraphMovie.txt");
        GraphVisualizationHelper.visualize(poet);
    }


    private static AbstractGraph<Vertex, Edge> transferGraph(Graph g) {
        AbstractGraph<Vertex, Edge> graph;
        if (g instanceof GraphPoet || g instanceof SocialNetwork) {
            graph = new DirectedSparseMultigraph<>();
        } else {
            graph = new UndirectedOrderedSparseMultigraph<>();
        }
        for (Edge item : g.edges()) {
            Iterator<Vertex> iterator = item.vertices().iterator();
            graph.addEdge(item, iterator.next(), iterator.next());
        }
        return graph;
    }
}
