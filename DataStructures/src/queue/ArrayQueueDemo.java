package queue;

/**
 * 通过数组实现队列
 *
 * @author chenzk
 * @create 2020-12-01 18:37
 */
public class ArrayQueueDemo {
    public static void main(String[] args) {
        ArrayQueue1 queue = new ArrayQueue1(3);
        System.out.println(queue.isEmpty());
        queue.addQueueMember(5);
        System.out.println(queue.isEmpty());
        queue.addQueueMember(10);
        queue.addQueueMember(15);
        int m1 = queue.getQueueMember();
        System.out.println(m1);
        int m2 = queue.getQueueMember();
        int m3 = queue.getQueueMember();
        queue.addQueueMember(20);
    }
}

class ArrayQueue1 {
    private int maxSize;
    private int front;
    private int rear;
    private int[] data;

    public ArrayQueue1(int maxSize) {
        this.maxSize = maxSize;
        data = new int[maxSize];
        front = -1;
        rear = -1;
    }

    //判断队列是否满了
    public boolean isFull() {
        if (rear == maxSize - 1) {
            return true;
        }
        return false;
    }

    //判断队列是否为空
    public boolean isEmpty() {
        if (front == rear) {
            return true;
        }
        return false;
    }

    /**
     * @param member
     * @return boolean值代表添加成功与否，若添加成功则为true，添加失败则为false。
     */
    public boolean addQueueMember(int member) {
        //先判断队列是否为满，如果满了则不能添加。
        if (isFull()) {
            System.out.println("队列已满，不能添加。");
            return false;
        }
        rear++;
        data[rear] = member;
        return true;
    }

    public int getQueueMember() {
        //先判断是否为空，若为空则无法取出数据。
        if (isEmpty()) {
            throw new RuntimeException("队列为空，不能取出数据");
        }
        front++;
        return data[front];
    }
}
