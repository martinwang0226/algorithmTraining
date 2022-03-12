package com.example.lib.StackQueue;

/**
 * Create by chenlong.wang
 * on 2020/9/3
 */
public class arrayStack {
    /**
     * 固定分割
     */
    int stackSize = 100;
    int[] buffer = new int[3 * stackSize];
    int[] stackPointer = {-1, -1, -1};

    public void push(int stackNum, int value) throws Exception {
        //检查有无空闲控件
        if (stackPointer[stackNum] + 1 >= stackSize) {
            throw new Exception("Out of space.");
        }
        stackPointer[stackNum]++;
        buffer[absTopOfStack(stackNum)] = value;
    }

    public int pop(int stackNum) throws Exception {
        if (stackPointer[stackNum] == -1) {
            throw new Exception("Trying to pop an empty stack.");
        }
        int value = buffer[absTopOfStack(stackNum)];
        buffer[absTopOfStack(stackNum)] = 0;
        stackPointer[stackNum]--;
        return value;
    }

    public int peek(int stackNum) {
        return buffer[absTopOfStack(stackNum)];
    }

    public boolean isEmpty(int stackNum) {
        return stackPointer[stackNum] == -1;
    }

    //返回栈stackNum栈顶元素的索引，绝对量
    public int absTopOfStack(int stackNum) {
        return stackNum * stackSize + stackPointer[stackNum];
    }
}
