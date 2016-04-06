package CN.EDU.SEU.BFSandDFS;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * clone方法基本的数据类型可以使用
 * Created by LCN on 2016/4/6.
 */
public class leetcode__133 {
    public static void main(String[] args) {
    }
}

class UndirectedGraphNode {
    int label;
    List<UndirectedGraphNode> neighbors;

    UndirectedGraphNode(int x) {
        label = x;
        neighbors = new ArrayList<UndirectedGraphNode>();
    }
}

class Solution {
    HashMap<UndirectedGraphNode, UndirectedGraphNode> map = new HashMap<>();

    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if (node == null) return null;
        if (!map.containsKey(node)) {
            int label = node.label;
            List<UndirectedGraphNode> neighbors = node.neighbors;
            List<UndirectedGraphNode> newNeighbors = new ArrayList<>();
            UndirectedGraphNode newNode = new UndirectedGraphNode(label);
            map.put(node, newNode);
            for (UndirectedGraphNode cur : neighbors) newNeighbors.add(cloneGraph(cur));
            newNode.neighbors = newNeighbors;
        }
        return map.get(node);
    }

}
