package middle;

import java.util.*;

public class ladderLength127 {
    public static void main(String[] args) {
        ladderLength127 t = new ladderLength127();
        t.test();
    }

    private void test() {
        String egB = "hit";
        String egE = "cog";
        String[][] egList = {{"hot", "dot", "dog", "lot", "log", "cog"}, {"hot", "dot", "dog", "lot", "log"}};
        for (int i = 0; i < egList.length; i++) {
            System.out.println(ladderLengthBfs(egB, egE, Arrays.asList(egList[i].clone())));
        }
    }

    boolean[] used;
    int step;
    String endWord;

    //    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
//        used = new boolean[wordList.size()];
//        step = Integer.MAX_VALUE;
//        dfs(beginWord, endWord, 1, wordList);
//        return step == Integer.MAX_VALUE ? 0 : step;
//    }
//
//    private void dfs(String begin, String end, int step, List<String> wordList) {
//        if (begin.equals(end)) {
//            if (step < this.step) {
//                this.step = step;
//            }
//        }
//        for (int i = 0; i < wordList.size(); i++) {
//            if (!used[i] && countDif(begin, wordList.get(i)) == 1) {
//                used[i] = true;
//                dfs(wordList.get(i), end, step + 1, wordList);
//                used[i] = false;
//            }
//        }
//    }
//
    private int countDif(String begin, String target) {
        int dif = 0;
        for (int i = 0; i < begin.length(); i++) {
            if (begin.charAt(i) != target.charAt(i)) {
                dif++;
            }
        }
        return dif;
    }

    public int ladderLengthBfs(String beginWord, String endWord, List<String> wordList) {
        Set<String> wordSet = new HashSet<>(wordList);
        if (!wordSet.contains(endWord)) {
            return 0;
        }
        this.step = 1;
        this.endWord = endWord;
        Queue<String> q1 = new LinkedList<>();
        Queue<String> q2 = new LinkedList<>();
        q1.add(beginWord);
        return bfs(q1, q2, wordSet);
    }

    //单向 61%
    private int bfs(Queue<String> q, Queue<String> qNext, Set<String> wordSet) {
        if (q.isEmpty()) {
            return 0;
        }
        while (!q.isEmpty()) {
            String cur = q.remove();
            /* 这个才是关键，因为用例的wordList实在是太长了
             * 如果用注释的方法遍历wordList去挨个判断是不是只有1位不同的话直接超时
             * 反而因为用例的单词都比较短，所以把起点单词的每一位用26个字母依次替换
             * 检查wordList里面有没有，可以节省大量时间，其实是因为set结构较大优化了
             * 检索方法？ */
            char[] curChars = cur.toCharArray();
            for (int i = 0; i < cur.length(); i++) {
                char origin = curChars[i];
                for (char a = 'a'; a <= 'z'; a++) {
                    if (origin == a) {
                        continue;
                    }
                    curChars[i] = a;
                    String replace = String.valueOf(curChars);
                    if (wordSet.contains(replace)) {
                        wordSet.remove(replace);
                        qNext.add(replace);
                    }
                }
                curChars[i] = origin;
            }
//            for (String w : wordSet) {
//                if (countDif(cur, w) == 1) {
//                    qNext.add(w);
//                }
//            }
        }
        step++;
        if (qNext.contains(endWord)) {
            return step;
        }
//        for(String w:qNext){
//            wordSet.remove(w);
//        }
        return bfs(qNext, q, wordSet);
    }
}
