package com.codedifferently.lesson7.util;

/** A LinkedList node. */
public class LinkedListNode<T> {
  /** The next node in a linked list. */
  public LinkedListNode<T> next;

  /** The data stored in this node. */
  public T data;

  public LinkedListNode(T data) {
    this.data = data;
  }
}
