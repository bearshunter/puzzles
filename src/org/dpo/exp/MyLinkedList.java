package org.dpo.exp;

public class MyLinkedList {
    private ListNode head;
    private int size;

    public void addFirst(int val) {
        ListNode newNode = new ListNode(val);
        newNode.setNext(head);
        head = newNode;
        size++;
    }

    public void addLast(int val) {
        ListNode newNode = new ListNode(val);
        if (head == null) {
            head = newNode;
        } else {
            ListNode curr = head;
            while (curr.getNext() != null) {
                curr = curr.getNext();
            }
            curr.setNext(newNode);
        }
        size++;
    }

    public int size() {
        return size;
    }

    public ListNode getHead() {
        return head;
    }
}

