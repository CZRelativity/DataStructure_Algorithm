package middle;

import java.util.HashMap;

public class int2Roman12 {
    public static void main(String[] args) {
        int2Roman12 t=new int2Roman12();
        int eg1=3;
        int eg2=4;
        int eg3=9;
        int eg4=58;
        int eg5=1994;
        String result=t.solveOriginal(eg1);
        System.out.println(result);
    }

    HashMap<Integer, String> romanMap = new HashMap<>();

    public int2Roman12() {
        romanMap.put(1, "I");
        romanMap.put(4, "IV");
        romanMap.put(5, "V");
        romanMap.put(9,"IX");
        romanMap.put(10, "X");
        romanMap.put(40, "XL");
        romanMap.put(50, "L");
        romanMap.put(90, "XC");
        romanMap.put(100, "C");
        romanMap.put(400, "CD");
        romanMap.put(500, "D");
        romanMap.put(900, "CM");
        romanMap.put(1000, "M");
    }

    //时间13%，淦
    public String solveOriginal(int num) {
        StringBuilder roman = new StringBuilder();
        for(int curCalculate=1000;curCalculate>0;curCalculate/=10){
            if (num / curCalculate > 0) {
                int curBit = num / curCalculate;
                if (curBit == 9) {
                    roman.append(romanMap.get(9*curCalculate));
                } else if (curBit == 4) {
                    roman.append(romanMap.get(4*curCalculate));
                } else {
                    if (curBit >= 5) {
                        roman.append(romanMap.get(5*curCalculate));
                        curBit -= 5;
                    }
                    while (curBit > 0) {
                        roman.append(romanMap.get(curCalculate));
                        curBit--;
                    }
                }
                num=num%curCalculate;
            }
        }
        return roman.toString();
    }
}
