package collectionFramework.list.arrayListClass;

import java.io.*;
import java.util.*;

class User implements Serializable {
  String name;
  /** This field will not be serialized */
  transient String password;
  int id;
  ArrayList<User> friends = new ArrayList<>();

  public User() {
  }

  public User(String name, String password, int id) {
    this.name = name;
    this.password = password;
    this.id = id;
  }

  public User(String name, String password, int id, ArrayList<User> friends) {
    this(name, password, id);
    this.friends = friends;
  }

  @Override
  public String toString() {
    return (name + " " + password + " " + id);
  }
}

/**
 * Generally, when an ArrayList is initialized, a default capacity of 10 is
 * assigned to the ArrayList
 */
public class ArrayListClass {
  @SuppressWarnings("rawtypes")
  static void printListElements(List list) {
    if (list.isEmpty()) {
      System.out.println("{}");
      return;
    }

    Iterator itr = list.iterator();
    while (itr.hasNext())
      System.out.print(itr.next() + " ");

    System.out.println();
  }

  @SuppressWarnings("rawtypes")
  static void printListElements(List list, String comment) {
    System.out.print(comment + ": ");
    printListElements(list);
  }

  @SuppressWarnings("rawtypes")
  static void printListObjs(List list) {
    for (Object obj : list.toArray())
      System.out.print(obj + " ");
    System.out.println();
  }

  static final String fileDir = "./collectionFramework/inputOutputFiles/file1";

  static void serializationAndDeserialization() {
    User ahmed = new User("ahmed", "asdfkjew", 32);
    User ali = new User("ali", "ewaoifnoi", 89);

    List<User> users = new ArrayList<>();
    users.add(ali);
    users.add(ahmed);

    ali.friends.add(ahmed);
    ahmed.friends.add(ali);

    try {
      // Serialization
      FileOutputStream fileOS = new FileOutputStream(fileDir);
      ObjectOutputStream objOS = new ObjectOutputStream(fileOS);
      objOS.writeObject(users);

      objOS.close();

      FileInputStream fileIS = new FileInputStream(fileDir);
      ObjectInput ObjIS = new ObjectInputStream(fileIS);

      @SuppressWarnings("unchecked")
      List<User> list = (ArrayList<User>) ObjIS.readObject();
      printListElements(list); // ali null 89 ahmed null 32

      ObjIS.close();

      // Object obj = ObjIS.readObject();
      // if (obj instanceof List<?>) {
      // List<?> rawList = (List<?>) obj;
      // List<User> userList = new ArrayList<>();
      // for (Object element : rawList) {
      // if (element instanceof User) {
      // userList.add((User) element);
      // }
      // }
      // // Now userList is type-safe
      // }

    } catch (Exception e) {
      System.out.println(e);
    }
  }

  public static void main(String[] args) {
    Collection<Integer> nums = new LinkedList<>();
    nums.add(1);
    nums.add(2);
    nums.add(3);

    List<Integer> list = new ArrayList<>(nums);

    list.add(4);
    list.addAll(nums);

    System.out.println(list.get(0)); // 1
    System.out.println(list.isEmpty()); // false

    System.out.println("Index of number 4: " + list.indexOf(4)); // 3
    printListElements(list); // 1 2 3 4 1 2 3

    list.remove(0);
    printListObjs(list); // 2 3 4 1 2 3

    list.removeAll(nums);
    printListElements(list); // 4

    list.removeIf(num -> num % 2 == 0);
    printListElements(list, "Remove all even numbers");

    list.addAll(nums);
    printListElements(list); // 4 1 2 3

    Collections.sort(list);
    printListElements(list); // 1 2 3 4

    list.set(0, 9);
    printListElements(list); // 9 2 3 4

    List<String> namesArr = new ArrayList<>();
    namesArr.add("islam");
    namesArr.add("ali");
    namesArr.add("mhmd");

    printListObjs(namesArr);

    serializationAndDeserialization();

    // * RetainAll
    List<String> animals = new ArrayList<>();
    List<String> cats = new ArrayList<>();
    animals.add("mouse");
    animals.add("cat");
    animals.add("lion");
    animals.add("Camel");

    cats.add("cat");
    cats.add("tiger");

    animals.retainAll(cats);
    printListElements(animals); // cat

    // * Sort()
    List<Double> doubles = new ArrayList<>();
    doubles.add(34d);
    doubles.add(32.3);
    doubles.add(-32d);
    doubles.add(0d);
    doubles.add(1000d);

    printListElements(doubles); // 34.0 32.3 -32.0 0.0 1000.0
    doubles.sort(Comparator.naturalOrder());
    printListElements(doubles); // -32.0 0.0 32.3 34.0 1000.0
    doubles.sort(Comparator.reverseOrder());
    printListElements(doubles); // 1000.0 34.0 32.3 0.0 -32.0

    Collections.sort(doubles);
    printListElements(doubles); // -32.0 0.0 32.3 34.0 1000.0

    System.out.println(doubles);
  }
}
