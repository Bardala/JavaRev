package programs;

class Node {
  Node next;
  int val;

  Node(int val, Node next) {
    this.val = val;
    this.next = next;
  }

  Node(int val) {
    this.val = val;
    this.next = null;
  }

  Node() {
    this.val = 0;
    this.next = null;
  }
}

// 1 <-2 3

public class ReverseLinkedList {
  static Node reverse(Node node) {
    Node prev = null;
    Node next = null;
    Node curr = node;

    while (curr != null) {
      next = curr.next;
      curr.next = prev;
      prev = curr;
      curr = next;
    }

    return prev;
  }

  static void printLinkedList(Node head) {
    while (head != null) {
      System.out.print(head.val + "-> ");
      head = head.next;
    }
    System.out.println();
  }

  static Node head;

  // 1-> 2-> 3
  static Node reverseRecursively(Node node) {
    if (node.next == null)
      return node;

    node = reverseRecursively(node.next);
    node.next.next = node;
    return node;
  }

  public static void main(String[] args) {
    Node head = new Node(1, new Node(2, new Node(3)));
    head = reverse(head);
    printLinkedList(head);
  }
}
