package CN.EDU.SEU.BFSandDFS;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

/**
 * Created by LCN on 2016/4/6.
 */
public class BFS_127 {
    public int ladderLength(String beginWord, String endWord, Set<String> wordDict) {
        LinkedList<WordNode> queue = new LinkedList<WordNode>();
        Set<String> visited = new HashSet<>();
        queue.add(new WordNode(beginWord, 1));
        wordDict.add(endWord);
        visited.add(beginWord);
        while (!queue.isEmpty()) {
            WordNode top = queue.poll();
            String word = top.word;
            visited.add(word);
            if (word.equals(endWord)) {
                return top.numSteps;
            }

            char[] arr = word.toCharArray();
            for (int i = 0; i < arr.length; i++) {
                for (char c = 'a'; c <= 'z'; c++) {
                    char temp = arr[i];
                    if (arr[i] != c) {
                        arr[i] = c;
                    }
                    String newWord = new String(arr);
                    if (wordDict.contains(newWord) && (!visited.contains(newWord))) {
                        queue.add(new WordNode(newWord, top.numSteps + 1));
                        wordDict.remove(newWord);
                    }
                    arr[i] = temp;
                }
            }
        }
        return 0;
    }
}

class WordNode {
    String word;
    int numSteps;   //存储该结点在图的第几层

    public WordNode(String word, int numSteps) {
        this.word = word;
        this.numSteps = numSteps;
    }
}
