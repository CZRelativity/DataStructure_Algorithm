package algorithm;

import java.util.*;

public class Greedy {
    public static void main(String[] args){
        Greedy t=new Greedy();
        Collections.addAll(t.radios,new String[]{"北京","上海","天津"},new String[]{"广州","北京","深圳"},
                new String[]{"成都","上海","杭州"},new String[]{"上海","天津"},new String[]{"杭州","大连"});
        //Collections.addAll()方法优先级高于Arrays.addAll(),且...elements可以使用显式省略创建数组
        for(String[] s:t.radios){
            //Set集合可有效避免重复
            Collections.addAll(t.areas,s);
        }
        System.out.println(Arrays.toString(t.solve()));
    }

    //使用不会出现重复的Set集合！
    Set<String> areas=new HashSet<>();
    //使用有序且可以用下标查找的List集合！
    List<String[]> radios=new ArrayList<>();

    public int[] solve(){
        //遍历次数
        int size=radios.size();
        //结果是一个存下标（选择的所有电台号）的数组
        int answerSize=0;
        int[] answer=new int[size];
        //当前覆盖了最多未覆盖地区的电台下标
        int pick;
        //计数 每次遍历中每个电台各包含了几个未覆盖地区的数组
        int[] counts;
        //直到覆盖了全部的地区（areasSet被清空）
        while(!areas.isEmpty()){
            counts=new int[size];
            pick=0;
            String[] sArr;
            //遍历所有的广播电台
            for(int i=0;i<size;i++){
                sArr=radios.get(i);
                //遍历广播电台的所有覆盖地区，记下各包含了多少未覆盖地区
                for (String s:sArr){
                    if(areas.contains(s)){
                        counts[i]++;
                    }
                }
            }
            //得到覆盖最多的电台号
            for(int j=1;j<size;j++){
                if(counts[j]>counts[pick]){
                    pick=j;
                }
            }
            //将选择的电台覆盖的所有地区remove
            for(String s:radios.get(pick)){
                areas.remove(s);
            }
            //已选择的电台号存入结果数组
            answer[answerSize++]=pick;
        }
        return answer;
    }
}
