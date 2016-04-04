package CN.EDU.SEU;
import java.util.*;
public class Main {
    public static class BottleState {
        int[] bottles = new int[4];
        int[] capacity = new int[4];

        public BottleState(int[] bottles) {
            this.capacity[0] = 10;
            this.capacity[1] = 6;
            this.capacity[2] = 5;
            this.capacity[3] = 4;

            this.bottles[0] = bottles[0];
            this.bottles[1] = bottles[1];
            this.bottles[2] = bottles[2];
            this.bottles[3] = bottles[3];
        }

        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            BottleState state = (BottleState) o;

            if (!Arrays.equals(bottles, state.bottles)) return false;
            return Arrays.equals(capacity, state.capacity);

        }

        public int hashCode() {
            int result = Arrays.hashCode(bottles);
            result = 31 * result + Arrays.hashCode(capacity);
            return result;
        }

        public List<BottleState> nextStates() {
            List<BottleState> states = new ArrayList<>();
            for (int i = 0; i < 4; ++i) {
                for (int j = 0; j < 4; ++j) {
                    int[] temp = new int[4];
                    temp[0] = bottles[0];
                    temp[1] = bottles[1];
                    temp[2] = bottles[2];
                    temp[3] = bottles[3];
                    if (j == i)
                        continue;
                    // i -> j
                    if (capacity[j] >= temp[i] + temp[j]) {
                        temp[j] += temp[i];
                        temp[i] -= temp[i];
                    } else {
                        int offset = capacity[j] - temp[j];
                        temp[j] += offset;
                        temp[i] -= offset;
                    }
                    states.add(new BottleState(temp));
                }
            }
            return states;
        }
    }

    public static int Bottlebfs(BottleState begin, BottleState end) {
        Set<BottleState> visited = new HashSet<>();
        Queue<BottleState> states = new ArrayDeque<>();
        Queue<Integer> depths = new ArrayDeque<>();
        states.add(begin);
        depths.add(0);
        visited.add(begin);
        while (states.size() != 0) {
            BottleState current = states.poll();
            int currentDepth = depths.poll();
            visited.add(current);
            if (current.equals(end)) {
                return currentDepth;
            }
            for (BottleState nextState : current.nextStates()) {
                if (!visited.contains(nextState)) {
                    depths.add(currentDepth + 1);
                    states.add(nextState);
                }
            }
        }
        return -1;
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            BottleState beginState = new BottleState(new int[]{10, 0, 0, 0});
            int bottom1 = scanner.nextInt();
            int bottom2 = scanner.nextInt();
            int bottom3 = scanner.nextInt();
            int bottom4 = scanner.nextInt();
            BottleState endState = new BottleState(new int[]{bottom1, bottom2, bottom3, bottom4});
            System.out.println(Bottlebfs(beginState, endState));
        }
    }



}
