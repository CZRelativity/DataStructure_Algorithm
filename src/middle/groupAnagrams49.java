package middle;

import java.util.*;

public class groupAnagrams49 {
    public static void main(String[] args) {
        groupAnagrams49 t = new groupAnagrams49();
        String[] eg1 = new String[]{"eat", "tea", "tan", "ate", "nat", "bat"};
        List<List<String>> res = t.groupAnagrams(eg1);
        for (List<String> line : res) {
            for (String str : line) {
                System.out.print(str + " ");
            }
            System.out.println();
        }
    }

    //思路：排序作为key，相同key放在一行
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> res = new ArrayList<>();
        if(strs.length==0){
            return res;
        }
        HashMap<String, String> strMap = new HashMap<>();
        for (String str : strs) {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            strMap.put(str, String.valueOf(chars));
        }
        //重遍历所有str，按照value值存放
        for (String str : strs) {
            //先创建第一行
            if (res.isEmpty()) {
                List<String> newLine = new ArrayList<>();
                newLine.add(str);
                res.add(newLine);
            } else {
                //遍历行,与行首元素的value值比较，相同则属于同一行
                int i=0;
                for (;i<res.size();i++) {
                    List<String> line=res.get(i);
                    if (strMap.get(line.get(0)).equals(strMap.get(str))) {
                        line.add(str);
                        break;
                    }
                }
                //没有找到匹配的行，创建新行
                if(i==res.size()){
                    List<String> newLine = new ArrayList<>();
                    newLine.add(str);
                    res.add(newLine);
                }
            }
        }
        return res;
    }
}
