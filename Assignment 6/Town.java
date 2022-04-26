import java.util.Objects;

public class Town implements Comparable<Town> {
	private String name;

	public Town(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}
	
	@Override
	public String toString() {
		return "Town [name=" + name + "]";
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(name);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Town other = (Town) obj;
		return Objects.equals(name, other.name);
	}

	@Override
	public int compareTo(Town o) {
		// TODO Auto-generated method stub
		if (this.name == o.name)
			return 0;
		else 
			return 1;
	}

}
