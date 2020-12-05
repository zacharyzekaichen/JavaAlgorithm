import org.junit.Test;

import java.util.List;

/**
 * @author chenzk
 * @create 2020-12-03 8:44
 */
public class Q21 {

    @Test
    public void testQ21() {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(4);
        ListNode n4 = new ListNode(1);
        ListNode n5 = new ListNode(3);
        ListNode n6 = new ListNode(4);
        n1.next = n2;
        n2.next = n3;
        n4.next = n5;
        n5.next = n6;

        ListNode newList = mergeTwoLists(n1, n4);
        while(true) {
            if(newList == null) {break;}
            System.out.print(newList);
            newList = newList.next;
        }
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1 == null) {return (l2 == null)? null : l2;}
        if(l2 == null) {return (l1 == null)? null : l1;}

        ListNode nodeTemp1 = l1;
        ListNode nodeTemp2 = l2;
        //注意：头不能动
        ListNode newList = new ListNode();
        ListNode nodeTemp = newList;
        //指针分别指向两个升序链表的一个节点，进行值的判断，因此会有三种情况。
        //若相等，将链表2的节点往链表1对应节点的前面插入，插入前链表2的指针先往后面挪。
        while(true) {
            //退出while循环条件
            if(nodeTemp1 == null || nodeTemp2 == null) {
                nodeTemp.next = (nodeTemp1 == null)? nodeTemp2 : nodeTemp1;
                break;
            }

            if(nodeTemp1.val == nodeTemp2.val) {
                //关于值传递的问题
//                nodeTemp.next = nodeTemp1;
//                nodeTemp = nodeTemp.next;
//                nodeTemp.next = nodeTemp2;
//                nodeTemp = nodeTemp.next;
//                nodeTemp1 = nodeTemp1.next;
//                nodeTemp2 = nodeTemp2.next;
                nodeTemp.next = nodeTemp1;
                nodeTemp1 = nodeTemp1.next;
                nodeTemp = nodeTemp.next;
                nodeTemp.next = nodeTemp2;
                nodeTemp2 = nodeTemp2.next;
                nodeTemp = nodeTemp.next;
            }else if(nodeTemp1.val > nodeTemp2.val) {
                nodeTemp.next = nodeTemp2;
                nodeTemp2 = nodeTemp2.next;
                nodeTemp = nodeTemp.next;
            }else if(nodeTemp1.val < nodeTemp2.val) {
                nodeTemp.next = nodeTemp1;
                nodeTemp1 = nodeTemp1.next;
                nodeTemp = nodeTemp.next;
            }
        }

        //注意不要将头节点返回
        return newList.next;
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
