package tools;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GeneralTool {

    public static void main(String[] args) {
        GeneralTool t = new GeneralTool();
        t.test();
    }

    private void test() {
        String[] eg = {"[[2]]", "[-10,-3,0,5,9]", "[[2],[3,4],[6,5,7],[4,1,8,3]]", "[\n" +
                "  [0,1,2,0],\n" +
                "  [3,4,5,2],\n" +
                "  [1,3,1,5]\n" +
                "]"};
        for (String s : eg) {
            System.out.println(Arrays.deepToString(getArr2(s)));
        }
    }

    //一阶序列预处理
    private static String parse1(String eg) {
        return eg.substring(1, eg.length() - 1).replaceAll(" ", "");
    }

    //二阶序列预处理
    private static String[] parse2(String eg) {
        //去除空格，去除换行
        String parse = eg.replaceAll(" ", "").replaceAll("\\n", "");
        //去除两边的[[ ]]
        return parse.substring(2, parse.length() - 2).split("],\\[");
    }

    public static char[][] strArr2CharMatrix(String[] eg) {
        List<char[]> ret = new ArrayList<>();
        for (String e : eg) {
            ret.add(e.toCharArray());
        }
        return ret.toArray(new char[0][0]);
    }

    public static List<int[]> compare2StrMatrix(String[][] m1, String[][] m2) {
        List<int[]> dif = new ArrayList<>();
        for (int i = 0; i < m1.length; i++) {
            for (int j = 0; j < m1[0].length; j++) {
                if (!m1[i][j].equals(m2[i][j])) {
                    dif.add(new int[]{i, j});
                }
            }
        }
        return dif;
    }

    public static char[][] strMatrix2CharMatrix(String[][] m) {
        char[][] ret = new char[m.length][m[0].length];
        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m[0].length; j++) {
                ret[i][j] = m[i][j].charAt(0);
            }
        }
        return ret;
    }

    public static Integer[] getBoxedArr1(String eg) {
        return getBoxedArr(parse1(eg));
    }

    public static Integer[][] getBoxedArr2(String eg) {
        List<Integer[]> ret = new ArrayList<>();
        for (String e : parse2(eg)) {
            ret.add(getBoxedArr(e));
        }
        return ret.toArray(new Integer[0][0]);
    }

    public static int[] getArr1(String eg) {
        if ("".equals(eg)) {
            return new int[0];
        }
        return Arrays.stream(getBoxedArr1(eg)).mapToInt(Integer::intValue).toArray();
    }

    public static int[][] getArr2(String eg) {
        if ("".equals(eg)) {
            return new int[0][0];
        }
        List<int[]> ret = new ArrayList<>();

        for (String e : parse2(eg)) {
            ret.add(Arrays.stream(getBoxedArr(e)).mapToInt(Integer::intValue).toArray());
        }
        return ret.toArray(new int[0][0]);
    }

    public static List<Integer> getList1(String eg) {
        if ("".equals(eg)) {
            return new ArrayList<>();
        }
        return Arrays.asList(getBoxedArr1(eg));
    }

    public static List<List<Integer>> getList2(String eg) {
        List<List<Integer>> ret = new ArrayList<>();
        if ("".equals(eg)) {
            return ret;
        }
        for (String e : parse2(eg)) {
            ret.add(Arrays.asList(getBoxedArr(e)));
        }
        return ret;
    }

    //底层方法
    private static Integer[] getBoxedArr(String e) {
        String[] eSplit = e.split(",");
        int length = eSplit.length;
        Integer[] ret = new Integer[length];
        for (int i = 0; i < length; i++) {
            ret[i] = Integer.parseInt(eSplit[i]);
        }
        return ret;
    }
}
