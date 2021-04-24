package middle;

import java.util.*;

public class LRUCache146 {
    public static void main(String[] args) {
        LRUCache146 t = new LRUCache146();
        t.test();
    }

    private void test() {
        String[][] egC = {{"LRUCache", "put", "put", "get", "put", "get", "put", "get", "get", "get"},
                {"LRUCache", "get", "put", "get", "put", "put", "get", "get"},
                {"LRUCache", "put", "put", "get", "put", "put", "get"},
                {"LRUCache", "put", "put", "put", "put", "get", "get"}};
        int[][][] egP = {{{2}, {1, 1}, {2, 2}, {1}, {3, 3}, {2}, {4, 4}, {1}, {3}, {4},},
                {{2}, {2,}, {2, 6}, {1,}, {1, 5}, {1, 2}, {1,}, {2}},
                {{2}, {2, 1}, {2, 2}, {2}, {1, 1}, {4, 1}, {2}},
                {{2}, {2, 1}, {1, 1}, {2, 3}, {4, 1}, {1}, {2}}};
        for (int i = 0; i < egC.length; i++) {
            parseInput(List.of(egC[i]), List.of(egP[i]));
            System.out.println();
        }
    }

    private void parseInput(List<String> command, List<int[]> param) {
        LRUCache cache = null;
        for (int i = 0; i < command.size(); i++) {
            switch (command.get(i)) {
                case "LRUCache":
                    cache = new LRUCache(param.get(i)[0]);
                    break;
                case "get":
                    System.out.println(cache.get(param.get(i)[0]));
                    break;
                case "put":
                    cache.put(param.get(i)[0], param.get(i)[1]);
                    break;
                default:
                    break;
            }
        }

    }

//    class LRUCache {
//
//        HashMap<Integer, Integer> map;
//        int capacity;
//        DoubleListNode head;
//        DoubleListNode end;
//
//        public LRUCache(int capacity) {
//            head = new DoubleListNode(-1);
//            end = new DoubleListNode(-2);
//            head.next = end;
//            end.pre = head;
//            map = new HashMap<>();
//            this.capacity = capacity;
//        }
//
//        public int get(int key) {
//            if (map.containsKey(key)) {
//                searchAndReInsert(key);
//                return map.get(key);
//            } else {
//                return -1;
//            }
//        }
//
//        public void put(int key, int value) {
//            if (map.containsKey(key)) {
//                searchAndReInsert(key);
//            } else {
//                if (map.size() == capacity) {
//                    //map也要remove！否则map里面还有链表里面没有就会空指针
//                    map.remove(end.pre.val);
//
//                    delete(end.pre);
//                }
//                insert(new DoubleListNode(key));
//            }
//            map.put(key, value);
//        }
//
//        //查找必然是有的，因为我们先用HashMap确认了
//        private void searchAndReInsert(int val) {
//            DoubleListNode left = head;
//            DoubleListNode right = end;
//            DoubleListNode save = null;
//            while (left != null && right != null && left != right) {
//                left = left.next;
//                if (left.val == val) {
//                    save = left;
//                    delete(left);
//                    break;
//                }
//                right = right.pre;
//                if (right.val == val) {
//                    save = right;
//                    delete(right);
//                    break;
//                }
//            }
//            insert(save);
//        }
//
//        private void delete(DoubleListNode node) {
//            node.pre.next = node.next;
//            node.next.pre = node.pre;
//        }
//
//        private void insert(DoubleListNode node) {
//            node.next = head.next;
//            node.pre = head;
//            head.next.pre = node;
//            head.next = node;
//        }
//
//        class DoubleListNode {
//
//            public DoubleListNode(int val) {
//                this.val = val;
//            }
//
//            int val;
//            DoubleListNode next;
//            DoubleListNode pre;
//
//        }
//    }

    //太慢了！！！ 9%
//    class LRUCache {
//
//        HashMap<Integer, Integer> cacheMap;
//        Deque<Integer> keyQueue;
//        int capacity;
//
//        public LRUCache(int capacity) {
//            this.capacity = capacity;
//            cacheMap = new HashMap<>(capacity);
//            keyQueue = new LinkedList<>();
//        }
//
//        public int get(int key) {
//            /* return cacheMap.containsKey(key)? cacheMap.get(key):-1;
//             * 可使用getOrDefault方法替换 */
//            int value = cacheMap.getOrDefault(key, -1);
//            if (value != -1) {
//                //强制转对象，否则认为是remove(index)
//                keyQueue.remove(key);
//                keyQueue.add(key);
//            }
//            return value;
//        }
//
//        public void put(int key, int value) {
//            //key存在的时候只会更新不会加空间，所以也不用腾空间，但是要刷新key在队列中的位置到最后
//            if (cacheMap.size() == capacity &&
//                    !cacheMap.containsKey(key)) {
//                cacheMap.remove(keyQueue.peek());
//                keyQueue.remove();
//                /* ArrayList的remove方法在size=1的时候使用会导致空指针，即不能移除成空集合
//                ...size等于2也不行，好像是不能移除头元素？ */
//            } else if (keyQueue.size() > 1 && cacheMap.containsKey(key)) {
//                keyQueue.remove(key);
//            }
//            cacheMap.put(key, value);
//            keyQueue.add(key);
//        }
//
//    }

    //泛型不熟
    class LRUCache extends LinkedHashMap<Integer, Integer> {

        final int capacity;

        //返回true的时候removeEldestEntry
        @Override
        protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
            return size() > capacity;
        }

        //要get以后也重新排序的话，必须使用三参数的构造方法，第二个参数使用默认0.75f，第三参数true
        public LRUCache(int capacity) {
            super(capacity, 0.75f, true);
            this.capacity = capacity;
        }

        @Override
        public Integer get(Object key) {
            return getOrDefault(key, -1);
//            Integer ret = super.get(key);
//            return ret == null ? -1 : ret;
        }
    }
}
