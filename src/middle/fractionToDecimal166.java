package middle;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class fractionToDecimal166 {
    public static void main(String[] args) {
        fractionToDecimal166 t = new fractionToDecimal166();
        t.test();
    }

    public void test() {

        System.out.println(fractionToDecimal(1, 6));
        System.out.println(fractionToDecimal(1, 17));
        System.out.println(fractionToDecimal(1, 2));
        System.out.println(fractionToDecimal(2, 1));
        System.out.println(fractionToDecimal(2, 3));
        System.out.println(fractionToDecimal(4, 333));
        System.out.println(fractionToDecimal(1, 300));
        //需要解决符号
        System.out.println(fractionToDecimal(1,-3));
        //需要解决溢出
        System.out.println(fractionToDecimal(Integer.MIN_VALUE,1));

    }

    //时间100%
    public String fractionToDecimal(int numerator, int denominator) {
        //投机取巧，但是从原理上不行啦，循环不是商数字的重复，而是被除数的重复，而且答案字符串是要求可以长度上百的
//        String origin=String.valueOf((double) numerator/(double) denominator);
//        int length = origin.length();
//        if(length <12){
//            if(origin.charAt(0)=='0'){
//                return origin;
//            }else if(origin.charAt(length-1)=='0'){
//                //endIndex总是不要取到这一位
//                return origin.substring(0,length-2);
//            }
//        }
//        //可行性就在于第一个重复数字出现时必开始循环，即十个数字之内必循环，不循环的那叫无理数，不能化成分数
//        HashMap<Character,Integer> posMap=new HashMap<>();
//        StringBuilder res=new StringBuilder("0.");
//        //0.003
//        for(int i = 2; i< length; i++){
//            char cur=origin.charAt(i);
//            if(cur=='0'){
//                continue;
//            }
//            if(!posMap.containsKey(cur)){
//                posMap.put(cur,i);
//            }else {
//                int pos=posMap.get(cur);
//                //endIndex总是不要取到这一位
//                int pointer=0;
//                if(origin.charAt(i-1)=='0'){
//                    pointer=1;
//                    while (origin.charAt(pos-pointer)=='0'&&origin.charAt(i-pointer)=='0'){
//                        ++pointer;
//                    }
//                    --pointer;
//                }
//                res.append(origin, 2, pos-pointer).append("(").append(origin,pos-pointer,i-pointer).append(")");
//                break;
//            }
//        }
//        return res.toString();
        //整除解决,溢出解决
        long num=numerator,den=denominator;
        if (num % den == 0) {
            return String.valueOf(num / den);
        }
        //符号解决
        num=num>0?num:-num;
        den=den>0?den:-den;
        StringBuilder res = new StringBuilder();
        StringBuilder head = (numerator>0&&denominator<0)||(numerator<0&&denominator>0)?
                new StringBuilder("-").append(num / den).append('.')
                :new StringBuilder(String.valueOf(num / den)).append('.');
        num = num % den;
        HashMap<Long, Integer> posMap = new HashMap<>();
        int pos = 0;
        while (num % den != 0) {
            num *= 10;
            //解决补0问题，不需要补0！0可以作为商
//            while (numerator < denominator) {
//                numerator *= 10;
//                ++pos;
//            }
            if (posMap.containsKey(num)) {
                res.insert(posMap.get(num), "(");
                res.append(')');
                break;
            }
//            while (res.length()<pos){
//                res.append(0);
//            }
            posMap.put(num, pos);
            res.append(num / den);
            ++pos;
            num = num % den;
        }
        res.insert(0, head);
        return res.toString();
    }
}

