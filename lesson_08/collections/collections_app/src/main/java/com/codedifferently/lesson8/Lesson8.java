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
    return false;
  }

  public static int getMaximumBinaryTreeHeight(BinaryTreeNode root) {
    return -1;
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
