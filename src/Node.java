import java.util.ArrayList;
import java.util.List;

/**
 * Represents a Node in a doubly linked list.
 */
public class Node {
  /** The value stored in this node. */
  public int value;

  /** The previous node in the linked list. */
  public Node prev;

  /** The next node in the linked list. */
  public Node next;

  /**
   * Creates a single node with the specified value.
   * prev and next are kept as null.
   *
   * @param value The value to store in this node.
   */
  public Node(int value) {
    this.value = value;
  }

  /**
   * Creates a doubly linked list from the given list of integers.
   * The head of the list will be the constructed Node.
   * 
   * For example, if there were the list:
   * [5, 7, 3]
   * 
   * Then the linked list that would be created would be:
   * 5 <-> 7 <-> 3
   * And this node would be the head, holding a value of 5.
   *
   * @param list The list of integers to initialize the doubly linked list.
   * @throws IllegalArgumentException If the list is null or empty.
   */
  public Node(List<Integer> list) {
    // if list is null or empty throw a exception
    if (list == null || list.size() == 0) {
      throw new IllegalArgumentException("The list cannot be null or empty");
    }

    // set this node value to the first element
    this.value = list.get(0);

    // start building from the this node
    Node current = this;

    // loop through the rest of the list
    for (int i = 1; i < list.size(); i++) {
      // create a new node with the valuee
      Node newNode = new Node(list.get(i));

      // connect forward
      current.next = newNode;

      // connect backwards
      newNode.prev = current;

      // move current forward
      current = newNode;
    }
  }

  /**
   * Converts the linked list starting from this node into a list of integers.
   * Treats this node as the head, even if it has a previous value.
   *
   * @return A list of integers representing the values in the linked list.
   */
  public List<Integer> toList() {
    // here we create a list to store values
    List<Integer> result = new ArrayList<>();

    // start at this node its like the head
    Node current = this;

    // we move forward through the list
    while (current != null) {
      result.add(current.value);
      current = current.next;
    }

    return result;
  }
}
