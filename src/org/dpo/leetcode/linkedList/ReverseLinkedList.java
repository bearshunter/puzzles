package org.dpo.leetcode.linkedList;
import org.dpo.exp.ListNode;
import  org.dpo.exp.MyLinkedList;


public class ReverseLinkedList {

    public static void main(String[] args) {
        final MyLinkedList myLinkedList = new MyLinkedList();
        myLinkedList.addFirst(1);
        myLinkedList.addFirst(2);
        myLinkedList.addFirst(3);
        myLinkedList.addFirst(4);
        myLinkedList.addFirst(5);

        reverseList(myLinkedList.getHead());
    }

    public static ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;

        while (curr != null) {
            ListNode nextNode = curr.getNext(); // запоминаем следующий
            curr.setNext(prev);              // swap the link
            // move prev
            prev = curr;
            curr = nextNode;
        }

        return prev;
    }

}
