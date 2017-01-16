package graphs;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class GraphTraversal {

	public void DFS(Graph g) {
		HashSet<Integer> visited = new HashSet<>();
		for (Vertex v : g.verticesMap.values()) {
			if (!visited.contains(v.data)) {
				adjacencySearch(v, visited);
			}
		}
	}

	private void adjacencySearch(Vertex v, HashSet<Integer> visited) {
		visited.add(v.data);
		System.out.print(v + " ");
		for (Vertex adjacentVertex : v.adjacencyList) {
			if (!visited.contains(adjacentVertex.data)) {
				adjacencySearch(adjacentVertex, visited);
			}
		}
	}

	public void BFS(Graph g) {

		HashSet<Integer> visited = new HashSet<>();
		Queue<Vertex> queue = new LinkedList<>();

		for (Vertex v : g.verticesMap.values()) {
			if (!visited.contains(v.data)) {
				queue.add(v);
				visited.add(v.data);
				while (!queue.isEmpty()) {
					Vertex top = queue.remove();
					System.out.print(top.data + " ");
					for (Vertex adjacent : top.adjacencyList) {
						if (!visited.contains(adjacent.data)) {
							queue.add(adjacent);
							visited.add(adjacent.data);
						}
					}
				}
			}
		}
	}

	public Stack<Vertex> topologicalSort(Graph g) {
		HashSet<Integer> visited = new HashSet<>();
		Stack<Vertex> stack = new Stack<>();
		for (Vertex v : g.verticesMap.values()) {
			if (!visited.contains(v.data)) {
				topSortHelper(v, stack, visited);
			}
		}
		return stack;
	}

	public void topSortHelper(Vertex v, Stack<Vertex> stack, HashSet<Integer> visited) {

		visited.add(v.data);
		for (Vertex child : v.adjacencyList) {
			if (!visited.contains(child.data)) {
				topSortHelper(child, stack, visited);
			}
		}
		stack.push(v);
	}

	public static void main(String[] args) {
		Graph graph = new Graph();

		graph.addEdge(1, 3);
		graph.addEdge(1, 2);
		graph.addEdge(3, 4);
		graph.addEdge(5, 6);
		graph.addEdge(6, 3);
		graph.addEdge(3, 8);
		graph.addEdge(8, 11);

		GraphTraversal gt = new GraphTraversal();
		System.out.println("DFS:");
		gt.DFS(graph);

		System.out.println("\nBFS:");
		gt.BFS(graph);

		System.out.println("\nTopological Sort:");
		Stack<Vertex> topSorted = gt.topologicalSort(graph);

		while (!topSorted.isEmpty()) {
			System.out.print(topSorted.pop() + " ");
		}

	}
}
