package com.yuehua.datastructure.queue;

import java.util.Scanner;

public class CircleArrayQueueDemo {
    public static void main(String[] args) {
        CircleArrayQueue arrayQueue = new CircleArrayQueue(4);
        char key = ' ';
        Scanner scanner = new Scanner(System.in);
        boolean loop = true;
        while (loop) {
            System.out.println("s=>显示数据");
            System.out.println("e=>退出");
            System.out.println("a=>添加数据");
            System.out.println("g=>获取数据");
            System.out.println("h=>查看头数据");
            key = scanner.next().charAt(0);
            switch (key) {
                case 's':
                    arrayQueue.showQueue();
                    break;
                case 'a':
                    System.out.println("输入一个数字");
                    int value = scanner.nextInt();
                    arrayQueue.addQueue(value);
                    break;
                case 'g':
                    try {
                        int queue = arrayQueue.getQueue();
                        System.out.printf("取出的数据是%d\n", queue);
                    } catch (Exception e) {

                        System.out.println(e.getMessage());
                    }
                    break;
                case 'h':
                    try {
                        int res = arrayQueue.headQueue();
                        System.out.printf("头部数据是%d\n", res);
                    } catch (Exception e) {

                    }
                    break;
                case 'e':
                    scanner.close();
                    loop = false;
                    break;

                default:
                    break;
            }
        }
        System.out.println("程序退出");

    }
}

/**
 * 数组模拟队列
 */
class CircleArrayQueue {
    // 数组最大容量
    private int maxSize;
    //    队列头
    private int front;
    // 队列尾
    private int rear;
    private int[] arr;

    // 构造方法
    public CircleArrayQueue(int maxSize) {
        this.maxSize = maxSize;
        arr = new int[maxSize];
        front = 0;
        rear = 0;
    }

    public boolean isEmpty() {
        return rear == front;
    }

    public boolean isFull() {
        return (rear + 1) % maxSize == front;
    }

    public void addQueue(int n) {
        if (isFull()) {
            System.out.println("数组满了，不能加入数据");
            return;
        }

        arr[rear] = n;
        rear = (rear + 1) % maxSize;
    }

    public int getQueue() {
        if (isEmpty()) {
            throw new RuntimeException("队列为空，不能取数据");
        }
        int tmp = arr[front];
        front = (front + 1) % maxSize;
        return tmp;
    }

    public void showQueue() {
        if (isEmpty()) {
            System.out.println("队列为空，没有数据展示");
            return;
        }
        int size = size();
        for (int i = front; i < front + size; i++) {
            System.out.printf("arr[%d]=%d\n", i % maxSize, arr[i % maxSize]);

        }
    }

    private int size() {
        return (rear - front + maxSize) % maxSize;
    }

    public int headQueue() {
        if (isEmpty()) {
            throw new RuntimeException("队列为空，没有数据");

        }
        return arr[front];
    }


}