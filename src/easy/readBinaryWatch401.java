package easy;

import java.util.ArrayList;
import java.util.List;

public class readBinaryWatch401 {

    public static void main(String[] args){
        readBinaryWatch401 t=new readBinaryWatch401();
        t.solveOriginal(2);
        for(String s: t.timeList){
            System.out.print(s+" ");
        }
    }

    List<String> timeList = new ArrayList<>();

    public List<String> solveOriginal(int num) {
        boolean[] light = new boolean[10];
        lightOneLEDFrom(0, light, num);
        return timeList;
    }

    public void lightOneLEDFrom(int start, boolean[] light, int num) {
        if (num == 0) {
            light2TimeString(light);
        } else {
            boolean[] curLight;
            for (int i = start; i < 10; i++) {
                curLight= light.clone();
                curLight[i] = true;
                lightOneLEDFrom(i+1, curLight, num-1);
            }
        }
    }

    public void light2TimeString(boolean[] light) {
        int hour = 0, minute = 0;
        for (int i = 0; i < 10; i++) {
            if (i < 4) {
                if (light[i]) {
                    //Math.pow(a,b),返回a的b次幂的值
                    hour += 8 / (Math.pow(2, i));
                }
            } else {
                if (light[i]) {
                    minute += 32 / (Math.pow(2, i - 4));
                }
            }
        }
        if(hour>11||minute>59){
            return;
        }
        StringBuilder time = new StringBuilder();
        time.append(hour).append(":");
        if (minute < 10) {
            time.append('0');
        }
        time.append(minute);
        timeList.add(time.toString());
    }
}
