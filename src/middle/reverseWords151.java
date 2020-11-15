package middle;

import java.util.Stack;

public class reverseWords151 {
    public static void main(String[] args) {
        reverseWords151 t = new reverseWords151();
        t.test();
    }

    private void test() {
        String[] eg = {"f df asdasd", "EPY2giL", "the sky is blue", "   hello world!   ", "a good    example",
                "  Bob    Loves  Alice   ", "Alice does not even like bob"};
        for (String e : eg) {
            System.out.println(reverseWordsO1(e));
        }
    }

    public String reverseWords(String s) {
        Stack<String> strStack = new Stack<>();
        int start = 0, end = 0;
        int length = s.length();
        while (end < length) {
            if (start == end && s.charAt(start) == ' ') {
                start++;
                end++;
            } else {
                if (s.charAt(end) == ' ') {
                    strStack.push(s.substring(start, end));
                    start = end;
                } else {
                    end++;
                    //要start end都不为空格才能进入这个分支
                    if (end == length) {
                        strStack.push(s.substring(start));
                    }
                }
            }
        }
        StringBuilder res = new StringBuilder();
        while (strStack.size() > 1) {
            res.append(strStack.pop()).append(' ');
        }
        return res.append(strStack.pop()).toString();
    }

    //从后往前 双指针，提升不大，反而复杂化了
    public String reverseWordsO1(String s) {
        int length = s.length(), start = length - 1, end = length - 1;
        StringBuilder res = new StringBuilder();
        while (start > -1) {
            //排除连续空格，使用start-1可以使end位置在单词后的空格，方便使用subString(),但是边界条件给👴整吐了
            if (start == end && s.charAt(start) == ' ') {
                start--;
                end--;
                /* start!=end，找到了一个单词，
                同理，使用start-1作为边界条件可以使start位于单词的首字母，使用subString()的时候不用再偏移 */
            } else if (s.charAt(start) == ' ') {
                if (end == length - 1) {
                    /* StringBuilder.append可以直接传入索引参数省去String.subString()
                     * 结尾的情况 */
                    res.append(s.substring(start + 1)).append(' ');
                } else {
                    res.append(s, start + 1, end + 1).append(' ');
                }
                end = start;
            } else {
                //开头的情况
                if (start == 0) {
                    if (end == length - 1) {
                        res.append(s);
                    } else {
                        res.append(s, start, end + 1);
                    }
                }
                // 要start end都不为空格才能进入这个分支
                start--;
            }
        }
        String strRes = res.toString();
        //去掉结尾可能存在的空格
        return strRes.charAt(strRes.length() - 1) == ' ' ? strRes.substring(0, strRes.length() - 1) : strRes;
    }
}
