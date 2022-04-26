import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * The root interface in the graph hierarchy. A mathematical graph-theory graph
 * object G(V,E) contains a set V of vertices and a set E of edges. Each edge
 * e=(v1,v2) in E connects vertex v1 to vertex v2.
 *
 * Through generics, a graph can be typed to specific classes for vertices V and
 * edges E<T>. Such a graph can contain vertices of type V and all sub-types and
 * Edges of type E and all sub-types.
 * 
 * @author Saad Aulakh
 */
public class Graph implements GraphInterface<Town, Road> {

	private Set<Town> towns;
	private Set<Road> roads;
	private Map<String, Town> townMap;
	ArrayList<String> path;

	public Graph() {
		roads = new HashSet<Road>();
		towns = new HashSet<Town>();
		townMap = new HashMap<String, Town>();
		path = new ArrayList<String>();
	}

	/**
	 * Returns an edge connecting source vertex to target vertex if such vertices
	 * and such edge exist in this graph. Otherwise returns null. If any of the
	 * specified vertices is null returns null
	 *
	 * In undirected graphs, the returned edge may have its source and target
	 * vertices in the opposite order.
	 *
	 * @param sourceVertex      source vertex of the edge.
	 * @param destinationVertex target vertex of the edge.
	 *
	 * @return an edge connecting source vertex to target vertex.
	 */
	@Override
	public Road getEdge(Town sourceVertex, Town destinationVertex) {
		// TODO Auto-generated method stub
		if (containsEdge(sourceVertex, destinationVertex)) {
			for (Road e : roads) {
				if (e.contains(destinationVertex) && e.contains(sourceVertex))
					return new Road(sourceVertex, destinationVertex, e.getWeight(), e.getName());
			}
		}
		return null;
	}

	/**
	 * Creates a new edge in this graph, going from the source vertex to the target
	 * vertex, and returns the created edge.
	 * 
	 * The source and target vertices must already be contained in this graph. If
	 * they are not found in graph IllegalArgumentException is thrown.
	 *
	 *
	 * @param sourceVertex      source vertex of the edge.
	 * @param destinationVertex target vertex of the edge.
	 * @param weight            weight of the edge
	 * @param description       description for edge
	 *
	 * @return The newly created edge if added to the graph, otherwise null.
	 *
	 * @throws IllegalArgumentException if source or target vertices are not found
	 *                                  in the graph.
	 * @throws NullPointerException     if any of the specified vertices is null.
	 */
	@Override
	public Road addEdge(Town sourceVertex, Town destinationVertex, int weight, String description)
			throws NullPointerException {
		// TODO Auto-generated method stub
		if (sourceVertex == null || destinationVertex == null)
			throw new NullPointerException();

		if (towns.contains(sourceVertex) == false || towns.contains(destinationVertex) == false)
			throw new IllegalArgumentException();
		Road r = new Road(sourceVertex, destinationVertex, weight, description);
		roads.add(r);

		return r;
	}

	/**
	 * Adds the specified vertex to this graph if not already present. More
	 * formally, adds the specified vertex, v, to this graph if this graph contains
	 * no vertex u such that u.equals(v). If this graph already contains such
	 * vertex, the call leaves this graph unchanged and returns false. In
	 * combination with the restriction on constructors, this ensures that graphs
	 * never contain duplicate vertices.
	 *
	 * @param v vertex to be added to this graph.
	 *
	 * @return true if this graph did not already contain the specified vertex.
	 *
	 * @throws NullPointerException if the specified vertex is null.
	 */
	@Override
	public boolean addVertex(Town v) {
		// TODO Auto-generated method stub
		if (v == null)
			throw new NullPointerException();
		if (towns.add(v) == false)
			return false;
		else
			towns.add(v);

		return true;
	}

	/**
	 * Returns true if and only if this graph contains an edge going from the source
	 * vertex to the target vertex. In undirected graphs the same result is obtained
	 * when source and target are inverted. If any of the specified vertices does
	 * not exist in the graph, or if is null, returns false.
	 *
	 * @param sourceVertex      source vertex of the edge.
	 * @param destinationVertex target vertex of the edge.
	 *
	 * @return true if this graph contains the specified edge.
	 */
	@Override
	public boolean containsEdge(Town sourceVertex, Town destinationVertex) {
		// TODO Auto-generated method stub
		for (Road e : roads)
			if (e.contains(destinationVertex) && e.contains(sourceVertex))
				return true;
		return false;
	}

	/**
	 * Returns true if this graph contains the specified vertex. More formally,
	 * returns true if and only if this graph contains a vertex u such that
	 * u.equals(v). If the specified vertex is null returns false.
	 *
	 * @param v vertex whose presence in this graph is to be tested.
	 *
	 * @return true if this graph contains the specified vertex.
	 */
	@Override
	public boolean containsVertex(Town v) {
		// TODO Auto-generated method stub
		return towns.contains(v);
	}

	/**
	 * Returns a set of the edges contained in this graph. The set is backed by the
	 * graph, so changes to the graph are reflected in the set. If the graph is
	 * modified while an iteration over the set is in progress, the results of the
	 * iteration are undefined.
	 *
	 *
	 * @return a set of the edges contained in this graph.
	 */
	@Override
	public Set<Road> edgeSet() {
		// TODO Auto-generated method stub
		return roads;
	}

