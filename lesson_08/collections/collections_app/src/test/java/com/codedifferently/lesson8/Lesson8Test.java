package com.codedifferently.lesson8;

import static org.assertj.core.api.Assertions.assertThat;
import static com.codedifferently.lesson8.Lesson8.LinkedListNode;
import static com.codedifferently.lesson8.Lesson8.BinaryTreeNode;

import org.junit.jupiter.api.Test;

class Lesson8Test {

  @Test
  void testCanVote() {
    assertThat(new Lesson8()).isNotNull();
  }

  @Test
  void testContainsCycle() {
    LinkedListNode node1 = new LinkedListNode(1);
    LinkedListNode node2 = new LinkedListNode(2);
    LinkedListNode node3 = new LinkedListNode(3);
    node1.next = node2;
    node2.next = node3;
    node3.next = node1;

    boolean result = Lesson8.containsCycle(node1);

    assertThat(result).isTrue();
  }

  @Test
  void testGetMaximumBinaryTreeHeight() {
    BinaryTreeNode root = new BinaryTreeNode(1);
    BinaryTreeNode left = new BinaryTreeNode(2);
    BinaryTreeNode right = new BinaryTreeNode(3);
    root.left = left;
    root.right = right;
    left.left = new BinaryTreeNode(4);
    left.right = new BinaryTreeNode(5);
    right.left = new BinaryTreeNode(6);

    int result = Lesson8.getMaximumBinaryTreeHeight(root);

    assertThat(result).isEqualTo(3);
  }

  @Test
  void testContainsDuplicates() {
    String[] values = {"apple", "banana", "cherry", "apple"};

    boolean result = Lesson8.containsDuplicates(values);

    assertThat(result).isTrue();
  }
}