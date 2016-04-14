package CN.EDU.SEU.极客学院名企面试.链表操作;

import java.util.List;

/**
 * Created by LCN on 2016/4/14.
 */
public class ListNode<T> {
    public T value;
    public ListNode<T> next;

    public ListNode(T value, ListNode<T> next) {
        this.value = value;
        this.next = next;
    }
    public ListNode() {
    }


    public ListNode<T> pre;
}
