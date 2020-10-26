package easy;

public class convertToTitle168 {
    public static void main(String[] args){
        convertToTitle168 t=new convertToTitle168();
        int eg1=1;
        int eg2=28;
        int eg3=701;
        String res=t.convertToTitle(eg2);
        System.out.println(res);
    }

    public String convertToTitle(int n) {
        //没有0是一个很严重的问题，每一阶-1，就造出了0
        StringBuilder title=new StringBuilder();
        while(n>0){
            //‘A’ 65,StringBuilder放前面用.insert(0,...)
            --n;
            title.insert(0,(char)(n%26+65));
            n/=26;
        }
        return title.toString();
    }
}
