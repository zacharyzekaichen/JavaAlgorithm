import org.junit.Test;

/**
 * @author chenzk
 * @create 2020-12-03 16:27
 */
public class Q2 {

    @Test
    public void testQ2() {
        ListNode n1 = new ListNode(9);
        ListNode n2 = new ListNode(9);
        ListNode n3 = new ListNode(9);
        ListNode n4 = new ListNode(9);
        ListNode n5 = new ListNode(9);
        ListNode n6 = new ListNode(9);
        ListNode n7 = new ListNode(9);
        ListNode n8 = new ListNode(9);
        n1.next = n2;
        n2.next = n3;

        n4.next = n5;
        n5.next = n6;

        n6.next = n7;
        n7.next = n8;

        ListNode addList = addTowNumbers3(n1,n4);
        ListNode temp = addList;
        while(true) {
            if(temp == null) {break;}
            System.out.print(temp);
            temp = temp.next;
        }
    }

    public ListNode addTowNumbers1(ListNode l1, ListNode l2) {
        if(l1 == null) {return l2;}
        if(l2 == null) {return l1;}

//        ListNode sumList = new ListNode();
        //first为主，second为辅，均为索引指针，l1,l2均不能动
        ListNode firstTemp = new ListNode(0,l1);
        ListNode secondTemp = new ListNode(0,l2);
//        ListNode sumTemp = sumList;
        //进位
        int aVal = 0;
        int fVal = 0;
        while(true) {
            //退出条件，注意接上
            //边界条件想清楚
            //两条均空，只有一条空，进位，不进位
            if(firstTemp.next == null) {
                if(secondTemp.next == null && aVal == 1) {
                    firstTemp.next = new ListNode(1);
                }else if(secondTemp.next != null){
                    firstTemp.next = secondTemp.next;
                    if(aVal == 1) {firstTemp.next.val++;}
                }
                break;
            }else if(secondTemp.next == null) {
                if(aVal == 1) {firstTemp.next.val++;}
                break;
            }

            //相加条件
            // 基于next均还有值
            fVal = firstTemp.next.val + secondTemp.next.val + aVal;
            if(fVal >= 10) {
                fVal = fVal - 10;
                aVal = 1;
            }else {
                aVal = 0;
            }
            firstTemp.next.val = fVal;
            firstTemp = firstTemp.next;
            secondTemp = secondTemp.next;
        }

        return l1;
    }

    //双指针
    public ListNode addTowNumbers2(ListNode l1, ListNode l2) {
        if(l1 == null) {return l2;}
        if(l2 == null) {return l1;}

        ListNode firstTemp = new ListNode(0,l1);
        ListNode secondTemp = new ListNode(0,l2);
        //进位
        int aVal = 0;
        int fVal = 0;

        while(true) {
            if(firstTemp.next == null && secondTemp.next == null) {
                if(aVal == 1) {firstTemp.next = new ListNode(1);}
                break;
            }else if(secondTemp.next == null) {
                fVal = firstTemp.next.val  + aVal;
                if(fVal >= 10) {
                    fVal = fVal - 10;
                    aVal = 1;
                }else {
                    aVal = 0;
                }
                firstTemp.next.val = fVal;
                firstTemp = firstTemp.next;
            }else if(firstTemp.next == null) {
                firstTemp.next = secondTemp.next;
                secondTemp.next = null;
            }else {
                fVal = firstTemp.next.val + secondTemp.next.val + aVal;
                if(fVal >= 10) {
                    fVal = fVal - 10;
                    aVal = 1;
                }else {
                    aVal = 0;
                }
                firstTemp.next.val = fVal;
                firstTemp = firstTemp.next;
                secondTemp = secondTemp.next;
            }
        }
        return l1;
    }

    //继续写
    public ListNode addTowNumbers3(ListNode l1, ListNode l2) {
        if(l1 == null) {return l2;}
        if(l2 == null) {return l1;}

        ListNode firstTemp = new ListNode(0,l1);
        ListNode secondTemp = new ListNode(0,l2);
        //进位
        int aVal = 0;
        int fVal = 0;
        //中止条件要非常清楚
        //只要后头还有路，我们就要继续走下去。
        while(firstTemp.next != null || secondTemp.next != null) {
            if(firstTemp.next == null) {
                firstTemp.next = secondTemp.next;
                secondTemp.next = null;
            }

            int addNum = (secondTemp.next == null)? 0 : secondTemp.next.val;
            fVal = firstTemp.next.val + addNum + aVal;
            if(fVal >= 10) {
                fVal = fVal - 10;
                aVal = 1;
            }else { aVal = 0; }

            firstTemp.next.val = fVal;
            firstTemp = firstTemp.next;
            if(secondTemp.next != null) { secondTemp = secondTemp.next; }
        }

        if(aVal == 1) { firstTemp.next = new ListNode(1); }

        return l1;
    }
}
