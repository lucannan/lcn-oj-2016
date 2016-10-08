package CN.EDU.SEU.程序员面试经典.链表;

/**
 * 实现一个算法，找出单向链表中倒数第k个结点
 * Created by LCN on 2016/3/28.
 */
public class __2_2NthToNext {

    /**
     * 递归方法
     *
     * @param head
     * @param k
     * @return
     */
    public static int nthToNext(LinkedListNode head, int k) {
        if (head == null) {
            return 0;
        }
        int i = nthToNext(head.next, k) + 1;
        if (i == k) {
            System.out.println(head.data);
        }
        return i;
    }


    public static LinkedListNode nthToNext2(LinkedListNode head, int k) {
        if (k <= 0) return null;
        LinkedListNode p1 = head;
        LinkedListNode p2 = head;

        for (int i = 0; i < k - 1; i++) {
            if (p2 == null) return null;
            p2 = p2.next;
        }
        if (p2 == null) return null;

        while (p2.next != null) {
            p1 = p1.next;
            p2 = p2.next;
        }

        return p1;
    }


    public static LinkedListNode nthToNext3(LinkedListNode head,int k,Integer integer){
        if(head == null){
            return null;
        }

        LinkedListNode node = nthToNext3(head.next,k,integer);
        integer++;
        if (integer == k){
            return head;
        }
        return node;
    }
}
