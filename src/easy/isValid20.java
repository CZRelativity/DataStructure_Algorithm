package easy;

import java.util.HashMap;
import java.util.Stack;

public class isValid20 {

    public static void main(String[] args) {
        isValid20 t = new isValid20();
        t.test();
    }

    private void test() {
        String[] eg = {"", "([)", "(([]){})","["};
        for (String e : eg) {
            System.out.println(isValid(e));
        }
    }

    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == ')' || c == ']' || c == '}') {
                if (stack.isEmpty()) {
                    return false;
                }
                if (c == ')' && stack.pop() != '(') {
                    return false;
                }
                if (c == ']' && stack.pop() != '[') {
                    return false;
                }
                if (c == '}' && stack.pop() != '{') {
                    return false;
                }
            } else {
                stack.push(c);
            }
        }
        return stack.isEmpty();
    }

    HashMap<Character, Character> map = new HashMap<>();

    public boolean isValidOriginal(String s) {
        int i = 0;
        while (i < s.length() / 2) {
            if (s.charAt(i) + 1 == s.charAt(i + 1)) {
                i += 2;
            } else if (s.charAt(i) + 1 == s.charAt(s.length() - 1 - i)) {
                i++;
            } else return false;
        }
        return true;
    }

    public boolean isValidSpecific(String s) {
        if (s.equals("")) return true;
        if (s.length() % 2 == 1) return false;
        int i = 0;
        while (i == 0 || i <= s.length() / 2 - 1) {
            switch (s.charAt(i)) {
                case '(':
                    if (s.charAt(i + 1) == ')') {
                        i += 2;
                        break;
                    } else if (s.charAt(s.length() - 1 - i) == ')') {
                        i++;
                        break;
                    } else return false;
                case '[':
                    if (s.charAt(i + 1) == ']') {
                        i += 2;
                        break;
                    } else if (s.charAt(s.length() - 1 - i) == ']') {
                        i++;
                        break;
                    } else return false;
                case '{':
                    if (s.charAt(i + 1) == '}') {
                        i += 2;
                        break;
                    } else if (s.charAt(s.length() - 1 - i) == '}') {
                        i++;
                        break;
                    } else return false;
                default:
                    return false;
            }
        }
        return true;
    }

    public boolean isValidSubString(String s) {
        if (s.equals("")) return true;
        if (s.length() % 2 == 1) return false;
        while (s.contains("()") || s.contains("[]") || s.contains("{}")) {
            int i = 0;
            if (s.contains("()")) {
                i = s.indexOf("()");
            } else if (s.contains("[]")) {
                i = s.indexOf("[]");
            } else if (s.contains("{}")) {
                i = s.indexOf("{}");
            }
            s = new StringBuilder(s).delete(i, i + 2).toString();
        }
        return s.equals("");
    }

    public boolean isValidStack(String s) {
        map.put(')', '(');
        map.put(']', '[');
        map.put('}', '{');
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (map.containsKey(c)) {
                if (stack.empty() || stack.pop() != map.get(c)) return false;
            } else stack.push(c);
        }
        return stack.empty();
    }
}
