package Easy_Test;

import Easy.climb_stairs;

public class test_climb_stairs {
    public static void main(String[] args) {
        climb_stairs t=new climb_stairs();
        System.out.println(t.Climb_Original(1));
        System.out.println(t.Climb_Original(2));
        System.out.println(t.Climb_Original(3));
        System.out.println(t.Climb_Original(4));
        System.out.println(t.Climb_Original(5));
        System.out.println(t.Climb_Iteration(5));
        System.out.println(t.Climb_Original(45));
    }
}
