package CN.EDU.SEU.极客学院名企面试.链表操作;

/**
 * 最开始的一个结点保存数据
 * Created by LCN on 2016/4/14.
 */
public class ListNode<T> {
    public T value;
    public ListNode<T> next;


    public ListNode(T value) {
        this.value = value;
    }

    public ListNode(T value, ListNode<T> next) {
        this.value = value;
        this.next = next;
    }

    public ListNode() {
    }


    @Override
    public String toString() {
        return "ListNode [val=" + value + "]";
    }

    public static void printList(ListNode head) {
        ListNode p = head;
        while (p != null) {
            System.out.print(p.value + " ");
            p = p.next;
        }
        System.out.println();
    }

    public ListNode<T> arrayToList(T[] array) {
        ListNode<T> head = new ListNode(0);
        ListNode p = head;
        for (T value : array) {
            p.next = new ListNode(value);
            p = p.next;
        }
        return head.next;
    }
}
