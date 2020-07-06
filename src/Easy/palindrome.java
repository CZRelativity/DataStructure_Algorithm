package Easy;

public class palindrome {
    public boolean Palindrome_Original(int x) {
        String x_string = Integer.toString(x);
        String r_string = new StringBuilder(x_string).reverse().toString();
        return r_string.equals(x_string) ? true : false;
    }
}
