package middle;

import java.util.*;

public class LRUCache146 {
    public static void main(String[] args){
        LRUCache146 t=new LRUCache146();
        t.test();
    }

    private void test(){
        String[][] egC={{"LRUCache","put","put","get","put","get","put","get","get","get"},
                {"LRUCache","get","put","get","put","put","get","get"},
                {"LRUCache","put","put","get","put","put","get"},
                {"LRUCache","put","put","put","put","get","get"}};
        int[][][] egP={{{2},{1,1},{2,2},{1},{3,3},{2},{4,4},{1},{3},{4},},
                {{2},{2,},{2,6},{1,},{1,5},{1,2},{1,},{2}},
                {{2},{2,1},{2,2},{2},{1,1},{4,1},{2}},
                {{2},{2,1},{1,1},{2,3},{4,1},{1},{2}}};
        for(int i=0;i<egC.length;i++){
            parseInput(List.of(egC[i]),List.of(egP[i]));
            System.out.println();
        }
    }

    private void parseInput(List<String> command,List<int[]> param){
        LRUCache cache = new LRUCache(0);
        for(int i=0;i<command.size();i++){
            switch (command.get(i)){
                case "LRUCache":
                    cache=new LRUCache(param.get(i)[0]);
                    break;
                case "get":
                    System.out.println(cache.get(param.get(i)[0]));
                    break;
                case "put":
                    cache.put(param.get(i)[0],param.get(i)[1]);
                    break;
                default:
                    break;
            }
        }

    }

    //太慢了！！！ 9%
    class LRUCache {

        HashMap<Integer,Integer> cacheMap;
        Deque<Integer> keyQueue;
        int capacity;

        public LRUCache(int capacity) {
            this.capacity=capacity;
            cacheMap=new HashMap<>(capacity);
            keyQueue =new LinkedList<>();
        }

        public int get(int key) {
            /* return cacheMap.containsKey(key)? cacheMap.get(key):-1;
             * 可使用getOrDefault方法替换 */
            int value=cacheMap.getOrDefault(key,-1);
            if(value!=-1){
                //强制转对象，否则认为是remove(index)
                keyQueue.remove(key);
                keyQueue.add(key);
            }
            return value;
        }

        public void put(int key, int value) {
            //key存在的时候只会更新不会加空间，所以也不用腾空间，但是要刷新key在队列中的位置到最后
            if(cacheMap.size()== capacity&&
                    !cacheMap.containsKey(key)){
                cacheMap.remove(keyQueue.peek());
                keyQueue.remove();
                /* ArrayList的remove方法在size=1的时候使用会导致空指针，即不能移除成空集合
                ...size等于2也不行，好像是不能移除头元素？ */
            }else if(keyQueue.size()>1&&cacheMap.containsKey(key)){
                keyQueue.remove(key);
            }
            cacheMap.put(key,value);
            keyQueue.add(key);
        }

    }
}
