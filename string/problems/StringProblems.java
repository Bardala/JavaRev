package string.problems;

import java.util.*;

// https://www.geeksforgeeks.org/java-string-exercise/
class EvenLengthWords {
  static String firstWay(String str) {
    String result = "";
    String word = "";

    for (int i = 0; i < str.length(); i++) {
      char currChar = str.charAt(i);

      if (currChar != ' ') {
        word += currChar;
      } else if (word.length() % 2 == 0) {
        result += word + ' ';
        word = "";
      } else
        word = "";
    }
    result = word.length() % 2 == 0 ? result + word : result;

    return result;
  }

  /** Using split method */
  static String usingSplitMethod(String str) {
    String result = "";

    for (String word : str.split(" ")) {
      if (word.length() % 2 == 0)
        result += ' ' + word;
    }
    return result;
  }
}

/**
 * InsertedString
 */
class InsertedString {
  static String method(String str1, String str2, int index) {
    String result = "";

    for (int i = 0; i < str1.length(); i++) {
      if (i == index + 1) {
        result += str2;
      }

      result += str1.charAt(i);
    }

    return result;
  }

  static String usingSubstring(String str1, String str2, int index) {
    return str1.substring(0, index + 1) + str2 + str1.substring(index + 1);
  }

  static String usingStringBuffer(String str1, String str2, int index) {
    StringBuffer result = new StringBuffer(str1);
    result.insert(index + 1, str2);
    return result.toString();
  }
}

class Anagrams {
  static String s;
  static String t;

  // ! Incorrect Answer, test case:
  // static boolean isAnagram() {
  // if (s.length() != t.length())
  // return false;

  // HashSet<Character> set = new HashSet<Character>();
  // s = s.toLowerCase();
  // t = t.toLowerCase();

  // for (int i = 0; i < s.length(); i++) {
  // set.add(s.charAt(i));
  // }

  // for (int i = 0; i < t.length(); i++) {
  // if (!set.contains(t.charAt(i)))
  // return false;
  // }

  // return true;
  // }

  static boolean usingSortedArray() {
    if (s.length() != t.length())
      return false;

    char[] arr1 = s.toLowerCase().toCharArray(), arr2 = t.toLowerCase().toCharArray();

    Arrays.sort(arr1);
    Arrays.sort(arr2);

    for (int i = 0; i < arr1.length; i++) {
      if (arr1[i] != arr2[i])
        return false;
    }

    return true;
  }

  static boolean usingHashMap() {
    if (s.length() != t.length())
      return false;

    s = s.toLowerCase();
    t = t.toLowerCase();
    HashMap<Character, Integer> map = new HashMap<>();

    for (int i = 0; i < s.length(); i++) {
      char c = s.charAt(i);

      if (!map.containsKey(c))
        map.put(c, 1);
      else
        map.put(c, map.get(c) + 1);
    }

    for (int j = 0; j < t.length(); j++) {
      char c = t.charAt(j);

      if (map.containsKey(c)) {
        if (map.get(c) == 0)
          return false;
        map.put(c, map.get(c) - 1);
      } else
        return false;
    }

    return true;
  }

  // ! Incorrect Answer, test case: "ac" "bb"
  // static boolean usingUnicode() {
  // if (str1.length() != str2.length())
  // return false;

  // int sumOfUniCodesForStr1 = 0, sumOfUniCodesForStr2 = 0;

  // for (int i = 0; i < str1.length(); i++) {
  // sumOfUniCodesForStr1 += str1.codePointAt(i);
  // sumOfUniCodesForStr2 += str2.codePointAt(i);
  // }

  // return sumOfUniCodesForStr1 == sumOfUniCodesForStr2;
  // }

}

class SwappingPairOfChars {
  static String str;

  static String usingIteration() {
    String res = "";

    for (int i = 0; i < str.length(); i++) {
      String swap = "";
      int swapsNum = 2;

      while (i < str.length()) {
        swap = str.charAt(i) + swap;
        swapsNum--;
        if (swapsNum == 0)
          break;
        i++;
      }

      res += swap;
    }

    return res;
  }
}

class SortString {
  static String str;

  static List<Character> mergeSort(List<Character> chars) {
    if (chars.size() <= 1)
      return chars;

    int midIndex = chars.size() / 2;
    List<Character> leftHalf = mergeSort(chars.subList(0, midIndex));
    List<Character> rightHalf = mergeSort(chars.subList(midIndex, chars.size()));

    return merge(leftHalf, rightHalf);
  }

