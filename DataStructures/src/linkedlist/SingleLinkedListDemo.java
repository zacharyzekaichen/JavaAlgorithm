package linkedlist;

/**
 * @author chenzk
 * @create 2020-12-02 18:42
 */
public class SingleLinkedListDemo {
    public static void main(String[] args) {
        SingleLinkedList sLL = new SingleLinkedList();
        sLL.showLinkedList();
        sLL.addNodeOrder(new HeroNode(1,"a","aa"));
        sLL.addNodeOrder(new HeroNode(4,"b","bb"));
        sLL.addNodeOrder(new HeroNode(3,"c","cc"));
        sLL.addNodeOrder(new HeroNode(5,"d","dd"));
        sLL.addNodeOrder(new HeroNode(2,"e","ee"));
        sLL.modifyNodeInfo(7,"f","ff");
        sLL.showLinkedList();
    }
}

class SingleLinkedList {
    //创建头节点
    private HeroNode head = new HeroNode(0,"","");
//    private HeroNode rear = head;

    //添加节点到单向链表：不按编号次序排的
    public void addNode(HeroNode node){
        HeroNode tempNode = head;
        while(true){
            if(tempNode.next == null) {break;}
            tempNode = tempNode.next;
        }
        tempNode.next = node;
    }

    public void addNodeOrder(HeroNode newNode){
//        if(head.next == null) {head.next = newNode;}
        HeroNode tempNode = head;
        while(true) {
            //说明newNode已经在链表的最后
            if(tempNode.next == null) {
                tempNode.next = newNode;
                break;
            }
            //指针指向当前对应的元素的下一个元素
            //跟当前元素的id值进行比较，有三种情况，分类讨论：
            //值相同，此时输出错误信息。
            if(tempNode.next.id == newNode.id) {
                System.out.println("序号相同，添加失败");
                break;
            }
            //新加入的元素大于当前元素，此时指针往后挪动
            else if(tempNode.next.id < newNode.id) {
                tempNode = tempNode.next;
            }
            //新加入的元素小于当前元素，此时将其加入
            else if(tempNode.next.id > newNode.id) {
                newNode.next = tempNode.next;
                tempNode.next = newNode;
                break;
            }
        }
    }

    //修改节点，根据编号进行修改。
    public void modifyNodeInfo(int mId, String mName, String mNickName) {
        HeroNode tempNode = head;
        boolean noExistFlag = false;
        while(true) {
            if(tempNode.next == null) {
                noExistFlag = true;
                break;
            }
            //序号相等说明找到了节点，此时进行修改操作，修改完成后退出
            if(tempNode.next.id == mId) {
//                tempNode.next.name = mName;
//                tempNode.next.nickName = mNickName;
                break;
            }
            //序号大于输入序号说明不存在吻合的节点
            else if(tempNode.next.id > mId){
                noExistFlag = true;
                break;
            }

            tempNode = tempNode.next;
        }

        if(noExistFlag) {
            System.out.println("未找到吻合的修改序号");
        }else {
            tempNode.next.name = mName;
            tempNode.next.nickName = mNickName;
        }
    }

    //遍历单向链表
    public void showLinkedList(){
//        HeroNode tempNode = list.head;
//        while (true){
//            if(tempNode.next == null){
//                System.out.println("单向链表遍历结束");
//                return;
//            }
//            System.out.println(tempNode.next.toString());
//            tempNode = tempNode.next;
//        }

        if(head.next == null) {
            System.out.println("链表为空");
            return;
        }
        HeroNode tempNode = head.next;
        while(true){
            if(tempNode == null) {
                System.out.println("遍历结束");
                break;
            }
            System.out.println(tempNode);
            tempNode = tempNode.next;
        }
    }
}

//定义
class HeroNode{
    public int id;
    public String name;
    public String nickName;
    public HeroNode next;

    public HeroNode(int id, String name, String nickName){
        this.id = id;
        this.name = name;
        this.nickName = nickName;
    }

    @Override
    public String toString() {
        return "HeroNode{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", nickName='" + nickName + '\'' +
                '}';
    }
}
