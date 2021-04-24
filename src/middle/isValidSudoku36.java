package middle;

import tools.GeneralTool;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class isValidSudoku36 {
    public static void main(String[] args) {
        isValidSudoku36 t = new isValidSudoku36();
        t.test();
    }

    private void test() {
        String[][] eg = {
                {"53  7    ", "6  195   ",
                        " 98    6 ", "8   6   3",
                        "4  8 3  1", "7   2   6",
                        " 6    28 ", "   419  5",
                        "    8  79"},
        };

        for (String[] e : eg) {
            System.out.println(isValidSudokuArr(GeneralTool.strArr2CharMatrix(e)));
        }
    }

    //传统HashMap解法 时间54%
    public boolean isValidSudokuMap(char[][] board) {
        HashMap<Character, List<int[]>> posMap = new HashMap<>();
        char digit;
        List<int[]> posList;
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (Character.isDigit(board[i][j])) {
                    digit = board[i][j];
                    if (posMap.containsKey(digit)) {
                        posList = posMap.get(digit);
                        for (int[] pos : posList) {
                            if (pos[0] == i || pos[1] == j ||
                                    /*解释：数独引入了一个3x3的宫的概念，9x9总共被划分成3x3 9个宫
                                     * 如果把每个3x3的宫看成一个格子，那么[0,0]可以代表左上的宫，
                                     * [2,2]可以代表右下的宫，以此类推，宫的坐标，正好是实际格子的坐标都/3的结果*/
                                    ((pos[0] / 3 == i / 3) && (pos[1] / 3 == j / 3))) {
                                return false;
                            }
                        }
                    } else {
                        posList = new ArrayList<>();
                        posMap.put(digit, posList);
                    }
                    posList.add(new int[]{i, j});
                }
            }
        }
        return true;
    }

    //巧妙数组解法 时间96%
    public boolean isValidSudokuArr(char[][] board) {
        //row[1][1]=1表示 1行存过了1，列同理
        int[][] row = new int[9][9];
        int[][] column = new int[9][9];
        /*
        3x3大格子（宫）号用0-9来表示，计算方法是x/3*3+y/3，/3再*3可以取整数倍啊居然，
         7 8都会被取整数倍到6，巧
        */
        int[][] box = new int[9][9];
        int digit;
        int boxId;
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                //数独的数字是从1-9的，所以-'1'
                digit = board[i][j] - '1';
                if (digit >= 0 && digit <= 9) {
                    boxId = i / 3 * 3 + j / 3;
                    if (row[i][digit] == 1 || column[j][digit] == 1 || box[boxId][digit] == 1) {
                        return false;
                    } else {
                        row[i][digit]++;
                        column[j][digit]++;
                        box[boxId][digit]++;
                    }
                }
            }
        }
        return true;
    }
}
