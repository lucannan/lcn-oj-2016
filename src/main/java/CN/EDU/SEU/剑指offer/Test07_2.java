package CN.EDU.SEU.剑指offer;

import org.junit.Test;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 两个队列模拟一个栈
 * Created by LCN on 2016/4/19.
 */
public class Test07_2 {

    public static class MyStack {
        private Deque<Integer> deque1 = new ArrayDeque<>();
        private Deque<Integer> deque2 = new ArrayDeque<>();

        public void add(int data) {
            if (deque1.isEmpty() && deque2.isEmpty()) {
                deque1.add(data);
                return;
            }
            if (!deque1.isEmpty()) {
                deque1.add(data);
            } else {
                deque2.add(data);
            }
        }

        public int pop() {
            if (deque1.isEmpty() && deque2.isEmpty()) {
                throw new RuntimeException("no more data to delete");
            }
            int data = 0;
            if (deque1.isEmpty()) {
                while (!deque2.isEmpty()) {
                    data = deque2.pop();
                    if (!deque2.isEmpty()) {
                        deque1.add(data);
                    }
                }
            } else {
                while (!deque1.isEmpty()) {
                    data = deque1.pop();
                    if (!deque1.isEmpty()) {
                        deque2.add(data);
                    }
                }
            }
            return data;
        }
    }

    @Test
    public void test() {
        MyStack myStack = new MyStack();
        myStack.add(1);
        myStack.add(2);
        myStack.add(3);
        myStack.add(4);
        myStack.add(5);

        System.out.println(myStack.pop());
        System.out.println(myStack.pop());
        System.out.println(myStack.pop());
        System.out.println(myStack.pop());
        System.out.println(myStack.pop());
        System.out.println(myStack.pop());


//        myStack.pop();
//        myStack.pop();
    }
}
