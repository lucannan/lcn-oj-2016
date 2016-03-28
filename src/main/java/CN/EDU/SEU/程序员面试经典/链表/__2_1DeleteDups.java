package CN.EDU.SEU.程序员面试经典.链表;

import java.util.HashMap;
import java.util.Map;

/**
 * 编写代码，移除未排序链表中的重复结点
 * 进阶：
 * 如果不得使用临时缓冲区，该怎么解决
 * Created by LCN on 2016/3/28.
 */
public class __2_1DeleteDups {

    /**
     * 使用了缓冲区
     * @param n
     */
    public static void deleteDups(LinkedListNode n) {
        Map<Integer, Boolean> map = new HashMap<Integer, Boolean>();
        LinkedListNode previous = null;
        while (n!=null){
            if (map.containsKey(n.data)){
                previous.next = n.next;
            }else {
                map.put(n.data,true);
                previous = n;
            }
            n = n.next;
        }
    }


    /**
     * 不使用缓冲区
     * 使用两个指针来迭代   current迭代访问整个链表   runner用于检查后续的节点是否重复
     * @param n
     */
    public static void deleteDups2(LinkedListNode n){
        if (n == null) return;

        LinkedListNode current = n;
        while (current != null){
            //移除后面相同的结点
            LinkedListNode runner = current;
            while (runner.next !=null){
                if (runner.next.data == current.data){
                    runner.next = runner.next.next;
                }else {
                    runner = runner.next;
                }
            }
            current = current.next;
        }
    }

}

class LinkedListNode {
    int data;
    LinkedListNode before;
    LinkedListNode next;

    public LinkedListNode() {
    }

    public LinkedListNode(int data, LinkedListNode before, LinkedListNode next) {
        this.data = data;
        this.before = before;
        this.next = next;
    }
}
