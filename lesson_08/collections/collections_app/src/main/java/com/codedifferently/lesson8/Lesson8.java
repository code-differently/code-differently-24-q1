package com.codedifferently.lesson8;

import java.util.HashSet;
import java.util.Set;
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
    // initializing the fast and slow nodes in the linked lists
    // fast must be initialized as head.next to be ahead of slow which is initialized as head
    LinkedListNode fast = head.next;
    LinkedListNode slow = head;
    // this while loop will go untill fast.next reaches null.
    // To prevent an infinite loop if at any time fast and slow equal each other return true
    while (fast.next != null) {
      if (fast == slow) {
        return true;
      }
      // In the case the conditions are not met slow will move forward by one and
      // fast will move by 2
      slow = slow.next;
      fast = fast.next.next;
    }

    return false;
  }

  public static int getMaximumBinaryTreeHeight(BinaryTreeNode root) {
    // base case for if the root is null
    if (root == null) {
      return 0;
    }
    // initializing the left and right nodes on the tree
    int leftMax = getMaximumBinaryTreeHeight(root.left);
    int rightMax = getMaximumBinaryTreeHeight(root.right);
    // Returns the max of either the left or the right branches and increments
    // and includes current nodes
    return Math.max(leftMax, rightMax) + 1;
  }

  public static boolean containsDuplicates(String[] values) {
    // created a set that contains strings that were seen before
    Set<String> seenStrings = new HashSet<String>();
    // this loop will increament throught the entire list and check if
    // seen strings contains that value.
    // if it does not see that string it will add that string and continue
    for (String val : values) {
      if (seenStrings.contains(val)) {
        return true;
      }
      seenStrings.add(val);
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
