import org.junit.Test;

/**
 * @author chenzk
 * @create 2020-12-04 10:28
 */
public class Q24 {

    @Test
    public void testQ24() {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(4);
        ListNode n4 = new ListNode(1);
        ListNode n5 = new ListNode(3);
        ListNode n6 = new ListNode(4);
//        n1.next = n2;
//        n2.next = n3;
//        n3.next = n4;
//        n4.next = n5;
//        n5.next = n6;

        ListNode temp = n1;
        while(true) {
            if(temp == null) {break;}
            System.out.print(temp);
            temp = temp.next;
        }

        System.out.println();

        temp = swapPairs(n1);
        while(true) {
            if(temp == null) {break;}
            System.out.print(temp);
            temp = temp.next;
        }
    }

    public ListNode swapPairs(ListNode head){
        if(head == null) return null;

        ListNode pointer = new ListNode(0,head);
        ListNode temp = null;
        boolean firstFlag = true;
        //终止条件的确定，当后一个存在的时候，才有交换的必要
//        while(pointer != null) {
//            if(pointer.next != null) {
//                temp = pointer.next;
//                pointer.next = pointer.next.next;
//                temp.next = pointer;
//                if(pointer == head) {
//                    head = temp;
//                }
//            }else { break; }
//
//            pointer = pointer.next;
//        }
        while(pointer.next != null && pointer.next.next != null) {
            temp = pointer.next;
            pointer.next = pointer.next.next;
            temp.next = pointer.next.next;
            pointer.next.next = temp;

            if(firstFlag) {
                head = pointer.next;
                firstFlag = false;
            }

            pointer = pointer.next.next;
        }

        return head;
    }
}
