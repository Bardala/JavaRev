package collectionFramework.map;

import java.util.*;

public class mapInterface {
  public static void main(String[] args) {
    Map<Integer, String> map = new HashMap<>();
    map.put(1, "ali");
    map.put(2, "islam");
    map.put(3, "ahmed");

    System.out.println(map); // {1=ali, 2=islam, 3=ahmed}

    System.out.println(map.get(2)); // islam
    System.out.println(map.remove(3)); // ahmed

    System.out.println(map.containsKey(2));
    System.out.println(map.containsKey(3));

    System.out.println(map.containsValue("ali"));

    Set<Integer> set = map.keySet();
    System.out.println(set); // [1,2]

    Collection<String> col = map.values();
    System.out.println(col); // [ali, islam]

    Set<Map.Entry<Integer, String>> entrySet = map.entrySet();
    System.out.println(entrySet); // [1=ali, 2=islam]

    System.out.println();

    // * Sorting map according to key

    entrySet

        .stream()

        .sorted(Map.Entry.comparingByKey())

        .forEach(System.out::println);

    System.out.println(map.size());

    map.clear();

    System.out.println(map.size());
    System.out.println();

    // * Converting Map into 2d array

    Map<Integer, String> cars = new HashMap<>();

    cars.put(2, "Benz");
    cars.put(1, "BMW");
    cars.put(3, "Toyota");

    Set<Map.Entry<Integer, String>> entries = cars.entrySet();
    Object[][] arr = new Object[cars.size()][2];
    int i = 0;

    for (Map.Entry<Integer, String> entry : entries) {
      arr[i][0] = entry.getKey();
      arr[i++][1] = entry.getValue();
    }

    printArr(arr); // [1, BMW] [2, Benz] [3, Toyota]s

    Arrays.sort(arr, (a, b) -> Integer.compare(arr[0].hashCode(), arr[1].hashCode()));
    printArr(arr); // [1, BMW] [2, Benz] [3, Toyota]
    System.out.println();

    // * Converting Map into 2D ArrayList()
    List<List<Object>> list = new ArrayList<>();
    for (Map.Entry<Integer, String> entry : cars.entrySet()) {
      List<Object> row = new ArrayList<>(2);
      row.add(entry.getKey());
      row.add(entry.getValue());

      list.add(row);
    }

    Collections.sort(list, (a, b) -> Integer.compare(a.get(0).hashCode(), b.get(0).hashCode()));

    System.out.println(list); // [[1, BMW], [2, Benz], [3, Toyota]]
  }

  static void printArr(Object[][] arr) {
    for (Object[] row : arr)
      System.out.print(Arrays.toString(row) + " ");
    System.out.println();
  }
}
