package easy;

public class isPalindromeStr125 {
    public static void main(String[] args) {
        isPalindromeStr125 t=new isPalindromeStr125();
        String eg1="A man, a plan, a canal: Panama";
        String eg2="race a car";
        String egn="";
        String egs="a";
        String eg3="0P";
        boolean res= t.isPalindrome(eg3);
        System.out.println(res);
    }

    //时间99%，内存87%
    public boolean isPalindrome(String s) {
        //空字符串，right=-1,单字符,right=0
        int left = 0, right = s.length() - 1;
        int cL, cR;
        while (left < right) {
            //用int来比较更简洁呀,api,下次一定!
            cL = parseChar(s.charAt(left));
            cR = parseChar(s.charAt(right));
            if(cL==-1){
                ++left;
                continue;
            }
            if(cR==-1){
                right--;
                continue;
            }
            if(cL!=cR){
                return false;
            }
            ++left;
            --right;
        }
        return true;
    }

    private int parseChar(char c) {
        //还需要考虑数字字符
        if ((c >= 'a' && c <= 'z')||(c>='0'&&c<='9')) {
            return c;
            //转换小写
        } else if (c >= 'A' && c <= 'Z') {
            return c + 32;
        }
        //无效的字符一律-1
        return -1;
    }
}
