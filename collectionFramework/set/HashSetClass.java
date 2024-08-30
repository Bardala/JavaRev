package collectionFramework.set;

import java.util.*;

/*
 * add()
 * remove()
 * size()
 * clear()
 * clone()
 * contains()
 * isEmpty()
 * iterator()
 */

class OurSet<E> extends AbstractSet<E> {

  private transient HashMap<E, Object> map = new HashMap<>();
  private final Object PRESENT = new Object();

  public boolean add(E key) {
    return map.put(key, PRESENT) == null;
  }

  @Override
  public Iterator<E> iterator() {
    return map.keySet().iterator();
  }

  @Override
  public int size() {
    return map.keySet().size();
  }

  public boolean contain(E e) {
    return map.containsKey(e);
  }
}

public class HashSetClass {
  static Set<String> set = new HashSet<>();

  public static void main(String[] args) {
    set.add("islam");
    set.add("ali");
    set.add("ali");
    set.add("islam");
    set.add(null);
    set.add("sayed");
    set.add(null);

    System.out.println(set); // [null, islam, sayed, ali]

    set.remove("islam");
    System.out.println(set); // [null, sayed, ali]

    System.out.println(set.size()); // 3

    System.out.println(set.contains("ali")); // true

    Iterator<String> itr = set.iterator();
    while (itr.hasNext()) {
      System.out.println(itr.next());
    }

    System.out.println(set.isEmpty()); // false

    AbstractSet<String> chessSet = new OurSet<>();
    System.out.println(chessSet.add("King")); // true
    System.out.println(chessSet.add("knight")); // true
    System.out.println(chessSet.add("pawn")); // true
    System.out.println(chessSet.add("Rock")); // true
    System.out.println(chessSet.add("King")); // false

    System.out.println(chessSet); // [Rock, King, knight, pawn]

    System.out.println(chessSet.size()); // 4
  }
}