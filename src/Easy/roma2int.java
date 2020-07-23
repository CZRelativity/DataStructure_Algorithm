package Easy;

import java.util.HashMap;
import java.util.Map;

public class roma2int {
    public static void main(String[] args) {
        roma2int t = new roma2int();
        System.out.println(t.Roma_Original("III"));
        System.out.println(t.Roma_Original("IV"));
        System.out.println(t.Roma_Original("IX"));
        System.out.println(t.Roma_Original("LVIII"));
        System.out.println(t.Roma_Original("MCMXCIV"));
    }

    public int Roma_Original(String s) {
        char[] roma_chars = s.toCharArray();
        int result = 0;
        for (int i = 0; i < roma_chars.length; i++) {
            switch (roma_chars[i]) {
                case 'I':
                    if (i != roma_chars.length - 1 && (roma_chars[i + 1] == 'V'
                            || roma_chars[i + 1] == 'X')) {
                        result--;
                    } else result++;
                    break;

                case 'V':
                    result += 5;
                    break;
                case 'X':
                    if (i != roma_chars.length - 1 && (roma_chars[i + 1] == 'L'
                            || roma_chars[i + 1] == 'C')) {
                        result -= 10;
                    } else result += 10;
                    break;
                case 'L':
                    result += 50;
                    break;
                case 'C':
                    if (i != roma_chars.length - 1 && (roma_chars[i + 1] == 'D'
                            || roma_chars[i + 1] == 'M')) {
                        result -= 100;
                    } else result += 100;
                    break;
                case 'D':
                    result += 500;
                    break;
                case 'M':
                    result += 1000;
                    break;
            }
        }
        return result;
    }
    public int Roma_HashMap(String s){
        Map<String,Integer> map=new HashMap<>();
        map.put("I",1);
        map.put("IV",4);
        map.put("V",5);
        map.put("IX",9);
        map.put("X",10);
        map.put("XL",40);
        map.put("L",50);
        map.put("XC",90);
        map.put("C",100);
        map.put("CD",400);
        map.put("D",500);
        map.put("CM",900);
        map.put("M",1000);

        int ans=0;
        for (int i=0;i<s.length();){
            if (i+1<s.length()&&map.containsKey(s.substring(i,i+2))){
                ans+=map.get(s.substring(i,i+2));
                i+=2;
            }else {
                ans+=map.get(s.substring(i,i+1));
                i++;
            }
        }
        return ans;
    }
}
