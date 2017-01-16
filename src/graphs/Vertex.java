package graphs;

import java.util.ArrayList;

public class Vertex {

	int data;
	ArrayList<Vertex> adjacencyList;
	ArrayList<Edge> edges;
	
	public Vertex(){
		this.adjacencyList =  new ArrayList<>();
		this.edges = new ArrayList<>();
	}
	
	public Vertex(int data){
		this.data = data;
		this.adjacencyList =  new ArrayList<>();
		this.edges = new ArrayList<>();
	}

	@Override
	public String toString(){
        return String.valueOf(data);
    }
}
