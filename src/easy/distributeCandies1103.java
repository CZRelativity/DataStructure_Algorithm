package easy;

import java.util.Arrays;

public class distributeCandies1103 {
    public static void main(String[] args) {
        distributeCandies1103 t = new distributeCandies1103();
        t.test();
    }

    private void test() {
        int[] egC = {7, 10};
        int[] egN = {4, 3};
        for (int i = 0; i < egC.length; i++) {
            System.out.println(Arrays.toString(distributeCandies(egC[i], egN[i])));
        }
    }

    //90%
    public int[] distributeCandies(int candies, int num_people) {
        int[] distribute = new int[num_people];
        int start = 1;
        while (true) {
            for (int i = 0; i < num_people; i++) {
                if (candies < start) {
                    distribute[i] += candies;
                    return distribute;
                }
                distribute[i] += start;
                candies -= start;
                start++;
            }
        }
    }
}
