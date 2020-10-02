package easy;

import java.util.HashMap;
import java.util.Map;

public class roma2Int {
    public static void main(String[] args) {
        roma2Int t = new roma2Int();
        System.out.println(t.romaOriginal("III"));
        System.out.println(t.romaOriginal("IV"));
        System.out.println(t.romaOriginal("IX"));
        System.out.println(t.romaOriginal("LVIII"));
        System.out.println(t.romaOriginal("MCMXCIV"));
    }

    public int romaOriginal(String s) {
        char[] romaChars = s.toCharArray();
        int result = 0;
        for (int i = 0; i < romaChars.length; i++) {
            switch (romaChars[i]) {
                case 'I':
                    if (i != romaChars.length - 1 && (romaChars[i + 1] == 'V'
                            || romaChars[i + 1] == 'X')) {
                        result--;
                    } else result++;
                    break;

                case 'V':
                    result += 5;
                    break;
                case 'X':
                    if (i != romaChars.length - 1 && (romaChars[i + 1] == 'L'
                            || romaChars[i + 1] == 'C')) {
                        result -= 10;
                    } else result += 10;
                    break;
                case 'L':
                    result += 50;
                    break;
                case 'C':
                    if (i != romaChars.length - 1 && (romaChars[i + 1] == 'D'
                            || romaChars[i + 1] == 'M')) {
                        result -= 100;
                    } else result += 100;
                    break;
                case 'D':
                    result += 500;
                    break;
                case 'M':
                    result += 1000;
                    break;
                default:
                    break;
            }
        }
        return result;
    }
    public int romaHashMap(String s){
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
