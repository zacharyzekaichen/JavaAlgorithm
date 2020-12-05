import com.sun.org.apache.xerces.internal.util.StAXLocationWrapper;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author chenzk
 * @create 2020-12-03 10:12
 */
public class Q19 {

    @Test
    public void testMap(){
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(4);
        n1.next = n2;
        n2.next = n3;

        int count = 1;
        Map<Integer, ListNode> map = new HashMap<>();
        ListNode temp = n1;
        map.put(count, temp);
        count++;
        temp = temp.next;
        map.put(count, temp);
        System.out.println(map.get(1));
        System.out.println(map.get(2));
    }

    @Test
    public void testQ19() {
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

        ListNode returnNode = removeNthFromEnd2(n1, 6);
        System.out.println(returnNode);

        temp = returnNode;
        while(true) {
            if(temp == null) {break;}
            System.out.print(temp);
            temp = temp.next;
        }
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head.next == null) {return null;}

        int count = 0;
        Map<Integer, ListNode> map = new HashMap<>();
        ListNode tempNode = head;
        //遍历
        while(true) {
            //逻辑要搞清楚，从第一个开始判断，好的第一个进来了，但是进来的可能是null啊，先做一个判断
            if(tempNode == null) {break;}
            //节点存在了，可以进行操作了，先给有效节点个数加上1
            count++;
            //可以的，注意值传递的内涵
            map.put(count, tempNode);
            //指针往后挪
            tempNode = tempNode.next;
        }

        //找到待删除节点的上一个节点。
        //举例，一个有7个节点，欲删除节点是倒数第2个节点，找到第5个节点。
//        ListNode removeNode = map.get(count - n + 1); //获得地址//其他地方闹得再天翻地覆都跟我没关系
//        ListNode preRemoveNode = map.get(count - n);
//        preRemoveNode.next = removeNode.next;

        ListNode returnNode = null;
        if(count == n) {
            head = head.next;
            returnNode = head;
        }else {
            ListNode preRemoveNode = map.get(count - n);
            preRemoveNode.next = preRemoveNode.next.next;
            returnNode = map.get(1);
        }
        return returnNode;
    }

    public ListNode removeNthFromEnd1(ListNode head, int n) {
        if(head.next == null) {return null;}

        ListNode preRemoveNode = head;
        ListNode postRearNode = head;
        ListNode returnNode = null;
        int count = 0;

        while(true) {
            //对于边界条件的理解
            if(postRearNode == null){
                if(count == n) {
                    head = head.next;
                }else {
                    preRemoveNode.next = preRemoveNode.next.next;
                }
                return head;
            }

            if(count < n + 1) {
                count++;
                postRearNode = postRearNode.next;
            }
            else if(count == n + 1) {
                postRearNode = postRearNode.next;
                preRemoveNode = preRemoveNode.next;
            }
        }


    }

    public ListNode removeNthFromEnd2(ListNode head, int n) {
        if(head == null) {return null;}

        ListNode slow = new ListNode(0,head);
        ListNode fast = new ListNode(0,head);
        while(fast != null) {
            fast = fast.next;
            if(n >= 0) { n--; }
            else { slow = slow.next; }
        }

        if(slow.next == head) {
            head = head.next;
        }else {
            slow.next = slow.next.next;
        }

        return head;
    }
}
