package CN.EDU.SEU.BFSandDFS;

import java.util.*;

/**
 * 倒水问题
 * 4个水杯中的水从一个开始状态到一个目标状态
 * Created by LCN on 2016/4/5.
 */
@SuppressWarnings("all")
public class BottleBFS {

    public static void main(String[] args) {
        int[] bottlesStart = {10, 0, 0, 0};
        BottleState startState = new BottleState(bottlesStart);
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int[] bottles = new int[4];
            bottles[0] = scanner.nextInt();
            bottles[1] = scanner.nextInt();
            bottles[2] = scanner.nextInt();
            bottles[3] = scanner.nextInt();
            BottleState endState = new BottleState(bottles);
            System.out.println(BottleState.bfs(startState, endState));

            MyHashMap<BottleState, BottleState> path = new MyHashMap<>();
            System.out.println(BottleState.bfs(startState, endState, path));

            BottleState child = endState;
            while (child != null) {
                child = path.get(child);
                System.out.println(child);
            }
        }
    }
}

@SuppressWarnings("all")
class BottleState {
    public int[] bottles = new int[4]; //代表四个水杯中现在的水量
    public int[] capacity = new int[4]; //代表水杯的容量

    public BottleState(int[] bottles) {
        capacity[0] = 10;
        capacity[1] = 6;
        capacity[2] = 5;
        capacity[3] = 4;

//        this.bottles[0] = bottles[0];
//        this.bottles[1] = bottles[1];
//        this.bottles[2] = bottles[2];
//        this.bottles[3] = bottles[3];

        this.bottles = bottles.clone();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BottleState that = (BottleState) o;

        if (!Arrays.equals(bottles, that.bottles)) return false;
        return Arrays.equals(capacity, that.capacity);

    }

    @Override
    public int hashCode() {
        int result = Arrays.hashCode(bottles);
        result = 31 * result + Arrays.hashCode(capacity);
        return result;
    }


    public List<BottleState> nextState() {
        List<BottleState> bottleStates = new ArrayList<>();
        //每个水杯有三种状态，可以往其他三个水杯中倒水
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if (i == j) {
                    continue;
                }

                int[] newBottles = new int[4];
                newBottles[0] = bottles[0];
                newBottles[1] = bottles[1];
                newBottles[2] = bottles[2];
                newBottles[3] = bottles[3];

                if (capacity[j] >= newBottles[i] + newBottles[j]) {
                    newBottles[j] = newBottles[i] + newBottles[j];
                    newBottles[i] = 0;
                } else {
                    int temp = capacity[j] - newBottles[j];
                    newBottles[j] = newBottles[j] + temp;
                    newBottles[i] = newBottles[i] - temp;
                }
                bottleStates.add(new BottleState(newBottles));
            }
        }
        return bottleStates;
    }

    /**
     * 广度优先
     *
     * @param startState
     * @param endState
     * @return
     */
    public static int bfs(BottleState startState, BottleState endState) {
        Set<BottleState> visited = new HashSet<>();
        Queue<BottleState> queue = new ArrayDeque<>();
        Queue<Integer> depths = new ArrayDeque<>();
        queue.add(startState);
        depths.add(0);
        visited.add(startState);

        while (!queue.isEmpty()) {
            BottleState currentState = queue.poll();
            int currentDepth = depths.poll();
            visited.add(currentState);
            if (currentState.equals(endState)) {
                return currentDepth;
            }

            for (BottleState nextState : currentState.nextState()) {
                if (!visited.contains(nextState)) {
                    depths.add(currentDepth + 1);
                    queue.add(nextState);
                }
            }

        }
        return -1;
    }


    /**
     * 记住倒水的步骤
     *
     * @param startState
     * @param endState
     * @param path
     * @return
     */
    public static int bfs(BottleState startState, BottleState endState, MyHashMap<BottleState, BottleState> path) {
        Set<BottleState> visited = new HashSet<>();
        Queue<BottleState> queue = new ArrayDeque<>();
        Queue<Integer> depths = new ArrayDeque<>();
        queue.add(startState);
        depths.add(0);
        visited.add(startState);
        path.put(startState, null);
        while (!queue.isEmpty()) {
            BottleState currentState = queue.poll();
            int currentDepth = depths.poll();
            visited.add(currentState);
            if (currentState.equals(endState)) {
                return currentDepth;
            }

            for (BottleState nextState : currentState.nextState()) {
                if (!visited.contains(nextState)) {
                    depths.add(currentDepth + 1);
                    queue.add(nextState);
                    //儿子记住父亲  hash前面的值不能被后面的值覆盖
                    path.put(nextState, currentState);
                }
            }

        }
        return -1;
    }


    @Override
    public String toString() {
        return "BottleState{" +
                "bottles=" + Arrays.toString(bottles) +
                '}';
    }
}


class MyHashMap<K, V> extends HashMap<K, V> {
    @Override
    public V put(K key, V value) {
        //如果已经存在key，不覆盖原有key对应的value
        if (!this.containsKey(key))
            return super.put(key, value);

        return null;
    }
}
