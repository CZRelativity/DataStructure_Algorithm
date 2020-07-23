package Easy;

public class length_of_last_word {
    public static void main(String[] args) {
        length_of_last_word t=new length_of_last_word();
        System.out.println(t.Length_Original("Hello World"));
        System.out.println(t.Length_Original("a "));
        System.out.println(t.Length_Original("b a  "));
        System.out.println(t.Length_Original("       "));
    }

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
