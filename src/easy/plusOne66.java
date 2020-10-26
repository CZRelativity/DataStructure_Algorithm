package easy;

import java.util.Arrays;

public class plusOne66 {
    public static void main(String[] args) {
        plusOne66 t = new plusOne66();
        int[] eg1 = new int[]{1, 2, 3};
        int[] eg2 = new int[]{4, 3, 2, 1};
        int[] eg3 = new int[]{9, 9, 9};
        int[] eg4=new int[]{};
        int[] eg5=new int[]{0};
        int[] res = t.plusOne(eg4);
        System.out.println(Arrays.toString(res));
    }

    public int[] plusOne(int[] digits) {
        if(digits.length==0){
            return digits;
        }
        digits[digits.length - 1] += 1;
        for (int i = digits.length - 1; i > 0; i--) {
            if (digits[i] == 10) {
                digits[i - 1] += 1;
                digits[i] = 0;
            }
        }
        if (digits[0] == 10) {
            digits[0] = 0;
            int[] res = new int[digits.length + 1];
            res[0] = 1;
            System.arraycopy(digits, 0, res, 1, digits.length);
            return res;
        } else {
            return digits;
        }
    }
}
