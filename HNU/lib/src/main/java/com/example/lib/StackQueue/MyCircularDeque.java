package com.example.lib.StackQueue;

/**
 * Create by chenlong.wang
 * 设计循环双端队列
 * on 2020/9/20
 */
public class MyCircularDeque {
    private int[] elements;
    private int size;

    public MyCircularDeque(int k) {
        elements = new int[k];
    }

    public boolean insertFront(int value) {
        if (isFull()) {
            return false;
        }
        for (int i = size - 1; i >= 0; i--) {
            elements[i + 1] = elements[i];
        }
        elements[0] = value;
        size++;
        return true;
    }

    public boolean insertLast(int value) {
        if (isFull()) {
            return false;
        }
        elements[size] = value;
        size++;
        return true;
    }

    public boolean deleteFront() {
        if (isEmpty()) {
            return false;
        }
        elements[0] = 0;
        for (int i = 0; i < size - 1; i++) {
            elements[i] = elements[i + 1];
        }
        size--;
        return true;
    }

    public boolean deleteLast() {
        if (isEmpty()) {
            return false;
        }
        elements[size - 1] = 0;
        size--;
        return true;
    }

    public int getFront() {
        return size == 0 ? -1 : elements[0];
    }

    public int getRear() {
        return size == 0 ? -1 : elements[size - 1];
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == elements.length;
    }
}
