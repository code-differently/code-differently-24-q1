package com.codedifferently.lesson8;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;

@Configuration
@SpringBootApplication(scanBasePackages = "com.codedifferently")
public class Lesson8 {

  public static void main(String[] args) {
    var application = new SpringApplication(Lesson8.class);
    application.run(args);
  }

  public static boolean containsCycle(LinkedListNode head) {
    // Uses Floyd's Cycle Detection Algorithm aka Tortoise and Hare

    // Check for empty LinkedList or a LL with one node, if either is the case a cycle is
    // impossible.
    if (head == null || head.next == null) {
      return false;
    }
    // Initializes slow at the first node and fast at second node
    LinkedListNode slow = head;
    LinkedListNode fast = head.next;
    // Create a loop that will move slow one step and fast two steps each loop through.
    // If slow == fast at any point this indicates a cycle

    while (fast != null && fast.next != null) {
      if (slow == fast) {
        return true;
      }
      slow = slow.next;
      fast = fast.next.next;
    }
    // If fast becomes null this indicates the end of list and no cycle and returns false
    return false;
  }

  public static int getMaximumBinaryTreeHeight(BinaryTreeNode root) {

    // Uses a recursive call to advance through the tree's nodes

    // Base case for trees with 0 height.
    if (root == null) {
      return 0;
    }
    // Cycles recursively through left and right branches until it hits a null value
    int leftHeight = getMaximumBinaryTreeHeight(root.left);
    int rightHeight = getMaximumBinaryTreeHeight(root.right);
    // Returns the greater value which indicates the height of the tree and
    // adds 1 to account for current node. Constructors are wild.
    return Math.max(leftHeight, rightHeight) + 1;
  }

  public static boolean containsDuplicates(String[] values) {
    return false;
  }

  public static class LinkedListNode {
    public LinkedListNode next;
    public int val;

    public LinkedListNode(int val) {
      this.val = val;
    }
  }

  public static class BinaryTreeNode {
    public int val;
    public BinaryTreeNode left;
    public BinaryTreeNode right;

    public BinaryTreeNode(int val) {
      this.val = val;
    }
  }
}
