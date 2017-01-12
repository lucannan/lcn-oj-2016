package CN.EDU.SEU.BFSandDFS.dfs;

import java.util.ArrayList;

/**
 * Created by LCN on 2017-1-12.
 */
public class Solution_207 {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        ArrayList<Integer>[] cs = new ArrayList[numCourses];
        for (int i = 0; i < numCourses; i++) cs[i] = new ArrayList();
        for (int[] edges : prerequisites) cs[edges[1]].add(edges[0]);
        boolean[] visiting = new boolean[numCourses];
        boolean[] visited = new boolean[numCourses];
        for (int i = 0; i < numCourses; i++)
            if (!visited[i] && !dfs(i, cs, visited, visiting)) return false;
        return true;
    }

    private boolean dfs(int i, ArrayList<Integer>[] cs, boolean[] visited, boolean[] visiting) {
        visiting[i] = true;
        for (int dest : cs[i])
            if (visiting[dest] || (!visited[dest] && !dfs(dest, cs, visited, visiting))) return false;
        visiting[i] = false;
        visited[i] = true;
        return true;
    }
}
