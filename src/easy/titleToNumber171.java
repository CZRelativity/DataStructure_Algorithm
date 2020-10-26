package easy;

public class titleToNumber171 {
    public static void main(String[] args){
        titleToNumber171 t=new titleToNumber171();
        String eg1="A";
        String eg2="AB";
        String eg3="ZY";
        String eg4="";
        int res=t.titleToNumber(eg4);
        System.out.println(res);
    }

    public int titleToNumber(String s) {
        int sum=0;
        for(int i=0;i<s.length();i++){
            sum=sum*26+s.charAt(i)-'@';
        }
        return sum;
    }
}
