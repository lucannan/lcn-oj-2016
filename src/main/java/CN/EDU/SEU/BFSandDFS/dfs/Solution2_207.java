package CN.EDU.SEU.BFSandDFS.dfs;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by LCN on 2017-1-12.
 */
public class Solution2_207 {


    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // O(V + E)
        List<Integer>[] matrix = new List[numCourses];
        int[] indegree = new int[numCourses];

        // E part
        for (int[] pre : prerequisites) {
            int preCourse = pre[1];
            int readyCourse = pre[0];
            List<Integer> list = matrix[preCourse];
            if (list == null) {
                list = new LinkedList<>();
                matrix[preCourse] = list;
            }
            list.add(readyCourse);
            indegree[readyCourse]++;
        }

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) queue.offer(i);
        }
        int count = 0;
        // V part
        while (!queue.isEmpty()) {
            int vertex = queue.poll();
            count++;
            List<Integer> adjacent = matrix[vertex];
            if (adjacent == null) continue;
            for (int neighbor : adjacent) {
                indegree[neighbor]--;
                if (indegree[neighbor] == 0)
                    queue.offer(neighbor);
            }
        }
        return count == numCourses;
    }
}
