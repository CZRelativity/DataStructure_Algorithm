package algorithm;

public class KMP {
    public static void main(String[] args){
        KMP t=new KMP();
        System.out.println(t.match("ABBBABABBAABABABBBBB", "ABABABB"));
    }

    public int matchPrimitive(String s1,String s2){
        char[] sArr1=s1.toCharArray();
        char[] sArr2=s2.toCharArray();
        for(int i=0,i1,i2;i<=sArr1.length-sArr2.length;i++){
            if(sArr1[i]==sArr2[0]){
                i1=i+1;
                i2=1;
                while(i2<sArr2.length){
                    if(sArr1[i1]==sArr2[i2]){
                        i1++;
                        i2++;
                    }else{
                        break;
                    }
                }
                if(i2==sArr2.length){
                    return i;
                }
            }
        }
        return -1;
    }

    public int match(String s1,String s2){
        //先求s2的next数组
        char[] s1Arr=s1.toCharArray();
        char[] s2Arr=s2.toCharArray();
        int[] next= getNextArr(s2Arr);
        for(int i1=0,i2=0;i1<=s1Arr.length-s2Arr.length;){
            // i1不要回溯了
            if(s1Arr[i1]==s2Arr[i2]){
                i1++;
                i2++;
                if(i2==s2Arr.length){
                    return i1;
                }
            }else{
                // next数组是从1到length的，所以下标+1，next[]的值表示模式串到哪个位不匹配的时候，之后把模式串的哪个位与主串的当前位比较
                // next[j]常常是小于j的哈，所以模式串在右移
                // next=0是一个标记，表示第一位就不匹配的时候，则模式串的第一位与主串当前的下一位做匹配
                i2=next[i2+1];
                if(i2==0){
                    i1++;
                }
            }
        }
        return -1;
    }

    public int[] getNextArr(char[] s2Arr){
        // next[]不写成1到length就会报错吗 ???
        int[] next=new int[s2Arr.length+1];
        int j=2;
        next[1]=0;
        next[2]=1;
        int t=next[j];
        while(j<s2Arr.length){
            if(s2Arr[t]==s2Arr[j]){
                // 这里本来就是相当于next[j+1]=t+1，也就是在前1位的循环里写后一位的值，所以循环的退出条件应该比next的length-1(s2Arr的length)还要小，
                // 否则溢出，这部分的意思：相等的时候表示前缀子串和后缀子串，即最长公共子串可直接添上相等的这一位，即长度可直接加1，
                // 又因为next[]为最长公共子串长度+1，所以直接得到next[j+1]=next[j]+1
                t++;
                j++;
                next[j]=t;
            }else{
                // 由于next[]是最长公共子串长度+1，所以继续找最长公共子串，把前一个最长公共子串+1(next[])继续上面的比较
                t=next[t];
                // 如果next[]=0了说明已经没有公共子串了，但是又不是第一位就不匹配的，所以next[j+1]=1 ???
                if(t==0){
                    j++;
                    next[j]=1;
                }
            }
        }
        return next;
    }
}
