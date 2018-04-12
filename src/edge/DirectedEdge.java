package edge;

import vertex.Vertex;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class DirectedEdge extends Edge {
    DirectedEdge(String label, double weight) {
        super(label, weight);
    }

    @Override
    public boolean addVertices(List<Vertex> vertices) {
        if (vertices.size() == 2) {
            if (super.vertices.size() == 0) {
                super.vertices.addAll(vertices);
                return true;
            }
            return false;
        } else {
            throw new RuntimeException("the undirected edge must be two vertices");
        }
    }

    @Override
    public Set<Vertex> sourceVertices() {
        Set<Vertex> source = new HashSet<>();
        source.add(super.vertices.get(0));
        return source;
    }

    @Override
    public Set<Vertex> targetVertices() {
        Set<Vertex> target = new HashSet<>();
        target.add(super.vertices.get(0));
        return target;
    }
}