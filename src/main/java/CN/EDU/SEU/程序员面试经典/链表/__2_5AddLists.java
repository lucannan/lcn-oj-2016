package CN.EDU.SEU.程序员面试经典.链表;

/**
 * 给定两个链表表示的整数，每个结点包含一个数位。这些数位是反向存放的，也就是各位排在链表的首部
 * 编写函数对这两个整数求和，并用链表的形式返回结果
 * <p>
 * 进阶:
 * 假设这些数位是正向存放的，请再做一遍
 * Created by LCN on 2016/3/28.
 */
public class __2_5AddLists {

    public static LinkedListNode addLists(LinkedListNode l1, LinkedListNode l2, int carry) {
        if (l1 == null && l2 == null && carry == 0) {
            return null;
        }

        LinkedListNode result = new LinkedListNode();

        //将value以及l1和l2的data相加
        int value = carry;
        if (l1 != null) {
            value += l1.data;
        }

        if (l2 != null) {
            value += l2.data;
        }

        result.data = value % 10;

        LinkedListNode more = addLists(l1 == null ? null : l1.next,
                l2 == null ? null : l2.next, value >= 10 ? 1 : 0);
        result.next = more;

        return result;
    }


    /**
     * 返回链表的长度
     *
     * @param node
     * @return
     */
    public static int length(LinkedListNode node) {
        LinkedListNode temp = node;
        int count = 0;
        while (temp != null) {
            count++;
            temp = temp.next;
        }
        return count;
    }


    /**
     * 链表中的数是正向存放的
     *
     * @param l1
     * @param l2
     * @return
     */
    public static LinkedListNode addList2(LinkedListNode l1, LinkedListNode l2) {
        int len1 = length(l1);
        int len2 = length(l2);

        if (len1 < len2) {
            l1 = padList(l1, len2 - len1);
        } else {
            l2 = padList(l2, len1 - len2);
        }

        PartiaSum sum = addListHelper(l1, l2);

        if (sum.carry == 0) {
            return sum.sum;
        } else {
            LinkedListNode result = insertBefore(sum.sum, sum.carry);
            return result;
        }
    }


    public static PartiaSum addListHelper(LinkedListNode l1, LinkedListNode l2) {
        if (l1 == null && l2 == null) {
            PartiaSum sum = new PartiaSum();
            return sum;
        }
        //对较小的数字递归求和
        PartiaSum sum = addListHelper(l1.next, l2.next);
        //将进位和当前数据相加
        int val = sum.carry + l1.data + l2.data;

        LinkedListNode full_result = insertBefore(sum.sum, val % 10);

        sum.sum = full_result;
        sum.carry = val / 10;
        return sum;
    }


    /**
     * 用零来存储链表
     *
     * @param l1
     * @param padding
     * @return
     */
    public static LinkedListNode padList(LinkedListNode l1, int padding) {
        LinkedListNode head = l1;
        for (int i = 0; i < padding; i++) {
            LinkedListNode n = new LinkedListNode(0, null, null);
            head.before = n;
            n.next = head;
            head = n;
        }

        return head;
    }

    /**
     * 辅助函数：将结点插入到链表的首部
     *
     * @param listNode
     * @param data
     * @return
     */
    public static LinkedListNode insertBefore(LinkedListNode listNode, int data) {
        LinkedListNode node = new LinkedListNode(data, null, null);
        if (listNode != null) {
            listNode.before = node;
            node.next = listNode;
        }
        return node;
    }


    public static void main(String[] args) {

        //1934 +786

        LinkedListNode number1 = new LinkedListNode();
        number1.data = 1;
        number1.next = new LinkedListNode(9, null, null);
        number1.next.next = new LinkedListNode(3, null, null);
        number1.next.next.next = new LinkedListNode(4, null, null);

        LinkedListNode number2 = new LinkedListNode();
        number2.data = 7;
        number2.next = new LinkedListNode(8, null, null);
        number2.next.next = new LinkedListNode(6, null, null);


        LinkedListNode result = addList2(number1, number2);

        while (result !=null){
            System.out.println(result.data);
            result = result.next;
        }

    }
}


class PartiaSum {
    public LinkedListNode sum = null;
    public int carry = 0;
}


