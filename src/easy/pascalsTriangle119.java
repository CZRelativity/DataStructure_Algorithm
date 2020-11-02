package easy;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class pascalsTriangle119 {
    public static void main(String[] args) {
        pascalsTriangle119 t=new pascalsTriangle119();
        List<Integer> integerList=t.getRow(31);
        integerList.forEach(s->System.out.print(s+" "));
    }

    /* 时间复杂度O(k),公式法 Ak=Ak-1*(n-k)/k (k为0到n-1)
    * 考虑31以上会溢出，如果后一半拷贝会更快，不过公式是可以一直算到底的 */
    public List<Integer> getRow(int rowIndex) {
        ++rowIndex;
        long[] row=new long[rowIndex];
        row[0]=1;
        int i;
        for(i=1;i<rowIndex/2;i++){
            row[i]=row[i-1]*(rowIndex-i)/i;
        }
        return Arrays.stream(row).mapToInt(s->(int)s).boxed().collect(Collectors.toList());
    }
}
