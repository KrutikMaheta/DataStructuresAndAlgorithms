package implementation;

public class CustomHashMapClient {

	public static void main(String[] args) {
		CustomHashMap<Employee, Integer> hashMapCustom = new CustomHashMap<Employee, Integer>();
		hashMapCustom.put(new Employee("10", "sam"), 12);
		hashMapCustom.put(new Employee("21", "amy"), 121);
		hashMapCustom.put(new Employee("31", "rob"), 151);
		hashMapCustom.put(new Employee("41", "sam"), 15);
		hashMapCustom.put(new Employee("42", "wil"), 89);

		System.out.println("Display values corresponding to keys>");
		System.out.println("value corresponding to employee with id=21 & name='amy' : "
				+ hashMapCustom.get(new Employee("21", "amy")));
		System.out.println("value corresponding to employee with id=51 & name='pat' : "
				+ hashMapCustom.get(new Employee("51", "pat")));

		System.out.print("Displaying : ");
		hashMapCustom.display();

		System.out.println("\n\nvalue corresponding to employee with id=21 & name='amy' removed: "
				+ hashMapCustom.remove(new Employee("21", "amy")));
		System.out.println("value corresponding to employee with id=51 & name='pat' removed: "
				+ hashMapCustom.remove(new Employee("51", "pat")));

		System.out.print("Displaying : ");
		hashMapCustom.display();
	}

}
