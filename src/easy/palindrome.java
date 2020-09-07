package easy;

public class palindrome {
    public static void main(String[] args) {
        palindrome t=new palindrome();
        System.out.println(t.palindromeOriginal(121));
        System.out.println(t.palindromeOriginal(-121));
        System.out.println(t.palindromeOriginal(10));
    }

    public boolean palindromeOriginal(int x) {
        String x_string = Integer.toString(x);
        String r_string = new StringBuilder(x_string).reverse().toString();
        return r_string.equals(x_string);
    }
}
