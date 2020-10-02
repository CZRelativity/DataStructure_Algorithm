package easy;

public class reverse {
    public static void main(String[] args) {
        reverse t = new reverse();
        System.out.println(t.reverseOriginal(123));
        System.out.println(t.reverseSimple(-123));
        System.out.println(t.reverseStringException(120));
    }

    public int reverseOriginal(int x) {
        int temp = x;
        short x_bit = 0;
        while (temp != 0) {
            temp = temp / 10;
            x_bit++;
        }
        long result = 0;
        short y_bit = 0;
        while (x_bit != 0) {
            temp = (int) (x / Math.pow(10, x_bit - 1));
            result += temp * Math.pow(10, y_bit);
            x = (int) (x - temp * Math.pow(10, x_bit - 1));
            x_bit--;
            y_bit++;
        }
        if (result < -Math.pow(2, 31) || result > Math.pow(2, 31) - 1) {
            return 0;
        } else return (int) result;
    }

    public int reverseStringException(int x) {
        String xString = Integer.toString(x);
        String string = xString;
        short flag = 1;
        if (x < 0) {
            flag = -1;
            string = xString.substring(1);
        }
        try {
            return Integer.parseInt(new StringBuilder(string).reverse().toString()) * flag;
        } catch (Exception e) {
            return 0;
        }
    }

    public int reverseSimple(int x) {
        long temp = 0;
        while (x != 0) {
            temp = temp * 10 + x % 10;
            x = x / 10;
        }
        return (int) temp == temp ? (int) temp : 0;
    }
}
