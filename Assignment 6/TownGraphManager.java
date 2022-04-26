import java.io.BufferedReader;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * Class that uses a Graph object to make a graph of towns/roads
 * 
 * @author Saad Aulakh
 *
 */
public class TownGraphManager implements TownGraphManagerInterface {

	private Graph graph;

	public TownGraphManager() {
		graph = new Graph();
	}

	/**
	 * Adds a road with 2 towns and a road name
	 * 
	 * @param town1    name of town 1 (lastname, firstname)
	 * @param town2    name of town 2 (lastname, firstname)
	 * @param roadName name of road
	 * @return true if the road was added successfully
	 */
	@Override
	public boolean addRoad(String town1, String town2, int weight, String roadName) {
		// TODO Auto-generated method stub
		boolean added = false;
		if (town1 == null || town2 == null)
			return added;
		else {
			Town t1 = new Town(town1);
			Town t2 = new Town(town2);
			graph.addVertex(t1);
			graph.addVertex(t2);
			graph.addEdge(t1, t2, weight, roadName);
			added = true;
		}
		return added;
	}

	/**
	 * Returns the name of the road that both towns are connected through
	 * 
	 * @param town1 name of town 1 (lastname, firstname)
	 * @param town2 name of town 2 (lastname, firstname)
	 * @return name of road if town 1 and town2 are in the same road, returns null
	 *         if not
	 */
	@Override
	public String getRoad(String town1, String town2) {
		// TODO Auto-generated method stub
		if (town1 != null && town2 != null) {
			Town t1 = new Town(town1);
			Town t2 = new Town(town2);
			Road r = graph.getEdge(t1, t2);

			return r.getName();
		}
		return null;
	}

	/**
	 * Adds a town to the graph
	 * 
	 * @param v the town's name (lastname, firstname)
	 * @return true if the town was successfully added, false if not
	 */
	@Override
	public boolean addTown(String v) {
		// TODO Auto-generated method stub
		if (v != null) {
			Town t = new Town(v);
			graph.addVertex(t);
			return true;
		}
		return false;
	}

	/**
	 * Gets a town with a given name
	 * 
	 * @param name the town's name
	 * @return the Town specified by the name, or null if town does not exist
	 */
	@Override
	public Town getTown(String name) {
		// TODO Auto-generated method stub
		if (name != null) {
			Town t = new Town(name);
			for (Town town : graph.vertexSet()) {
				if (t.equals(town)) {
					return town;
				}
			}
		}
		return null;
	}

	/**
	 * Determines if a town is already in the graph
	 * 
	 * @param v the town's name
	 * @return true if the town is in the graph, false if not
	 */
	@Override
	public boolean containsTown(String v) {
		// TODO Auto-generated method stub
		if (v != null) {
			Town t = new Town(v);
			for (Town town : graph.vertexSet()) {
				if (t.equals(town)) {
					return true;
				}
			}
		}
		return false;
	}

	/**
	 * Determines if a road is in the graph
	 * 
	 * @param town1 name of town 1 (lastname, firstname)
	 * @param town2 name of town 2 (lastname, firstname)
	 * @return true if the road is in the graph, false if not
	 */
	@Override
	public boolean containsRoadConnection(String town1, String town2) {
		// TODO Auto-generated method stub
		if (town1 != null && town2 != null) {
			Town Town1 = new Town(town1);
			Town Town2 = new Town(town2);
			return graph.containsEdge(Town1, Town2);
		}
		return false;
	}

	/**
	 * Creates an arraylist of all road titles in sorted order by road name
	 * 
	 * @return an arraylist of all road titles in sorted order by road name
	 */
	@Override
	public ArrayList<String> allRoads() {
		// TODO Auto-generated method stub
		ArrayList<String> all = new ArrayList<String>();
		for (Road r : graph.edgeSet()) {
			all.add(r.getName());
			Collections.sort(all);
		}
		return all;
	}

	/**
	 * Deletes a road from the graph
	 * 
	 * @param town1    name of town 1 (lastname, firstname)
	 * @param town2    name of town 2 (lastname, firstname)
	 * @param roadName the road name
	 * @return true if the road was successfully deleted, false if not
	 */
	@Override
	public boolean deleteRoadConnection(String town1, String town2, String road) {
		// TODO Auto-generated method stub
		if (town1 != null && town2 != null && road != null) {
			Town t1 = new Town(town1);
			Town t2 = new Town(town2);
			Road r = graph.getEdge(t1, t2);
			graph.removeEdge(t1, t2, r.getWeight(), road);
			return true;
		}
		return false;
	}

	/**
	 * Deletes a town from the graph
	 * 
	 * @param v name of town (lastname, firstname)
	 * @return true if the town was successfully deleted, false if not
	 */
	@Override
	public boolean deleteTown(String v) {
		// TODO Auto-generated method stub
		if (v != null) {
			Town t1 = new Town(v);
			graph.removeVertex(t1);
			return true;
		}
		return false;
	}

	/**
	 * Creates an arraylist of all towns in alphabetical order (last name, first
	 * name)
	 * 
	 * @return an arraylist of all towns in alphabetical order (last name, first
	 *         name)
	 */
	@Override
	public ArrayList<String> allTowns() {
		// TODO Auto-generated method stub
		ArrayList<String> all = new ArrayList<String>();
		for (Town t : graph.vertexSet()) {
			all.add(t.getName());
			Collections.sort(all);
		}
		return all;
	}

	/**
	 * Returns the shortest path from town 1 to town 2
	 * 
	 * @param town1 name of town 1 (lastname, firstname)
	 * @param town2 name of town 2 (lastname, firstname)
	 * @return an Arraylist of roads connecting the two towns together, null if the
	 *         towns have no path to connect them.
	 */
	@Override
	public ArrayList<String> getPath(String town1, String town2) {
		// TODO Auto-generated method stub
		ArrayList<String> path = new ArrayList<String>();
		if (town1 != null && town2 != null) {
			Town t1 = new Town(town1);
			Town t2 = new Town(town2);
			path = graph.shortestPath(t1, t2);

		}
		return path;
	}

	/**
	 * Populates the town graph using data from a file.
	 * 
	 * @param f file with towns/roads
	 * @throws IOException
	 */
	public void populateTownGraph(File f) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new FileReader(f));
		String[] str = new String[6];
		String line = null;

		try {
			while ((line = br.readLine()) != null) {
				str = line.split(";|\\,");
				addTown(str[2]);
				addTown(str[3]);
				addRoad(str[2], str[3], Integer.parseInt(str[1]), str[0]);
			}
			br.close();
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		}
	}

}