	/**
	 * Returns a set of all edges touching the specified vertex (also referred to as
	 * adjacent vertices). If no edges are touching the specified vertex returns an
	 * empty set.
	 *
	 * @param vertex the vertex for which a set of touching edges is to be returned.
	 *
	 * @return a set of all edges touching the specified vertex.
	 *
	 * @throws IllegalArgumentException if vertex is not found in the graph.
	 * @throws NullPointerException     if vertex is null.
	 */
	@Override
	public Set<Road> edgesOf(Town vertex) {
		// TODO Auto-generated method stub
		Set<Road> townEdges = new HashSet<Road>();
		for (Road r : roads) {
			if (r.contains(vertex)) {
				townEdges.add(r);
			}
		}
		return townEdges;
	}

	/**
	 * Removes an edge going from source vertex to target vertex, if such vertices
	 * and such edge exist in this graph.
	 * 
	 * If weight >- 1 it must be checked If description != null, it must be checked
	 * 
	 * Returns the edge if removed or null otherwise.
	 *
	 * @param sourceVertex      source vertex of the edge.
	 * @param destinationVertex target vertex of the edge.
	 * @param weight            weight of the edge
	 * @param description       description of the edge
	 *
	 * @return The removed edge, or null if no edge removed.
	 */
	@Override
	public Road removeEdge(Town sourceVertex, Town destinationVertex, int weight, String description) {
		// TODO Auto-generated method stub
		for (Road r : roads) {
			if (r.contains(destinationVertex) && r.contains(sourceVertex)) {
				if (description != null) {
					if (weight > -1) {
						Road r1 = r;
						roads.remove(r);
						return r1;
					}
				}
			}
		}
		return null;
	}

	/**
	 * Removes the specified vertex from this graph including all its touching edges
	 * if present. More formally, if the graph contains a vertex u such that
	 * u.equals(v), the call removes all edges that touch u and then removes u
	 * itself. If no such u is found, the call leaves the graph unchanged. Returns
	 * true if the graph contained the specified vertex. (The graph will not contain
	 * the specified vertex once the call returns).
	 *
	 * If the specified vertex is null returns false.
	 *
	 * @param v vertex to be removed from this graph, if present.
	 *
	 * @return true if the graph contained the specified vertex; false otherwise.
	 */
	@Override
	public boolean removeVertex(Town v) {

		return towns.remove(v);
	}

	/**
	 * Returns a set of the vertices contained in this graph. The set is backed by
	 * the graph, so changes to the graph are reflected in the set. If the graph is
	 * modified while an iteration over the set is in progress, the results of the
	 * iteration are undefined.
	 *
	 *
	 * @return a set view of the vertices contained in this graph.
	 */
	@Override
	public Set<Town> vertexSet() {
		// TODO Auto-generated method stub
		return towns;
	}

	/**
	 * Find the shortest path from the sourceVertex to the destinationVertex call
	 * the dijkstraShortestPath with the sourceVertex
	 * 
	 * @param sourceVertex      starting vertex
	 * @param destinationVertex ending vertex
	 * @return An arraylist of Strings that describe the path from sourceVertex to
	 *         destinationVertex They will be in the format: startVertex "via" Edge
	 *         "to" endVertex weight As an example: if finding path from Vertex_1 to
	 *         Vertex_10, the ArrayList<String> would be in the following
	 *         format(this is a hypothetical solution): Vertex_1 via Edge_2 to
	 *         Vertex_3 4 (first string in ArrayList) Vertex_3 via Edge_5 to
	 *         Vertex_8 2 (second string in ArrayList) Vertex_8 via Edge_9 to
	 *         Vertex_10 2 (third string in ArrayList)
	 */
	@Override
	public ArrayList<String> shortestPath(Town sourceVertex, Town destinationVertex) {
		// TODO Auto-generated method stub

		dijkstraShortestPath(sourceVertex);
		Town t = destinationVertex;
		while (!t.equals(sourceVertex)) {
			if (!townMap.containsKey(t.getName())) {
				path.clear();
				break;
			}
			Town t1 = townMap.get(t.getName());
			if (t1 == null)
				return path;
			Road r = getEdge(t1, t);
			path.add(0, t1.getName() + " via " + r.getName() + " to " + t.getName() + " " + r.getWeight() + " mi");
			t = t1;
		}
		return path;
	}

	/**
	 * Dijkstra's Shortest Path Method. Internal structures are built which hold the
	 * ability to retrieve the path, shortest distance from the sourceVertex to all
	 * the other vertices in the graph, etc.
	 * 
	 * @param sourceVertex the vertex to find shortest path from
	 * 
	 */
	@Override
	public void dijkstraShortestPath(Town sourceVertex) {
		// TODO Auto-generated method stub
		Set<Town> visited = new HashSet<Town>();
		ArrayList<Town> unvisited = new ArrayList<Town>();
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		for (Town t : towns) {
			unvisited.add(t);
			map.put(t.getName(), Integer.MAX_VALUE);
			townMap.put(t.getName(), null);
		}
		map.put(sourceVertex.getName(), 0);
		while (!unvisited.isEmpty()) {
			int s = 0;
			for (int i = 0; i < unvisited.size(); i++) {
				Town unvisitedTown = unvisited.get(i);
				if (map.get(unvisited.get(s).getName()) > map.get(unvisitedTown.getName()))
					s = i;
			}
			Town closestTown = unvisited.remove(s);
			visited.add(closestTown);

			for (Road edge : edgesOf(closestTown)) {
				Town adjacent = edge.getDestination();
				if (adjacent.equals(closestTown)) {
					adjacent = edge.getSource();
				}
				if (visited.contains(adjacent)) {
					continue;
				}

				int adjDistance = map.get(closestTown.getName()) + edge.getWeight();
				if (adjDistance < map.get(adjacent.getName())) {
					map.put(adjacent.getName(), adjDistance);
					townMap.put(adjacent.getName(), closestTown);
				}
			}
		}

	}

}
