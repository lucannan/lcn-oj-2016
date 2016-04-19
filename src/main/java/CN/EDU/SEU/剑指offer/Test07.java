package CN.EDU.SEU.剑指offer;

import java.util.Stack;

/**
 * 两个栈实现一个队列
 * Created by LCN on 2016/4/19.
 */
public class Test07 {
    public static class MyQueue {
        //插入栈，用于插入数据
        public Stack stack1 = new Stack();
        //弹出栈，用于弹出数据
        public Stack stack2 = new Stack();

        public void enQueue(int data) {
            stack1.add(data);
        }

        public int deQueue() {
            if (stack2.isEmpty()) {
                while (!stack1.isEmpty()) {
                    stack2.add(stack1.pop());
                }
            }

            if (stack1.isEmpty()) {
                throw new RuntimeException("No more element.");
            }
            return (int) stack2.pop();
        }
    }
}
