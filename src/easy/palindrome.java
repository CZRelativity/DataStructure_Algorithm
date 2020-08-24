package easy;

public class palindrome {
    public static void main(String[] args) {
        palindrome t=new palindrome();
        System.out.println(t.Palindrome_Original(121));
        System.out.println(t.Palindrome_Original(-121));
        System.out.println(t.Palindrome_Original(10));
    }

    public boolean Palindrome_Original(int x) {
        String x_string = Integer.toString(x);
        String r_string = new StringBuilder(x_string).reverse().toString();
        return r_string.equals(x_string) ? true : false;
    }
}
