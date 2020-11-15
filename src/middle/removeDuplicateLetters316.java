package middle;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class removeDuplicateLetters316 {
    public static void main(String[] args) {
        removeDuplicateLetters316 t = new removeDuplicateLetters316();
        t.test();
    }

    private void test() {
        String[] eg = {"bcabc", "cbacdcbc", "mitnlruhznjfyzmtmfnstsxwktxlboxutbic"};
        for (String e : eg) {
            System.out.println(removeDuplicateLetters(e));
        }
    }

    boolean[] isContained;

    List<String> subList;

    //回溯+排序，TimeOut
    public String removeDuplicateLettersBackTrack(String s) {
        isContained = new boolean[26];
        subList = new ArrayList<>();
        int count = 0;
        char cur;
        for (int i = 0; i < s.length(); i++) {
            cur = s.charAt(i);
            if (!isContained[cur - 'a']) {
                isContained[cur - 'a'] = true;
                count++;
            }
        }
        isContained = new boolean[26];
        generate(new StringBuilder(), s, 0, count);
        Collections.sort(subList);
        return subList.get(0);
    }

    private void generate(StringBuilder builder, String s, int start, int count) {
        if (builder.length() == count) {
            subList.add(builder.toString());
            return;
        }
        char cur;
        for (int i = start; i < s.length(); i++) {
            cur = s.charAt(i);
            if (!isContained[cur - 'a']) {
                isContained[cur - 'a'] = true;
                generate(new StringBuilder(builder).append(cur), s, i + 1, count);
                isContained[cur - 'a'] = false;
            }
        }
    }

    public String removeDuplicateLetters(String s) {
        int[] counts = new int[26];
        boolean[] inStack = new boolean[26];
        char[] chars = s.toCharArray();
        for (char cur : chars) {
            counts[cur - 'a']++;
        }
        Stack<Character> uniqueStack = new Stack<>();
        /* 为什么用栈，栈也是为了保持一个插入的顺序，即不改变字母的相对位置，
        然后如果有序号很小的字母从后面插入，在后面还有这个字母的情况下可以一直往前推 */
        for (char cur : chars) {
            counts[cur - 'a']--;
            if (!inStack[cur - 'a']) {
                while (!uniqueStack.isEmpty() && counts[uniqueStack.peek() - 'a'] > 0 && cur < uniqueStack.peek()) {
                    inStack[uniqueStack.pop() - 'a'] = false;
                }
                uniqueStack.push(cur);
                inStack[cur - 'a'] = true;
            }
        }
        StringBuilder ret = new StringBuilder();
        while (!uniqueStack.isEmpty()) {
            ret.append(uniqueStack.pop());
        }
        return ret.reverse().toString();
    }
}
