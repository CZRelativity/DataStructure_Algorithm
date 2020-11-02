package middle;

import java.util.Arrays;

public class computeArea223 {
    public static void main(String[] args){
        computeArea223 t=new computeArea223();
        t.test();
    }

    private void test(){
        int[][] eg={{-2,-2,2,2,3,3,4,4,},{-3, 0, 3, 4, 0, -1, 9, 2},};
        for(int[] e:eg){
            System.out.println(computeArea(e[0],e[1],e[2],e[3],e[4],e[5],e[6],e[7]));
        }
    }

    public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
        //(x2-x1)*(y2-y1)
        int sum=(C-A)*(D-B)+(G-E)*(H-F);
        /* Bx2<Ax1||By2<Ay1||Ax2<Bx1||Ay2<By1
        * 没有交集 */
        if(G<A||H<B||C<E||D<F){
            return sum;
        }
        /* 相交部分的坐标，小里取大，大里取小 max(Ax1,Bx1) */
        int Ix1=Math.max(A,E);
        //min(Ax2,Bx2)
        int Ix2=Math.min(C,G);
        //max(Ay1,By1)
        int Iy1=Math.max(B,F);
        //min(Ay2,By2)
        int Iy2=Math.min(D,H);
        return sum-(Ix2-Ix1)*(Iy2-Iy1);
    }
}
