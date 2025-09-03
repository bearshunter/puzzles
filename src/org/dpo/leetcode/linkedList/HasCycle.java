package org.dpo.leetcode.linkedList;

import org.dpo.exp.ListNode;
import org.dpo.exp.MyLinkedList;

import java.util.HashSet;
import java.util.Set;

public class HasCycle {

    public static void main(String[] args) {
        final MyLinkedList myLinkedList = new MyLinkedList();
        myLinkedList.addFirst(1);
        ListNode nodeWithOne = myLinkedList.getHead();
        myLinkedList.addFirst(2);
        myLinkedList.addFirst(3);
        myLinkedList.addFirst(4);
        ListNode nodeWithFour = myLinkedList.getHead();
        myLinkedList.addFirst(5);
        nodeWithOne.next = nodeWithFour;

        hasCycle(myLinkedList.getHead());
        hasCycleFloyde(myLinkedList.getHead());

    }

    public static boolean hasCycleFloyde(ListNode head) {
        if(head == null || head.next == null){
            return false;
        }

        ListNode slow = head;
        ListNode fast = head.next;
        while(fast!=null && fast.next !=null){
            slow = slow.next;
            fast = fast.next.next;
            if(fast == slow){
                return true;
            }

        }

        return false;
    }

    public static boolean hasCycle(ListNode head) {
        if(head == null || head.next == null){
            return false;
        }
        Set<ListNode> set = new HashSet<>();
        ListNode current = head;
        while(current!=null){

            if(set.contains(current)){
                return true;
            } else {
                set.add(current);
            }

            current = current.next;
        }


        return false;
    }
}
