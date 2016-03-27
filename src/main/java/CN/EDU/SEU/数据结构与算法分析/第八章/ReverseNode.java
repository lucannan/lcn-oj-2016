package CN.EDU.SEU.数据结构与算法分析.第八章;

/**
 * Created by LCN on 2016/3/22.
 */
public class ReverseNode {


    /**
     * 对链表进行反转
     */
    public void ReverNode(Node head) {
        Node pReverseHead = head;
        Node pNode = head;
        Node pRev = null;

        while (pNode != null) {
            Node pNext = pNode.next;
            if (pNext == null) {
                pReverseHead = pNode;
            }
            pNode.next = pRev;
            pRev = pNode;
            pNode = pNext;
        }
        head = pReverseHead;
    }


    /**
     * 判断链表是否有环
     */
    public static boolean IsLoop(Node head) {
        Node fast = head;
        Node slow = head;

        if (fast == null) {
            return false;
        }

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                return true;
            }
        }
        return false;
    }


    /**
     * 找到链表环的入口
     */
    public static Node findLoopPort(Node head) {
        Node slow = head, fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast)
                break;
        }

        if (fast == null || fast.next == null) {
            return null;
        }

        slow = head;
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }


    /**
     * 判断两个链表是否相交
     *
     * @param h1
     * @param h2
     * @return
     */
    public static boolean isIntersection(Node h1, Node h2) {
        if (h1 == null || h2 == null) {
            return false;
        }
        Node tail1 = h1;
        while (tail1.next != null) {
            tail1 = tail1.next;
        }

        Node tail2 = h2;
        while (tail2.next != null) {
            tail2 = tail2.next;
        }

        return tail1 == tail2;
    }


    /**
     * 如果两个链表相交，找到他们相交的一个结点
     *
     * @param h1
     * @param h2
     * @return
     */
    public static Node getFirstMeetNode(Node h1, Node h2) {
        if (h1 == null || h2 == null) {
            return null;
        }

        Node tail1 = h1;
        int len1 = 1;
        while (tail1.next != null) {
            tail1 = tail1.next;
            len1++;
        }

        Node tail2 = h2;
        int len2 = 1;

        while (tail2.next != null) {
            tail2 = tail2.next;
            len2++;
        }

        if (tail1 != tail2) {
            return null;
        }

        Node t1 = h1;
        Node t2 = h2;
        if (len1 > len2) {
            int d = len1 - len2;
            while (d != 0) {
                t1 = t1.next;
                d--;
            }
        } else {
            int d = len2 - len1;
            while (d != 0) {
                t2 = t2.next;
                d--;
            }
        }

        while (t1 != t2) {
            t1 = t1.next;
            t2 = t2.next;
        }

        return t1;

    }

}


class Node {
    Node next;
    int val;
}
