package implementation;

public class Employee {
	private String id;
	private String name;

	/**
	 * Employee constructor
	 */
	public Employee(String id, String name) { // constructor
		this.id = id;
		this.name = name;
	}

	@Override
	public String toString() {
		return "Employee[id=" + id + ", name=" + name + "] ";
	}

	@Override
	public boolean equals(Object o) {

		if (o == null)
			return false;
		if (this.getClass() != o.getClass())
			return false;

		Employee e = (Employee) o;
		return e.id.equals(this.id) && e.name.equals(this.name);
	}

	@Override
	public int hashCode() {
		return id.hashCode() + name.hashCode();
	}
}
