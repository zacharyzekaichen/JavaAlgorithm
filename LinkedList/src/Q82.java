import org.junit.Test;

import javax.sound.midi.Soundbank;

/**
 * @author chenzk
 * @create 2020-12-04 13:31
 */
public class Q82 {

    @Test
    public void testQ82() {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(1);
        ListNode n3 = new ListNode(1);
        ListNode n4 = new ListNode(2);
        ListNode n5 = new ListNode(2);
        ListNode n6 = new ListNode(2);
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

        temp = deleteDuplicates2(n1);
        while(true) {
            if(temp == null) {break;}
            System.out.print(temp);
            temp = temp.next;
        }
    }

    public ListNode deleteDuplicates1(ListNode head) {
        if(head == null || head.next == null) return head;

        ListNode preWatchNode = new ListNode(0,head);
        ListNode watchNode = head;
        boolean sameFlag = false;
        boolean firstNotSameFlag = false;
        while(watchNode.next != null) {
            if(watchNode.val == watchNode.next.val) {
                if(! sameFlag) sameFlag = true;
                watchNode.next = watchNode.next.next;
            }else {
                if(sameFlag) {
                    watchNode = watchNode.next;
                    sameFlag = false;
                    preWatchNode.next = watchNode; //我的邻居就是你，别跑。
                }else {
                    if(! firstNotSameFlag) {
                        head = watchNode;
                        firstNotSameFlag = true;
                    }
                    watchNode = watchNode.next;
                    preWatchNode = preWatchNode.next;
                }
            }
        }

        //最后一个节点如何处置
        //如果sameFlag是成立的，则该节点应该被删除
        if(sameFlag) {
            if(! firstNotSameFlag) head = null;
            else preWatchNode.next = null;
        }else {
            if(! firstNotSameFlag) head = watchNode;
        }

        return head;
    }

    public ListNode deleteDuplicates2(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode a = dummy;
        ListNode b = head;
        while (b != null && b.next != null) {
            //初始化的时a指向的是哑结点，所以比较逻辑应该是a的下一个节点和b的下一个节点
            if (a.next.val != b.next.val) {
                a = a.next;
                b = b.next;
            } else {
                //如果a、b指向的节点值相等，就不断移动b，直到a、b指向的值不相等
                while (b != null && b.next != null && a.next.val == b.next.val) {
                    b = b.next;
                }
                a.next = b.next;
                b = b.next;
            }

        }

        return dummy.next;
    }
}
