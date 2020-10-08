package easy;

public class addBinary67 {
    public static void main(String[] args){
        addBinary67 t=new addBinary67();
        String a1="11";
        String b1="1";
        String a2="1010";
        String b2="1011";
        String a3="10100000100100110110010000010101111011011001101110111111111101000000101111001110001111100001101";
        String b3="110101001011101110001111100110001010100001101011101010000011011011001011101111001100000011011110011";
        String result= t.solveOriginal(a3,b3);
        System.out.println(result);
    }

    //时间62%，转成十进制你就输了
    public String solveOriginal(String a,String b){
        int lengthA=a.length(),lengthB=b.length(),maxLength=Math.max(lengthA,lengthB);
        StringBuilder zeros=new StringBuilder();
        //jdk11,String.repeat(times)
        zeros.append("0".repeat(Math.abs(lengthA - lengthB)));
        if(lengthA>lengthB){
            b=zeros.append(b).toString();
        }else {
            a=zeros.append(a).toString();
        }
        StringBuilder result= new StringBuilder();
        int carry=0;
        for(int j=maxLength-1;j>-1;j--){
            int sum=(a.charAt(j)-'0')+(b.charAt(j)-'0')+carry;
            carry=0;
            if(sum>=2){
                sum-=2;
                carry=1;
            }
            result.insert(0, sum);
        }
        if(carry==1){
            result.insert(0,1);
        }
        return result.toString();
    }

//    public int binary2Int(String binary){
//        int i=0,num=0;
//        while(i<binary.length()){
//            num=num*2+binary.charAt(i)-'0';
//            i++;
//        }
//        return num;
//    }

//    public String int2Binary(int num){
//
//    }
}
