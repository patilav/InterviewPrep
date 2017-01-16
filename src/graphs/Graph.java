package graphs;

import java.util.ArrayList;
import java.util.HashMap;

public class Graph {

	HashMap<Integer, Vertex> verticesMap;
	ArrayList<Edge> edges;
	
	public Graph(){
		this.verticesMap =  new HashMap<>();
		this.edges =  new ArrayList<>();
	}
	
	public void addEdge(int d1, int d2){
		Vertex v1 = null;
		if(verticesMap.containsKey(d1)){
			v1 = verticesMap.get(d1);
		} else{
			v1 =  new Vertex(d1);
			verticesMap.put(d1, v1);
		}
		
		Vertex v2 = null;
		if(verticesMap.containsKey(d2)){
			v2 = verticesMap.get(d2);
		} else{
			v2 =  new Vertex(d2);
			verticesMap.put(d2, v2);
		}
		
		Edge e = new Edge(v1, v2);
		edges.add(e);
		//Add vertex in the adjacency list
		v1.adjacencyList.add(v2);
		v1.edges.add(e);
	}
	
	public Vertex findVertex(int data){
		Vertex v = null;
		if(verticesMap.containsKey(data)){
			v = verticesMap.get(data);
		}
		return v;
	}
	
	@Override
    public String toString(){
        StringBuffer buffer = new StringBuffer();
        for(Edge edge : this.edges){
            buffer.append(edge.v1 + " " + edge.v2);
            buffer.append("\n");
        }
        return buffer.toString();
    }
}
