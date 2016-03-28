package CN.EDU.SEU.程序员面试经典.链表;

/**
 * 给个一个有环链表，实现一个算法返回环路的开头结点
 * Created by LCN on 2016/3/28.
 */
public class __2_6FindBeginning {

    public static LinkedListNode FindBeginning(LinkedListNode head) {

        LinkedListNode slow = head;
        LinkedListNode fast = head;

        while (fast !=null && fast.next !=null){
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast){
                break;
            }
        }

        if (fast == null || fast.next ==null){
            return null;
        }

        slow = head;
        while (slow !=fast){
            slow = slow.next;
            fast = fast.next;
        }
        return fast;
    }
}
