package easy;

import java.util.HashMap;

public class isIsomorphic205 {
    public static void main(String[] args) {
        isIsomorphic205 t = new isIsomorphic205();
        String eg1s = "egg";
        String eg1t = "add";
        String eg2s = "foo";
        String eg2t = "bar";
        String eg3s = "paper";
        String eg3t = "title";
        String eg4s = "ab";
        String eg4t = "aa";
        System.out.println(t.isIsomorphic(eg4s, eg4t));
    }

    public boolean isIsomorphic(String s, String t) {
        return isOrientIsomorphic(s,t)&&isOrientIsomorphic(t,s);
    }

    /* 相比每次循环判断HashMap.containsValue(),正反执行两次更快
    * 料想该方法时间复杂度较高 */
    private boolean isOrientIsomorphic(String s,String t){
        HashMap<Character, Character> reflect = new HashMap<>();
        int length = s.length();
        for (int i = 0; i < length; i++) {
            char cS = s.charAt(i);
            char cT = t.charAt(i);
            if (reflect.containsKey(cS)) {
                if (reflect.get(cS) != cT) {
                    return false;
                }
            } else {
                reflect.put(cS, cT);
            }
        }
        return true;
    }
}
