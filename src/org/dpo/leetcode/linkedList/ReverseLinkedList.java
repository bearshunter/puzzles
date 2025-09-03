package org.dpo.leetcode.linkedList;
import org.dpo.exp.ListNode;
import  org.dpo.exp.MyLinkedList;

import java.util.HashSet;


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

    public static ListNode reverseList(ListNode current) {

        ListNode prev = null;
        while(current != null){
            ListNode tmp = current.next; //remember next element, because we will have to iterate on it

            current.next = prev; //rewrite link, set a new value. it will be opposite element.

            //make iteration possible, set current element as previos and current element as next
            prev = current;

            current = tmp;

        }

        return prev;



    }

}
