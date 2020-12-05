package linkedlist;

import org.junit.Test;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * @author chenzk
 * @create 2020-12-03 19:25
 */
public class ReverseLinkedList {

    @Test
    public void testReverseLinkedList() {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(4);
        ListNode n4 = new ListNode(1);
        ListNode n5 = new ListNode(3);
        ListNode n6 = new ListNode(4);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        n5.next = n6;

        ListNode temp = n1;
        while(true) {
            if(temp == null) {break;}
            System.out.print(temp);
            temp = temp.next;
        }
        System.out.println();

        printReverse(n1);

//        temp = reverseLinkedList1(n1);
//        while(true) {
//            if(temp == null) {break;}
//            System.out.print(temp);
//            temp = temp.next;
//        }
    }

    public ListNode reverseLinkedList(ListNode list) {
        if(list == null) return null;

        Deque<ListNode> stack = new LinkedList<>();
        ListNode temp = list;
        while(temp.next != null) {
            stack.push(temp);
            temp = temp.next;
        }

        ListNode newHead = temp;
        while(! stack.isEmpty()){
            temp.next = stack.pop();
            temp = temp.next;
        }
        //别死循环了
        temp.next = null;

        return newHead;
    }

    public ListNode reverseLinkedList1(ListNode list) {
        if(list == null) return null;

        ListNode temp = list;
        ListNode newhead = new ListNode();
        while(temp != null) {
            //存一下地址，不然丢了
            ListNode temp2 = temp.next;
            temp.next = newhead.next;
            newhead.next = temp;
            //地址更新一下。
            temp = temp2;
        }

        return newhead.next;
    }

    public void printReverse(ListNode list){
        if(list == null) return;

        if(list.next == null) {
            System.out.print(list);
            return;
        }

        printReverse(list.next);
        System.out.print(list);
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    @Override
    public String toString() {
        return "Node = " + val + "\t";
    }
}