  private static List<Character> merge(List<Character> leftHalf, List<Character> rightHalf) {
    List<Character> result = new ArrayList<>();
    int leftIndex = 0, rightIndex = 0;

    while (leftIndex < leftHalf.size() && rightIndex < rightHalf.size()) {
      if (leftHalf.get(leftIndex).hashCode() < rightHalf.get(rightIndex).hashCode()) {
        result.add(leftHalf.get(leftIndex++));
      } else
        result.add(rightHalf.get(rightIndex++));
    }

    while (leftIndex < leftHalf.size()) {
      result.add(leftHalf.get(leftIndex++));
    }

    while (rightIndex < rightHalf.size()) {
      result.add(rightHalf.get(rightIndex++));
    }

    return result;
  }

  static String mergeSortWithString(String str) {
    if (str.length() < 2)
      return str;

    int midIndex = str.length() / 2;
    String leftHalf = mergeSortWithString(str.substring(0, midIndex));
    String rightHalf = mergeSortWithString(str.substring(midIndex, str.length()));

    return mergeStrs(leftHalf, rightHalf);
  }

  private static String mergeStrs(String leftHalf, String rightHalf) {
    String res = "";
    int leftIndex = 0, rightIndex = 0;

    while (leftIndex < leftHalf.length() && rightIndex < rightHalf.length()) {
      if (leftHalf.codePointAt(leftIndex) < rightHalf.codePointAt(rightIndex)) {
        res += leftHalf.charAt(leftIndex++);
      } else
        res += rightHalf.charAt(rightIndex++);
    }

    while (leftIndex < leftHalf.length()) {
      res += leftHalf.charAt(leftIndex++);
    }

    while (rightIndex < rightHalf.length()) {
      res += rightHalf.charAt(rightIndex++);
    }

    return res;
  }

  static String usingArraySort() {
    char[] chars = str.toCharArray();
    Arrays.sort(chars);

    return new String(chars);
  }
}

class FindSum {
  static String findSum(String X, String Y) {
    String result = "";
    int sum = 0, reminder = 0;
    int num1 = 0, num2 = 0;

    X = removeZeros(X);
    Y = removeZeros(Y);

    while (X.length() > 0 || Y.length() > 0 || reminder > 0) {
      if (X.length() == 0)
        num1 = 0;
      else {
        num1 = X.charAt(X.length() - 1) - '0'; // 9
        X = X.substring(0, X.length() - 1);
      }

      if (Y.length() == 0)
        num2 = 0; // 0
      else {
        num2 = Y.charAt(Y.length() - 1) - '0'; // 0
        Y = Y.substring(0, Y.length() - 1);
      }

      sum = num1 + num2 + reminder; // 1
      int firstDigit = sum % 10; // 0

      if (sum > 9)
        reminder = 1;
      else
        reminder = 0;

      result = firstDigit + result; // 1098
    }

    return result.length() == 0 ? "0" : result;
  }

  static String removeZeros(String str) {
    int i;

    for (i = 0; i < str.length(); i++) {
      int num = str.charAt(i) - '0';
      if (num > 0)
        break;
    }

    str = str.substring(i);

    return str;
  }
}

public class StringProblems {
  class IsPalindrome {
    String str;

    public IsPalindrome(String str) {
      this.str = str;
    }

    public boolean usingStringBuffer() {
      StringBuffer reversed = new StringBuffer(this.str).reverse();
      return this.str.equals(reversed.toString());
    }

    public boolean usingIteration() {
      for (int i = 0; i < this.str.length(); i++) {
        if (this.str.charAt(i) != this.str.charAt(this.str.length() - i - 1))
          return false;
      }

      return true;
    }
  }

  class AddBinary {
    static String addBinary(String A, String B) {
      String result = "", sum;
      int reminder = 0;
      char digit1 = '0', digit2 = '0';

      A = removeZeros(A);
      B = removeZeros(B);

      while (A.length() > 0 || B.length() > 0 || reminder > 0) {
        if (A.length() == 0)
          digit1 = '0';
        else {
          digit1 = A.charAt(A.length() - 1);
          A = A.substring(0, A.length() - 1);
        }
        if (B.length() == 0)
          digit2 = '0';
        else {
          digit2 = B.charAt(B.length() - 1);
          B = B.substring(0, B.length() - 1);
        }

        sum = binarySum(digit1, digit2, reminder);

        if (sum.length() > 1) {
          reminder = 1;
          sum = sum.substring(1);
        } else
          reminder = 0;

        result = sum + result;
      }

      return result.length() == 0 ? "0" : result;
    }

