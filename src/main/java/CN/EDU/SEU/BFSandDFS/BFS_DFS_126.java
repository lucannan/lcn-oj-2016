package CN.EDU.SEU.BFSandDFS;

import java.util.*;

/**
 * leetcode 126 word ladder 2
 * Created by LCN on 2016/4/6.
 */
public class BFS_DFS_126 {

    public List<List<String>> findLadders(String beginWord, String endWord, Set<String> wordList) {
        if (wordList.contains(beginWord)) wordList.remove(beginWord);
        //所有的结果
        List<List<String>> result = new ArrayList<>();
        //单个结果
        List<String> subResult = new ArrayList<>();
        //加入最后字符
        wordList.add(endWord);
        WordLadderNode root = new WordLadderNode(0, beginWord, new ArrayList<WordLadderNode>());
        //只可能的最大的长度
        int[] min = new int[]{wordList.size()};
        //构建图
        buildTreeBFS(beginWord, endWord, root, wordList, min);
        //寻找最终状态
        searchPathDFS(root, endWord, subResult, result, min);
        return result;
    }


    public void searchPathDFS(WordLadderNode root, String endWord, List<String> subResult, List<List<String>> result, int[] min) {
        if (root == null) return;
        subResult.add(root.name);
        if (endWord.equals(root.name)) {
            if (root.index <= min[0]) result.add(subResult);
            return;
        }
        for (WordLadderNode nextRoot : root.next) {
            //subResult每次递归回退一次 就变成上一次的值
            searchPathDFS(nextRoot, endWord, new ArrayList<>(subResult), result, min);
        }
    }

    //获得下一层结点的状态
    public List<String> getNext(String word, String endWord, Set<String> wordList) {
        List<String> result = new ArrayList<>();
        char[] wordArray = word.toCharArray();
        for (int i = 0; i < wordArray.length; i++) {
            char old = wordArray[i];
            for (char c = 'a'; c <= 'z'; c++) {
                if (c == old) continue;
                wordArray[i] = c;
                String temp = new String(wordArray);
                if (wordList.contains(temp)) {
                    //当前值为目标状态   则将其放置于结果集的最开始位置，这样在DFS遍历的时候就能直接取到判断
                    if (endWord.equals(temp)) result.add(0, temp);
                    else result.add(temp);
                }
            }
            wordArray[i] = old;
        }
        return result;
    }


    public void buildTreeBFS(String beginWord, String endWord, WordLadderNode root, Set<String> wordList, int[] min) {
        Set<String> visited = new HashSet<>();
        visited.add(beginWord);
        Queue<WordLadderNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            Queue<WordLadderNode> nextQueue = new LinkedList<>();
            Set<String> tempVisited = new HashSet<>();
            while (!queue.isEmpty()) {
                WordLadderNode currNode = queue.poll();
                int index = currNode.index;
                for (String neighbor : getNext(currNode.name, endWord, wordList)) {
                    if (endWord.equals(neighbor)) {
                        if (index + 1 <= min[0]) {
                            WordLadderNode temp = new WordLadderNode(index + 1, neighbor, null);
                            currNode.next.add(temp);
                            min[0] = index + 1;
                        }
                        continue;
                    }
                    if (!visited.contains(neighbor)) {
                        tempVisited.add(neighbor);
                        WordLadderNode temp = new WordLadderNode(index + 1, neighbor, new ArrayList<WordLadderNode>());
                        //加入队列
                        nextQueue.offer(temp);
                        //父亲结点更新儿子信息
                        currNode.next.add(temp);
                    }
                }
            }
            visited.addAll(tempVisited);
            queue = nextQueue;
        }
    }

    class WordLadderNode {
        public int index;
        public String name;
        public List<WordLadderNode> next;

        public WordLadderNode(int index, String name, List<WordLadderNode> next) {
            this.index = index;
            this.name = name;
            this.next = next;
        }
    }


    public static void main(String[] args) {
        String beginWord = "hit";
        String endWord = "cog";
        Set<String> wordList = new HashSet<>();
        wordList.add("hot");
        wordList.add("dot");
        wordList.add("dog");
        wordList.add("lot");
        wordList.add("log");
        BFS_DFS_126 solution = new BFS_DFS_126();
        List<List<String>> result = solution.findLadders(beginWord,endWord,wordList);

        for (List<String> subResult : result){
            for (String str: subResult){
                System.out.print(str + " ");
            }
            System.out.println();
        }
    }
}


