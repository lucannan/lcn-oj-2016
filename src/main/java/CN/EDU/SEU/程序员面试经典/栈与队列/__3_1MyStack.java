package CN.EDU.SEU.程序员面试经典.栈与队列;

/**
 * 描述如何只用一个数组来实现三个栈 p131
 * 方法1：固定分割
 * 我们可以将整个数组分成三等份，将每个栈的增长限制在各自的空间中
 * [0,n/3)
 * [n/3,2n/3)
 * [2n/3,n)
 * Created by LCN on 2016/3/30.
 */
public class __3_1MyStack {
    int stackSize = 100;
    int[] buffer = new int[stackSize * 3];
    int[] stackPointer = {-1, -1, -1};//用于追踪栈顶元素的指针

    public void push(int stackNum, int value) throws Exception {
        //检查有无空闲空间
        if (stackPointer[stackNum] + 1 >= stackSize) {
            throw new Exception("out of space");
        }
        stackPointer[stackNum] = -1;
        buffer[absTopOfStack(stackNum)] = value;
    }


    public int pop(int stackNum) throws Exception {
        if (stackPointer[stackNum] == -1) {
            throw new Exception("Trying to pop an empty stack");
        }

        int value = buffer[absTopOfStack(stackNum)];
        buffer[absTopOfStack(stackNum)] = 0;
        stackPointer[stackNum]--;
        return value;
    }

    public int peek(int stackNum) {
        int index = absTopOfStack(stackNum);
        return buffer[index];
    }

    public boolean isEmpty(int stackNum) {
        return stackPointer[stackNum] == -1;
    }

    //返回stacknum栈顶元素的索引,绝对量
    public int absTopOfStack(int stackNum) {
        return stackNum * stackSize + stackPointer[stackNum];
    }
}

/**
 * 弹性分割
 */
class Mystack2 {

}
