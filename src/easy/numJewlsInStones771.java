package easy;

public class numJewlsInStones771 {
    public static void main(String[] args) {
        numJewlsInStones771 t = new numJewlsInStones771();
        t.test();
    }

    private void test() {
        String[] egJewels = {"EXoODCGRiT", "aA", "z"};
        String[] egStones = {"DrQZz", "aAAbbbb", "ZZ"};
        for (int i = 0; i < egJewels.length; i++) {
            System.out.println(numJewelsInStones(egJewels[i], egStones[i]));
        }
    }

    public int numJewelsInStones(String jewels, String stones) {
        int[] count = new int[52];
        for (int i = 0; i < stones.length(); i++) {
            char stone = stones.charAt(i);
            //细节：<=
            if (stone <= 'Z') {
                count[stone - 'A']++;
            } else {
                count[stone - 'a' + 26]++;
            }
        }
        int ret = 0;
        for (int i = 0; i < jewels.length(); i++) {
            char jewel = jewels.charAt(i);
            if (jewel <= 'Z') {
                ret += count[jewel - 'A'];
            } else {
                ret += count[jewel - 'a' + 26];
            }
        }
        return ret;
    }
}
