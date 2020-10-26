package middle;

import java.util.ArrayList;
import java.util.List;

public class generateParenthesis22 {
    public static void main(String[] args) {
        generateParenthesis22 t=new generateParenthesis22();
        t.generateParenthesis(3);
        for(String s: t.parenthesisList){
            System.out.print(s+" ");
        }
    }

    List<String> parenthesisList=new ArrayList<>();

    public List<String> generateParenthesis(int n) {
        generate(new StringBuilder(),n,n);
        return parenthesisList;
    }

//    public void generate(StringBuilder builder,int i,int stack,int n){
//        if(builder.length()==n*2){
//            parenthesisList.add(builder.toString());
//        }else if (stack==0){
//            for(;i<n;i++){
//                StringBuilder builder1=new StringBuilder(builder);
//                builder1.append("(");
//                stack++;
//                generate(builder1,i+1,stack,n);
//                while(stack!=0){
//                    StringBuilder builder2=new StringBuilder(builder);
//                    builder2.append(")");
//                    stack--;
//                    generate(builder2,i,stack,n);
//                }
//            }
//        }
//    }


    /**括号可以看成隐式的树结构，"("")"可分别看作左右结点，作为递归条件完美
     * 这样以来可以写深度优先df和广度优先bf
     * 生成括号，深度优先
     */
    public void generate(StringBuilder builder,int left,int right){
        if(left==0&&right==0){
            parenthesisList.add(builder.toString());
        }
        /*由于String的特性，每次拼接都会产生新的对象，所以直接使用String拼接其实是不用写回溯的
        * 但是StringBuilder可以自由控制引用和拷贝，同时节约空间，个人倾向于使用*/
        if(left>0){
            generate(new StringBuilder(builder).append("("),left-1,right);
        }
        if (right>0&&right>left){
            generate(new StringBuilder(builder).append(")"),left,right-1);
        }
    }
}
