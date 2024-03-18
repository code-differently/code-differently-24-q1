package com.codedifferently.lesson8;

import java.util.HashMap;
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
    if (head == null || head.next == null) {
      return false;
    }

    LinkedListNode slow = head;
    LinkedListNode fast = head.next;

    while (fast != null && fast.next != null) {
      if (slow == fast) {
        return true;
      }
      slow = slow.next;
      fast = fast.next.next;
    }

    return false;
  }

  public static int getMaximumBinaryTreeHeight(BinaryTreeNode root) {
    if (root == null) {
      return 0;
    }

    int leftHeight = getMaximumBinaryTreeHeight(root.left);
    int rightHeight = getMaximumBinaryTreeHeight(root.right);

    return Math.max(leftHeight, rightHeight) + 1;
  }

  public static boolean containsDuplicates(String[] values) {
    HashMap<String, Integer> map = new HashMap<>();

    for (String value : values) {
      if (map.containsKey(value)) {
        return true;
      }
      map.put(value, 1);
    }

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
