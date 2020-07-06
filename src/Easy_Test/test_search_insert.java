package Easy_Test;

import Easy.search_insert;

public class test_search_insert {
    public static void main(String[] args) {
        search_insert t=new search_insert();
        int[] nums={1,3,5,6};
//        System.out.println(t.Search_Original(nums,5));
//        System.out.println(t.Search_Original(nums,2));
//        System.out.println(t.Search_Original(nums,7));
//        System.out.println(t.Search_Original(nums,0));
        System.out.println(t.Search_Middle(nums,5));
        System.out.println(t.Search_Middle(nums,2));
        System.out.println(t.Search_Middle(nums,7));
        System.out.println(t.Search_Middle(nums,0));
    }
}
