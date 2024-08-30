package collectionFramework;

import java.util.*;

public class CollectionInterface {
  /** List interface implemented by: ArrayList, LinkedList, Stack, Vector */
  static void listInterface() {
    List<Integer> arr = new ArrayList<>();
    List<Character> chars = new LinkedList<>();
    List<String> vec = new Vector<>();
    List<Double> stack = new Stack<>();

    for (int i = 0; i < 10; i++)
      arr.add(i);

    // while (arr.iterator().hasNext())
    // System.out.println(arr.iterator().next());

    printListElements(arr);

    chars.add('d');
    chars.add('h');
    chars.add('f');
    chars.add('v');

    printListElements(chars);

    vec.add("hi");
    vec.add("hello");
    vec.add("welcome");

    printListElements(vec);

    stack.add(80d);
    stack.add(89.3);
    stack.add(99.3);

    printListElements(stack);

    List<Integer> linkedList = new LinkedList<>();
    linkedList.addAll(arr);

    List<Integer> vector = new Vector<>();
    vector.add(1);
    vector.add(2);
    vector.add(3);

    linkedList.removeAll(vector);
    printListElements(linkedList);

    printListObjs(linkedList);
  }

  @SuppressWarnings("rawtypes")
  /** Print all elements of List interface using iterator interface */
  static void printListElements(List list) {
    Iterator itr = list.iterator();

    while (itr.hasNext())
      System.out.print(itr.next() + " ");

    System.out.println();
  }

  @SuppressWarnings("rawtypes")
  /** Print all ele of */
  static void printListObjs(List list) {
    for (Object obj : list.toArray())
      System.out.print(obj + " ");

    System.out.println();
  }

  public static void main(String[] args) {
    listInterface();
  }
}
