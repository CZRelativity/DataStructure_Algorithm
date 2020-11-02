package middle;

import java.util.ArrayList;
import java.util.List;

public class restoreIpAddresses93 {
    public static void main(String[] args) {
        restoreIpAddresses93 t = new restoreIpAddresses93();
        t.test();
    }

    private void test() {
        String[] eg = new String[]{"25525511135", "0000", "00000", "1111", "010010", "101023", "0279245587303"};
        for (String str : eg) {
            restoreIpAddresses(str);
            //还是可以少些一个遍历器了
            res.forEach(s -> System.out.print(s + " "));
            System.out.println();
        }
    }

    public List<String> restoreIpAddresses(String s) {
        res = new ArrayList<>();
        restore(s, new StringBuilder(s), 0, 0);
        return res;
    }

    List<String> res;

    private void restore(String s, StringBuilder builder, int dot, int i) {
        if (dot >= 3) {
            /* 为什么length-i得到的就是长度？比如length-0
            * 长度超了就不能再用<=255判断，否则有溢出的风险 */
            if (s.length() - i > 0 && s.length() - i <= 3) {
                //符合条件的最后一段，要么等于"0"，要么
                if ("0".equals(s.substring(i)) || (s.charAt(i) != '0' && Integer.parseInt(s.substring(i)) <= 255)) {
                    res.add(builder.toString());
                }
            }
            return;
        }
        for (int j = 0; j < 3; j++) {
            //length<12的时候不能每个子串都遍历到3
            if (i + j > s.length() - 1) {
                break;
            }
            //剪枝
            if (j == 2 && Integer.parseInt(s.substring(i, i + j + 1)) > 255) {
                break;
            }
            /* StringBuilder对象的方法返回的也是StringBuilder对象，在回溯时很好用，这里的索引就很讲究了
            *  插入的位置：当前索引在s中的位置i+j，当前索引在builder中的位置i+j+dot，插入到当前元素后，+1
            * 一直是针对s使用的subString和charAt方法，则传递的是s中的索引，i+j+1*/
            restore(s, new StringBuilder(builder).insert(i + j + dot + 1, '.'), dot + 1, i + j + 1);
            //首位为0只能打断，当前栈结束
            if (j == 0 && s.charAt(i + j) == '0') {
                break;
            }
        }
    }
}
