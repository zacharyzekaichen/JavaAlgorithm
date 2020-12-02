package queue;

import org.junit.Test;

import java.util.ArrayList;

/**
 * @author chenzk
 * @create 2020-12-01 20:20
 */
public class ArrayQueueLoopDemo {

    @Test
    public void tes1(){

    }

    public static void main(String[] args) {
        ArrayQueue2 queue = new ArrayQueue2(3);
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

class ArrayQueue2 {
    private int maxSize;
    private int front;
    private int rear;
    private int[] data;

    //front和rear的含义跟之前是不一样的。
    //front：头部索引
    //rear：末尾索引的后一位索引，希望空出一个元素。
    public ArrayQueue2(int maxSize) {
        this.maxSize = maxSize;
        data = new int[maxSize];
        front = 0;
        rear = 0;
    }

    //判断队列是否满了
    public boolean isFull() {
        return (rear + 1) % maxSize == front;
    }

    //判断队列是否为空
    public boolean isEmpty() {
        return front == rear;
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
        data[rear] = member;
        rear = (rear + 1) % maxSize;
        return true;
    }

    public int getQueueMember() {
        //先判断是否为空，若为空则无法取出数据。
        if (isEmpty()) {
            throw new RuntimeException("队列为空，不能取出数据");
        }
        int returnValue = data[front];
        front = (front + 1) % maxSize;
        return returnValue;
    }
}
