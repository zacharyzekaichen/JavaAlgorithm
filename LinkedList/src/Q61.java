import org.junit.Test;

import javax.sound.midi.Soundbank;

/**
 * @author chenzk
 * @create 2020-12-04 12:53
 */
public class Q61 {

    @Test
    public void testQ62() {
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

        temp = rotateRight(n1, 0);
        while(true) {
            if(temp == null) {break;}
            System.out.print(temp);
            temp = temp.next;
        }
    }

    public ListNode rotateRight(ListNode head, int k) {
        if (head == null) return null;
        if (head.next == null) return head;

        ListNode fast = head;
        ListNode slow = new ListNode(0, head);
        ListNode rear = null;
        while (k > 0) {
            if (fast == null) fast = head;
            fast = fast.next;
            k--;
        }
        while(fast != null) {
            if(fast.next == null) rear = fast;
            fast = fast.next;
            slow = slow.next;
        }

        if(slow.next == head) return head;
        rear.next = head;
        head = slow.next;
        slow.next = null;
        return head;
    }
}