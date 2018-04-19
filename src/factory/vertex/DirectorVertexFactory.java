package factory.vertex;

import vertex.Computer;
import vertex.Vertex;

public class DirectorVertexFactory {
    static Vertex createVertex(String label, String[] args) {
        Vertex newVertex = new Computer(label);
        newVertex.fillVertexInfo(args);
        return newVertex;
    }
}