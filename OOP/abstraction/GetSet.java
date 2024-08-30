class Person {
	private String name;
	private int age;
	public String getName() {return name;}
	public void setName(String name) {this.name = name;}
	public int getAge() {return age;}
	public void setAge(int age) {this.age = age;}
}


public class GetSet {
	public static void main(String args[]) {
		Person person = new Person();
		person.setName("Islam");
		person.setAge(24);

//		System.out.println(person.name);  // error: you can't access private members
//		System.out.println(person.age); // error: you can't access private members

		System.out.println(person.getName());
		System.out.println(person.getAge());
	}
}
