package middle;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class findRepeatedDnaSequences187 {
    public static void main(String[] args) {
        findRepeatedDnaSequences187 t = new findRepeatedDnaSequences187();
        t.test();
    }

    private void test() {
        String[] eg = {"AAAAAAAAAAA", "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT", "AAAAAAAAAAAAA",};
        for (String e : eg) {
            System.out.println(findRepeatedDnaSequences(e));
        }
    }

    public List<String> findRepeatedDnaSequences(String s) {
        HashMap<String, Integer> dnaMap = new HashMap<>();
        List<String> repeated = new ArrayList<>();
        //i=s.length-10时,s.substring(s.length-10,s.length)
        for (int i = 0; i < s.length() - 9; i++) {
            String curDna = s.substring(i, i + 10);
            if (dnaMap.containsKey(curDna)) {
                if (dnaMap.get(curDna) == 0) {
                    repeated.add(curDna);
                }
                dnaMap.put(curDna, 1);
            } else {
                dnaMap.put(s.substring(i, i + 10), 0);
            }
        }
        return repeated;
    }
}
