package Easy;

public class strStr {
    public int StrStr_Original(String haystack,String needle){
        if (haystack.contains(needle)) {
            return haystack.indexOf(needle);
        }else return -1;
    }
}
