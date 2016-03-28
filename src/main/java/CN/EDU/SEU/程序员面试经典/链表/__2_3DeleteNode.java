package CN.EDU.SEU.程序员面试经典.链表;

/**
 * 实现一个算法，删除单向链表中间的某个结点，
 * 假定你只能访问该结点
 * Created by LCN on 2016/3/28.
 */
public class __2_3DeleteNode {

    public static boolean deleteNode(LinkedListNode n) {
        if (n == null || n.next == null) {
            return false;
        }

        LinkedListNode next = n.next;
        n.data = next.data;
        n.next = next.next;
        return true;
    }
}
