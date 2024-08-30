package collectionFramework.list.linkedListClass;

import java.util.*;

// Implements Deque and extends List
/* 
* LinkedList implements the doubly linked list of the list interface 
* There is no case of default capacity in a LinkedList. In LinkedList, an empty list is created when a LinkedList is initialized
*/
public class LinkedListClass {
  static List<Integer> linkedList = new LinkedList<>();

  @SuppressWarnings("rawtypes")
  private static void printList(List list) {
    Iterator itr = list.iterator();

    while (itr.hasNext())
      System.out.print(itr.next() + " ");

    System.out.println();
  }

  // @Override
  // public String toString() {
  // String resultStr = "";

  // for (Object obj : list) {
  // resultStr += obj;
  // }

  // return resultStr;
  // }

  public static void main(String[] args) {
    // * add(), addAll()
    linkedList.add(32);
    linkedList.add(89);
    linkedList.add(2);
    linkedList.add(-32);
    printList(linkedList); // 32 89 2 -32

    linkedList.add(3, 47);

    System.out.println(linkedList);

    List<Integer> newLinkedList = new LinkedList<>(linkedList);
    linkedList.clear();

    System.out.println(linkedList); // []
    linkedList.addAll(newLinkedList);
    System.out.println(linkedList); // [32, 89, 2, 47, -32]

    // * contains(), containsAll()
    System.out.println(linkedList.contains(newLinkedList)); // false
    System.out.println(linkedList.contains(2)); // true
    System.out.println(linkedList.containsAll(newLinkedList)); // true

    // * remove(), removeAll(), removeIf()
    linkedList.remove(2);
    System.out.println(linkedList); // [32, 89, 47, -32]

    linkedList.removeAll(newLinkedList);
    System.out.println(linkedList); // []

    System.out.println(newLinkedList); // [32, 89, 2, 47, -32]
    newLinkedList.removeIf(i -> i % 2 == 1);
    System.out.println(newLinkedList); // [32, 2, -32]

    // * retainAll()
    List<Character> linkedChars = new LinkedList<>();
    linkedChars.add('a');
    linkedChars.add('b');
    linkedChars.add('c');
    linkedChars.add('d');

    List<Character> charArr = new ArrayList<>();
    charArr.add('c');

    linkedChars.retainAll(charArr);
    System.out.println(linkedChars); // [c]

    Object[] chars = linkedChars.toArray();

    Class<?> obj = chars[0].getClass();
    System.out.println(obj); // class java.lang.Character

    // * equals()
    System.out.println(linkedChars.equals(charArr)); // true;

    /*
     * * addFirst()
     * * addLast()
     * * getFirst()
     * * getLast()
     * * removeFirst()
     * * removeLast()
     */
    linkedChars.addFirst('a');
    linkedChars.addFirst('b');
    linkedChars.addLast('d');

    System.out.println(linkedChars); // [b, a, c, d]

    System.out.println(linkedChars.getFirst()); // b
    System.out.println(linkedChars.getLast()); // d

    linkedChars.removeFirst();
    linkedChars.removeLast();

    System.out.println(linkedChars); // [a, c]
  }
}
