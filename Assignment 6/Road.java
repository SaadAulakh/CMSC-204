
public class Road implements Comparable<Road> {

	private Town source;
	private Town destination;
	private String name;
	private int weight;

	public Road(Town source, Town destination, String name) {
		this(source, destination, 0, name);
	}

	public Road(Town source, Town destination, int weight, String name) {
		this.source = source;
		this.destination = destination;
		this.weight = weight;
		this.name = name;
	}

	public Town getSource() {
		return source;
	}

	public Town getDestination() {
		return destination;
	}

	public String getName() {
		return name;
	}

	public int getWeight() {
		return weight;
	}

	public boolean contains(Town town) {
		return source.getName().equals(town.getName()) || destination.getName().equals(town.getName());
	}

	@Override
	public String toString() {
		return "Road [source=" + source + ", destination=" + destination + ", name=" + name + ", weight=" + weight
				+ "]";
	}

	@Override
	public boolean equals(Object x) {
		if (source.equals(((Road) x).getSource()) && destination.equals(((Road) x).getDestination())) {
			return true;
		}
		return false;
	}

	@Override
	public int compareTo(Road o) {
		// TODO Auto-generated method stub
		if (this.name == o.name)
			return 0;
		else
			return 1;
	}

}
