package CN.EDU.SEU.程序员面试经典.栈与队列;


import java.util.Stack;

/**
 * 清设计一个栈，除pop和push方法，还支持min，可以返回栈元素的最小值
 * push pop 和 min 的时间复杂度必须是O(1)
 * Created by LCN on 2016/3/31.
 */
public class __3_2StackWithMin extends Stack<NodeWithMin> {

    public void push(int value) {
        int newMin = Math.min(value, min());
        super.push(new NodeWithMin(value, newMin));
    }

    public int min() {
        if (this.empty()) {
            return Integer.MAX_VALUE;
        } else {
            return peek().min;
        }
    }
}

class NodeWithMin {
    public int value;
    public int min;

    public NodeWithMin(int v, int min) {
        value = v;
        this.min = min;
    }
}


class StackWithMin2 extends Stack<Integer> {
    Stack<Integer> s2;

    public StackWithMin2() {
        s2 = new Stack<Integer>();
    }

    public void push(int value) {
        if (value <= min()) {
            s2.push(value);
        }
        super.push(value);
    }

    public Integer pop() {
        int value = super.pop();
        if (value == min()) {
            s2.pop();
        }
        return value;
    }

    public int min() {
        if (s2.isEmpty()) {
            return Integer.MAX_VALUE;
        } else {
            return s2.peek();
        }
    }
}
