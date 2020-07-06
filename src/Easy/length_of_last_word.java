package Easy;

public class length_of_last_word {
    public int Length_Original(String s){
        if (s.length()==0)return 0;
        if (!s.contains(" "))return s.length();
        int i=s.length()-1,count=0;
        while (i!=-1&&s.charAt(i)==' '){
            i--;
        }
        if (i==-1)return 0;
        while (i!=-1&&s.charAt(i)!=' '){
            count++;
            i--;
        }
        return count;
    }
}
