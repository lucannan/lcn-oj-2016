package CN.EDU.SEU.BFSandDFS.dfs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by LCN on 2017-1-12.
 */
public class Solution_210 {

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adjList = new ArrayList<>();
        for (int i = 0; i < numCourses; ++i) {
            adjList.add(new ArrayList<Integer>());
        }
        for (int[] edge : prerequisites) {
            adjList.get(edge[1]).add(edge[0]);
        }
        int[] status = new int[numCourses];  // 0 -- unvisited; 1 -- being visited; 2 -- visited.
        LinkedList<Integer> topoSeq = new LinkedList<>();
        for (int i = 0; i < numCourses; ++i) {
            if (status[i] == 0) {
                if (isCycleExisting(topoSeq, adjList, status, i)) {  // cycle exists
                    return new int[0];
                }
            }
        }
        int[] ans = new int[topoSeq.size()];
        for (int i = 0; i < ans.length; ++i) {
            ans[i] = topoSeq.get(i);
        }
        return ans;
    }

    private boolean isCycleExisting(LinkedList<Integer> topoSeq, List<List<Integer>> adjList, int[] status, int cur) {
        status[cur] = 1;  // current vertex is being visited, that is, in recursion stack
        for (Integer succ : adjList.get(cur)) {
            if (status[succ] == 1) {
                return true;
            }  // back edge detected, cycle exits
            if (status[succ] == 0) {  // visit the unvisited vertices
                if (isCycleExisting(topoSeq, adjList, status, succ)) {  // cycle exists in sub-graph
                    return true;
                }
            }
        }
        // cur vertex and its subgraph visited; pop it out of recursion stack; add it to the front of topological sequence
        topoSeq.addFirst(cur);
        status[cur] = 2;
        return false;
    }
}
