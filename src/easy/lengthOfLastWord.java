package easy;

public class lengthOfLastWord {
    public static void main(String[] args) {
        lengthOfLastWord t=new lengthOfLastWord();
        System.out.println(t.lengthOriginal("Hello World"));
        System.out.println(t.lengthOriginal("a "));
        System.out.println(t.lengthOriginal("b a  "));
        System.out.println(t.lengthOriginal("       "));
    }

    public int lengthOriginal(String s){
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