    static String binarySum(char d1, char d2, int reminder) {
      String sum = "";

      if ((d1 == '1' && d2 == '0') || (d1 == '0' && d2 == '1')) {
        if (reminder == 0)
          sum = "1";
        else
          sum = "10";
      } else if (d1 == '0' && d2 == '0') {
        if (reminder == 0)
          sum = "0";
        else
          sum = "1";
      } else if (d1 == '1' && d2 == '1') {
        if (reminder == 0)
          sum = "10";
        else
          sum = "11";
      }

      return sum;
    }

    static String removeZeros(String str) {
      int i;

      for (i = 0; i < str.length(); i++) {
        if (str.charAt(i) == '1')
          break;
      }
      str = str.substring(i);
      System.out.println(str);
      return str;
    }

    static String addBinary2(String A, String B) {
      String res = "";

      int sum, lengthA = A.length(), lengthB = B.length(), carry = 0;

      while (lengthA > 0 || lengthB > 0 || carry > 0) {
        sum = carry;

        if (lengthA > 0)
          sum += (A.charAt(lengthA-- - 1) - '0');
        if (lengthB > 0)
          sum += (B.charAt(lengthB-- - 1) - '0');

        res = (sum % 2) + res;
        carry = sum / 2;
      }

      return removeZeros(res);
    }
  }

  public static void main(String[] args) {
    StringProblems problems = new StringProblems();

    // 1. Java String Program to Print Even-Length Words
    String s = "This is a java language";
    String output = EvenLengthWords.usingSplitMethod(s);
    System.out.println(output);
    System.out.println();

    // 2. Java String Program to Insert a String into Another String
    System.out.println(InsertedString.method("GeeksGeeks", "For", 4));
    System.out.println(InsertedString.usingSubstring("GeeksGeeks", "For", 4));
    System.out.println();

    // 3. Java String program to check whether a string is a Palindrome
    StringProblems.IsPalindrome palindrome = problems.new IsPalindrome("AbbA");
    System.out.println(palindrome.usingStringBuffer());
    System.out.println(palindrome.usingIteration());
    palindrome.str = "Hello";
    System.out.println(palindrome.usingStringBuffer());
    System.out.println(palindrome.usingIteration());
    System.out.println();

    // 4. Java String Program to Check Anagram
    Anagrams.s = "Listen";
    Anagrams.t = "Silent";
    System.out.println(Anagrams.usingSortedArray());
    System.out.println(Anagrams.usingHashMap());

    Anagrams.s = "Hello";
    Anagrams.t = "Hi";
    System.out.println(Anagrams.usingSortedArray());
    System.out.println(Anagrams.usingHashMap());
    System.out.println();

    // 6. Java String Program to Swapping Pair of Characters
    SwappingPairOfChars.str = "GeeksForGeeks";
    System.out.println(SwappingPairOfChars.usingIteration()); // eGkeFsroeGkes
    System.out.println();

    // 9. Java String Program to Sort a String
    String software = "software";
    SortString.str = software;
    System.out.println(SortString.usingArraySort().equals("aeforstw")); // true

    List<Character> chars = new ArrayList<>();

    for (int i = 0; i < software.length(); i++)
      chars.add(software.charAt(i));

    System.out.println(SortString.mergeSort(chars)); // [a, e, f, o, r, s, t, w]
    System.out.println(SortString.mergeSortWithString(software));

    System.out.println();

    // 11. Program to Find the Sum of Two Large Numbers.
    String strNum1 = "0000000000002323390023900000000000002320999999992390200322222222";
    String strNum2 = "000000000010000000000000000000000000000000000000000000000000000000000000000000980000000";
    System.out.println(FindSum.findSum(strNum1, strNum2));
    System.out.println();

    // 12. Program to Extract Substring from a String with Equal 0, 1, and 2.
    // Todo

    // 13. Program to Add Binary Strings
    System.out.println(AddBinary.addBinary("1101", "111"));
    System.out.println(AddBinary.addBinary2("1101", "0000111"));
  }

}
